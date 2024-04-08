package com.icure.sdk.websocket

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.Subscription
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.platformHttpClient
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.util.InternalAPI
import io.ktor.websocket.CloseReason
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer

interface Connection {

	/**
	 * Close the connection definitively
	 *
	 * This will bypass the retry mechanism and close the connection
	 */
	suspend fun close()

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when the connection is connected or reconnected (due to a retry)
	 */
	suspend fun onConnected(callback: suspend (Unit) -> Unit)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when the connection is disconnected, either by the server or by the client. It can be called multiple times due to retries
	 */
	suspend fun onDisconnected(callback: (code: Short?, reason: String?) -> Unit)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when an error occurs
	 */
	suspend fun onError(callback: (errorMessage: String?) -> Unit)
}

@OptIn(InternalAPI::class)
class ConnectionImpl<EncryptedType: BaseType, BaseType: Identifiable<String>>(
	private val hostname: String,
	private val path: String,
	events: Set<SubscriptionEventType>,
	filter: AbstractFilter<BaseType>,
	qualifiedName: String,
	subscriptionSerializer: (Subscription<BaseType>) -> String,
	private val serializer: KSerializer<EncryptedType>,
	private val channelCallback: suspend (ReceiveChannel<EncryptedType>) -> Unit,
) : Connection {
	private val connectionScope = CoroutineScope(Dispatchers.Default)
	private lateinit var webSocketWrapper: WebSocketWrapper

	private val client = platformHttpClient {
		install(WebSockets) {
			contentConverter = KotlinxWebsocketSerializationConverter(Serialization.json)
		}
	}

	init {
		connectionScope.launch {
			val session = createWebSocketSession()
			val queue = Channel<EncryptedType>()

			webSocketWrapper = WebSocketWrapper(
				session
			) {
				createWebSocketSession()
			}

			try {
				channelCallback(queue)
			} catch (e: Exception) {
				webSocketWrapper.onEvent(EmittedEvent.Error(e.message))
			}

			onConnected {
				val subscription = Subscription(
					eventTypes = events.toList(),
					filter = FilterChain(
						filter = filter
					),
					entityClass = qualifiedName,
					accessControlKeys = null
				)

				webSocketWrapper.send(
					subscriptionSerializer(subscription)
				)
			}

			webSocketWrapper.startConnection { message ->
				queue.send(
					Serialization.json.decodeFromString(serializer, message)
				)
			}
		}
	}

	private suspend fun createWebSocketSession() = client.webSocketSession(
		method = HttpMethod.Get,
		host = hostname,
		path = path,
	)

	override suspend fun close() {
		webSocketWrapper.close(
			code = CloseReason.Codes.NORMAL.code,
			reason = "Connection closed by client"
		)
		connectionScope.cancel()
	}

	override suspend fun onConnected(callback: suspend (Unit) -> Unit) {
		webSocketWrapper.onOpen(callback)
	}

	override suspend fun onDisconnected(callback: (code: Short?, reason: String?) -> Unit) {
		webSocketWrapper.onClose(callback)
	}

	override suspend fun onError(callback: (errorMessage: String?) -> Unit) {
		webSocketWrapper.onError(callback)
	}
}
