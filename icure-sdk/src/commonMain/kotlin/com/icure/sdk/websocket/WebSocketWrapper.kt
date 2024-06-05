package com.icure.sdk.websocket

import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.ensure
import io.ktor.util.InternalAPI
import io.ktor.websocket.CloseReason
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.pow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

/**
 * WebSocket wrapper that handles the connection and reconnection logic for a WebSocket connection
 *
 * The purpose of this class is to abstract the WebSocket connection and reconnection logic and provide a simple API to interact with the WebSocket connection
 *
 * Message received by the WebSocket connection are stored in a queue and processed by a callback, this allows to handle the messages in a non-blocking way and to avoid blocking the WebSocket connection (which could lead to disconnections due to Ping/Pong timeouts)
 *
 * If the queue is full, the connection will be closed and a fatal error will be emitted
 *
 * @param onOpenListeners List of listeners to be called when the WebSocket connection is opened (on the first connection)
 * @param sessionProvider Provider for the WebSocket session
 * @param retryDelay The base delay for the exponential backoff retry mechanism
 * @param retryDelayExponentFactor The factor to be used in the exponential backoff retry mechanism
 * @param maxRetries The maximum number of retries before giving up
 * @param durationBetweenPings The duration between pings to be sent to the server
 * @param channelSize The size of the queue to store messages that are sent while processing them
 * @param channelMessageCallback The callback to be called when a message is sent
 * */
