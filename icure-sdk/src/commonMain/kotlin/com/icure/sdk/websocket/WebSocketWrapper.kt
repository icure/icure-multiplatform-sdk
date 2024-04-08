package com.icure.sdk.websocket

import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.ensure
import io.ktor.client.plugins.websocket.*
import io.ktor.util.*
import io.ktor.websocket.*
import kotlinx.coroutines.launch

@InternalAPI
class WebSocketWrapper(
    private var session: ClientWebSocketSession,
    private val sessionProvider: suspend () -> ClientWebSocketSession
) {
    private var state: WebSocketState = WebSocketState.CONNECTING

    private val onOpenListeners = WebSocketEventListener<Unit>()
    private val onCloseListeners = WebSocketEventListener<Pair<Short?, String?>>()
    private val onErrorListeners = WebSocketEventListener<String?>()

    @OptIn(InternalIcureApi::class)
    internal suspend fun send(data: String) {
        ensure(state == WebSocketState.OPEN) { "WebSocket is not open" }
        session.send(data)
    }

    suspend fun close(code: Short, reason: String) {
        check(state != WebSocketState.CLOSED) { "WebSocket is already closed" }
        session.close(
            reason = CloseReason(
                code = code,
                message = reason
            )
        )
        onEvent(EmittedEvent.Close(code, reason))
    }

    suspend fun startConnection(stringMessageCallback: suspend (message: String) -> Unit) {
        session.launch {
            onEvent(EmittedEvent.Open)

            kotlin.runCatching {
                for (frame in session.incoming) {
                    when (frame) {
                        is Frame.Text -> {
                            val content = frame.readText()
                            if (content == "ping") {
                                session.send("pong")
                            } else {
                                onEvent(EmittedEvent.Message(frame.readText()))
                                stringMessageCallback(frame.readText())
                            }
                        }

                        is Frame.Binary -> {
                            throw InternalIcureException("Binary frames are not supported")
                        }

                        is Frame.Close -> frame.readReason().let { reason ->
                            onEvent(EmittedEvent.Close(reason?.code, reason?.message))
                        }

                        is Frame.Ping -> TODO("I don't know if it's HTTP ping or ping payload")
                        is Frame.Pong -> TODO("I don't know if it's HTTP pong or pong payload")
                        else -> TODO()
                    }
                }
            }.onFailure {
                onEvent(EmittedEvent.Error(it.message))
            }
        }
    }

    /**
     * Allows to listen to the open event
     */
    fun onOpen(callback: suspend (Unit) -> Unit) {
        onOpenListeners.addListener(callback)
    }

    /**
     * Allows to listen to the close event
     */
    fun onClose(callback: (Short?, String?) -> Unit) {
        onCloseListeners.addListener { (code, reason) ->
            callback(code, reason)
        }
    }

    /**
     * Allows to listen to the error event
     */
    fun onError(callback: (String?) -> Unit) {
        onErrorListeners.addListener(callback)
    }

    internal suspend fun onEvent(event: EmittedEvent) {
        when (event) {
            is EmittedEvent.Open -> {
                state = WebSocketState.OPEN
                onOpenListeners.onMessage(Unit)
            }

            is EmittedEvent.Close -> {
                state = WebSocketState.CLOSED
                onCloseListeners.onMessage(event.code to event.reason)
            }

            is EmittedEvent.Error -> onErrorListeners.onMessage(event.data)
            is EmittedEvent.Message -> {}
        }
    }
}
