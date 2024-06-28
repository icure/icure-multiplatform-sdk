package com.icure.sdk.subscription

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.utils.InternalIcureException
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.http.HttpMethod
import io.ktor.util.PlatformUtils
import io.ktor.websocket.CloseReason
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import kotlin.math.pow
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

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
internal class WebSocketSubscription<E : Identifiable<String>> private constructor (
	private val hostname: String,
	private val path: String,
	private val webSocketAuthProvider: WebSocketAuthProvider,
	private val client: HttpClient,
	private val config: Subscription.Configuration,
	private val deserializeEntity: (String) -> E,
	private val subscriptionRequest: String
): Subscription<E> {
	companion object {
		// Should be same as on backend
		private val DURATION_BETWEEN_PINGS = 20.seconds

		suspend fun <BaseType : Identifiable<String>, NotificationEntity : BaseType> initialize(
			hostname: String,
			path: String,
			webSocketAuthProvider: WebSocketAuthProvider,
			client: HttpClient,
			config: Subscription.Configuration,
			deserializeEntity: (String) -> NotificationEntity,
			events: Set<SubscriptionEventType>,
			filter: AbstractFilter<BaseType>,
			qualifiedName: String,
			subscriptionRequestSerializer: (com.icure.sdk.model.notification.Subscription<BaseType>) -> String,
		): WebSocketSubscription<NotificationEntity> {
			val subscriptionRequest = subscriptionRequestSerializer(
				com.icure.sdk.model.notification.Subscription(
					eventTypes = events.toList(),
					filter = FilterChain(
						filter = filter,
					),
					entityClass = qualifiedName,
					accessControlKeys = null,
				),
			)
			val subscription = WebSocketSubscription(
				hostname,
				path,
				webSocketAuthProvider,
				client,
				config,
				deserializeEntity,
				subscriptionRequest
			)
			subscription.startConnection()
			return subscription
		}
	}

	private val wrapperScope = CoroutineScope(Dispatchers.Default)
	private val _eventChannel = Channel<Subscription.Event<E>>(
		capacity = config.channelBufferCapacity,
		onBufferOverflow = when (config.onBufferFull) {
			Subscription.Configuration.FullBufferBehaviour.FAIL -> BufferOverflow.SUSPEND
			Subscription.Configuration.FullBufferBehaviour.DROP_OLDEST -> BufferOverflow.DROP_OLDEST
			Subscription.Configuration.FullBufferBehaviour.IGNORE -> BufferOverflow.SUSPEND
		}
	)

	private lateinit var session: DefaultWebSocketSession
	private var intentionallyClosed = false
	private var retriesAttempt = 0
	private var lastPingJob: Job? = null

	private suspend fun send(data: String) {
		session.send(data)
	}

	override val eventChannel: ReceiveChannel<Subscription.Event<E>>
		get() = _eventChannel

	override suspend fun close() {
		closeDefinitely(null)
	}

	private suspend fun closeDefinitely(eventChannelReason: Throwable?) {
		closeWebsocket(
			code = CloseReason.Codes.NORMAL.code,
			reason = "Closed by the client",
		)
		wrapperScope.cancel()
		_eventChannel.close(eventChannelReason)
	}


	/**
	 * Close the connection definitively
	 *
	 * This will bypass the retry mechanism and close the connection
	 */
	private suspend fun closeWebsocket(code: Short, reason: String) {
		intentionallyClosed = true
		session.close(
			reason = CloseReason(
				code = code,
				message = reason,
			),
		)
		session.incoming.cancel()
		session.cancel()
	}

	/**
	 * This will launch a job that will check if a ping has been received in the last [durationBetweenPings]
	 *
	 * If no ping has been received in the last [durationBetweenPings] and the job is still active, the connection will be closed. This should ignite the reconnection mechanism.
	 *
	 * @return The job that has been launched
	 */
	private suspend fun DefaultWebSocketSession.launchPingTimeoutChecker(): Job = launch {
		delay(DURATION_BETWEEN_PINGS)
		if (isActive) {
			sendEvent(Subscription.Event.ConnectionError.MissedPing)
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
			retriesAttempt = 0
			when (frame) {
				is Frame.Text -> {
					val content = frame.readText()
					if (content == "ping") {
						lastPingJob?.cancel()
						send("pong")
						lastPingJob = session.launchPingTimeoutChecker()
					} else {
						sendEvent(try {
							Subscription.Event.EntityNotification(deserializeEntity(content))
						} catch (e: SerializationException) {
							Subscription.Event.EntityError.DeserializationError
						})
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
		if (it !is CancellationException) sendEvent(Subscription.Event.UnexpectedError(it))
	}

	/**
	 * Suspends until the connection is closed and emits the close event
	 */
	private suspend fun waitForClose() {
		val closeReason = session.closeReason.await()
		// TODO event if closed by the server?
	}

	private suspend fun startSession(): DefaultClientWebSocketSession {
		val jwtToken = webSocketAuthProvider.getBearerToken()
		return client.webSocketSession(
			method = HttpMethod.Get,
			host = hostname,
			path = path.takeIf { PlatformUtils.IS_BROWSER }?.let { "$it?jwt=${jwtToken}" } ?: path,
		) {
			if (!PlatformUtils.IS_BROWSER) {
				headers["Authorization"] = "Bearer $jwtToken"
			}
		}
	}

	private suspend fun startConnection() {
		session = startSession()

		send(subscriptionRequest)
		sendEvent(Subscription.Event.Connected)

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

		if (retriesAttempt >= config.connectionMaxRetries) {
			closeDefinitely(Subscription.ConnectionException())
		} else {
			delay(
				exponentialRetry(
					attempt = retriesAttempt++,
					baseDelay = config.reconnectionDelay.inWholeMilliseconds,
					factor = config.retryDelayExponentFactor,
				).milliseconds,
			)
			session = startSession()

			sendEvent(Subscription.Event.Reconnected)

			session.launch {
				incomingMessagesLoop()
			}

			waitForClose()
			reconnect()
		}
	}

	/**
	 * Emit an event to the listeners
	 *
	 * @param event The event to be emitted
	 *
	 */
	private suspend fun sendEvent(event: Subscription.Event<E>) {
		val sendResult = _eventChannel.trySend(event)
		if (sendResult.isFailure && config.onBufferFull == Subscription.Configuration.FullBufferBehaviour.FAIL) {
			closeDefinitely(Subscription.ChannelFullException())
		}
	}
}