@InternalAPI
class WebSocketWrapper(
	private val onOpenListeners: List<suspend (WebSocketWrapper) -> Unit>,
	private val sessionProvider: suspend () -> DefaultWebSocketSession,
	private val retryDelay: Duration,
	private val retryDelayExponentFactor: Double,
	private val maxRetries: Int,
	private val durationBetweenPings: Duration,
	channelSize: Int,
	private val channelMessageCallback: suspend (message: String, onEvent: suspend (EmittedEvent) -> Unit) -> Unit,
) {
	private val wrapperScope = CoroutineScope(Dispatchers.Default)
	private val queue = Channel<String>(
		capacity = channelSize,
	)

	private lateinit var session: DefaultWebSocketSession
	private var state: WebSocketState = WebSocketState.CONNECTING
	private var intentionallyClosed = false
	private var retriesAttempt = 0
	private var lastPingJob: Job? = null

	private val onReconnectedListeners = WebSocketEventListener<Unit>()
	private val onCloseListeners = WebSocketEventListener<Pair<Short?, String?>>()
	private val onErrorListeners = WebSocketEventListener<Pair<String?, Boolean>>()

	@OptIn(InternalIcureApi::class)
	internal suspend fun send(data: String) {
		ensure(state == WebSocketState.OPEN) { "WebSocket is not open" }
		session.send(data)
	}

	/**
	 * Close the connection definitively
	 *
	 * This will bypass the retry mechanism and close the connection
	 */
	suspend fun close(code: Short, reason: String) {
		check(state != WebSocketState.CLOSED) { "WebSocket is already closed" }
		intentionallyClosed = true
		session.close(
			reason = CloseReason(
				code = code,
				message = reason,
			),
		)
		session.incoming.cancel()
		session.cancel()
		onEvent(EmittedEvent.Close(code, reason))
		wrapperScope.cancel()
	}

	/**
	 * This will launch a job that will check if a ping has been received in the last [durationBetweenPings]
	 *
	 * If no ping has been received in the last [durationBetweenPings] and the job is still active, the connection will be closed. This should ignite the reconnection mechanism.
	 *
	 * @return The job that has been launched
	 */
	private suspend fun DefaultWebSocketSession.launchPingTimeoutChecker(): Job = launch {
		delay(durationBetweenPings)
		if (isActive) {
			onEvent(EmittedEvent.Error("Ping timeout: no ping received in the last ${durationBetweenPings.inWholeMilliseconds} ms", false))
			session.close(
				reason = CloseReason(
					code = CloseReason.Codes.NORMAL.code,
					message = "Ping timeout",
				),
			)
			session.incoming.cancel()
		}
	}

	/**
	 * Incoming messages loop that will handle the incoming messages and dispatch them to the queue or to the appropriate event.
	 *
	 * This loop will handle the ping/pong mechanism and will close the connection if no ping is received in the last [durationBetweenPings]
	 *
	 * Note: Control frames are not supported in this loop, they should not be emitted by Ktor's ReceiveChannel
	 */
	private suspend fun incomingMessagesLoop() = kotlin.runCatching {
		for (frame in session.incoming) {
			when (frame) {
				is Frame.Text -> {
					val content = frame.readText()
					if (content == "ping") {
						lastPingJob?.cancel()
						send("pong")
						lastPingJob = session.launchPingTimeoutChecker()
					} else {
						onEvent(EmittedEvent.Message(frame.readText()))
					}
				}

				is Frame.Binary -> throw InternalIcureException("Binary frames are not supported in incoming messages loop")
				is Frame.Close -> throw InternalIcureException("Close frames are not supported in incoming messages loop")
				is Frame.Ping -> throw InternalIcureException("Ping frames are not supported in incoming messages loop")
				is Frame.Pong -> throw InternalIcureException("Pong frames are not supported in incoming messages loop")
				else -> throw InternalIcureException("Unknown frame type ${frame.frameType}")
			}
		}
	}.onFailure {
		onEvent(EmittedEvent.Error(it.message, false))
	}

	/**
	 * Launch the queue consumer that will consume the messages from the queue and call the callback
	 */
	private fun launchQueueConsumer() {
		val onEventCallback: suspend (EmittedEvent) -> Unit = { event: EmittedEvent -> onEvent(event) }
		wrapperScope.launch {
			for (message in queue) {
				channelMessageCallback(message, onEventCallback)
			}
		}
	}

	/**
	 * Suspends until the connection is closed and emits the close event
	 */
	private suspend fun waitForClose() {
		val closeReason = session.closeReason.await()
		onEvent(EmittedEvent.Close(closeReason?.code, closeReason?.message))
	}

	suspend fun startConnection() {
		session = sessionProvider()

		onEvent(EmittedEvent.Connect)

		launchQueueConsumer()

		session.launch {
			incomingMessagesLoop()
		}

		wrapperScope.launch {
			waitForClose()
			reconnect()
		}
	}

	private fun exponentialRetry(
		attempt: Int,
		baseDelay: Long,
		maxDelay: Long = 30.minutes.inWholeMilliseconds,
		factor: Double,
	): Long {
		val delay = (baseDelay * factor.pow(attempt)).toLong()
		return delay.coerceAtMost(maxDelay)
	}

	private tailrec suspend fun reconnect() {
		if (intentionallyClosed) return
		session.incoming.cancel()
		session.cancel()

		if (retriesAttempt >= maxRetries) {
			onEvent(EmittedEvent.Error("Max retries reached", true))
		} else {
			delay(
				exponentialRetry(
					attempt = retriesAttempt++,
					baseDelay = retryDelay.inWholeMilliseconds,
					factor = retryDelayExponentFactor,
				).milliseconds,
			)
			session = sessionProvider()

			onEvent(EmittedEvent.Reconnect)

			session.launch {
				incomingMessagesLoop()
			}

			waitForClose()
			reconnect()
		}
	}

	/**
	 * Allows to listen to the open event
	 */
	fun onReconnect(callback: suspend (Unit) -> Unit) {
		onReconnectedListeners.addListener(callback)
	}

	/**
	 * Allows to listen to the close event
	 */
	fun onClose(callback: suspend (Short?, String?) -> Unit) {
		onCloseListeners.addListener { (code, reason) ->
			callback(code, reason)
		}
	}

	/**
	 * Allows to listen to the error event
	 */
	fun onError(callback: suspend (String?, Boolean) -> Unit) {
		onErrorListeners.addListener { (data, fatal) ->
			callback(data, fatal)
		}
	}


	/**
	 * Emit an event to the listeners
	 *
	 * @param event The event to be emitted
	 *
	 */
	private suspend fun onEvent(event: EmittedEvent) {
		when (event) {
			is EmittedEvent.Connect -> {
				state = WebSocketState.OPEN
				onOpenListeners.forEach { it(this) }
			}

			is EmittedEvent.Reconnect -> {
				state = WebSocketState.OPEN
				onReconnectedListeners.onEvent(Unit)
			}

			is EmittedEvent.Close -> {
				state = WebSocketState.CLOSED
				onCloseListeners.onEvent(event.code to event.reason)
			}

			is EmittedEvent.Error -> onErrorListeners.onEvent(event.data to event.fatal)
			is EmittedEvent.Message -> {
				queue.trySend(event.message).onFailure {
					onEvent(EmittedEvent.Error(it?.message, true))
					close(CloseReason.Codes.INTERNAL_ERROR.code, "Queue is full")
				}

				retriesAttempt = 0
			}
		}
	}
}
