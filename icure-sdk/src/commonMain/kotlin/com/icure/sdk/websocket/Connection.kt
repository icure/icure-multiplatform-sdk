package com.icure.sdk.websocket

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.Subscription
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.platformHttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.util.InternalAPI
import io.ktor.util.PlatformUtils
import io.ktor.websocket.CloseReason
import kotlinx.coroutines.channels.Channel
import kotlinx.serialization.KSerializer
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

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
	 * @param callback The callback to be called when the connection is reconnected (due to a retry)
	 */
	suspend fun onReconnected(callback: suspend (Unit) -> Unit)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when the connection is disconnected, either by the server or by the client. It can be called multiple times due to retries
	 * - `code` The close code
	 * - `reason` The close reason
	 */
	suspend fun onDisconnected(callback: (code: Short?, reason: String?) -> Unit)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when an error occurs
	 * - `errorMessage` The error message
	 * - `fatal` Whether the error is fatal or not, if `fatal` is `true`, the connection will be closed and have to be re-established by the client
	 */
	suspend fun onError(callback: (errorMessage: String?, fatal: Boolean) -> Unit)
}

@InternalAPI
class ConnectionImpl private constructor(
	private val webSocketWrapper: WebSocketWrapper,
) : Connection {

	companion object {
		private val client = platformHttpClient {
			install(WebSockets) {
				contentConverter = KotlinxWebsocketSerializationConverter(Serialization.json)
			}
		}

		private suspend fun createWebSocketSession(
			hostname: String,
			path: String,
			webSocketAuthProvider: WebSocketAuthProvider,
		): DefaultClientWebSocketSession {
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

		/**
		 * Subscription event message that will be sent to the Kraken
		 *
		 * @param wsw WebSocketWrapper instance
		 * @param events The events type to subscribe to
		 * @param filter The filter to apply to the subscription
		 * @param qualifiedName The Kraken's qualified name of the entity
		 * @param subscriptionSerializer The serializer to use to serialize the subscription
		 *
		 */
		private suspend fun <BaseType : Identifiable<String>> subscriptionEvent(
			wsw: WebSocketWrapper,
			events: Set<SubscriptionEventType>,
			filter: AbstractFilter<BaseType>,
			qualifiedName: String,
			subscriptionSerializer: (Subscription<BaseType>) -> String,
		) {
			wsw.send(
				subscriptionSerializer(
					Subscription(
						eventTypes = events.toList(),
						filter = FilterChain(
							filter = filter,
						),
						entityClass = qualifiedName,
						accessControlKeys = null,
					),
				),
			)
		}

		/**
		 * Create the listeners for the connection
		 *
		 * @param onConnectedListener Public facing listener to be called when the connection is established
		 * @param subscriptionEvent The subscription event to be sent to the Kraken when the connection is established
		 *
		 * @return A list of listeners to be added to the WebSocketWrapper instance on connection
		 */
		private suspend fun onConnectedListeners(
			onConnectedListener: suspend () -> Unit,
			subscriptionEvent: suspend (WebSocketWrapper) -> Unit,
		): List<suspend (WebSocketWrapper) -> Unit> {
			val onConnectedMapped: suspend (WebSocketWrapper) -> Unit = { _: WebSocketWrapper ->
				onConnectedListener()
			}

			return listOf(
				onConnectedMapped,
				subscriptionEvent,
			)
		}

		suspend fun <EncryptedType : BaseType, BaseType : Identifiable<String>> initialize(
			hostname: String,
			path: String,
			events: Set<SubscriptionEventType>,
			filter: AbstractFilter<BaseType>,
			qualifiedName: String,
			subscriptionSerializer: (Subscription<BaseType>) -> String,
			serializer: KSerializer<EncryptedType>,
			webSocketAuthProvider: WebSocketAuthProvider,
			onOpenListener: suspend () -> Unit,
			retryDelay: Duration,
			retryDelayExponentFactor: Double,
			maxRetries: Int,
			durationBetweenPings: Duration = 20.seconds,
			channelCapacity: Int = Channel.BUFFERED,
			eventCallback: suspend (EncryptedType) -> Unit,
		): ConnectionImpl {
			val subscriptionEvent: suspend (WebSocketWrapper) -> Unit = { wsw ->
				subscriptionEvent(
					wsw,
					events,
					filter,
					qualifiedName,
					subscriptionSerializer,
				)
			}

			val webSocketWrapper = WebSocketWrapper(
				onOpenListeners = onConnectedListeners(
					onConnectedListener = onOpenListener,
					subscriptionEvent = subscriptionEvent,
				),
				sessionProvider = {
					createWebSocketSession(
						hostname = hostname,
						path = path,
						webSocketAuthProvider = webSocketAuthProvider,
					)
				},
				retryDelay = retryDelay,
				retryDelayExponentFactor = retryDelayExponentFactor,
				maxRetries = maxRetries,
				durationBetweenPings = durationBetweenPings,
				queueSize = channelCapacity,
				queueCallback = { message ->
					eventCallback(
						Serialization.json.decodeFromString(serializer, message),
					)
				},
			)

			webSocketWrapper.startConnection()

			return ConnectionImpl(
				webSocketWrapper = webSocketWrapper,
			).also {
				it.onReconnected {
					subscriptionEvent(webSocketWrapper)
				}
			}
		}
	}

	override suspend fun close() {
		webSocketWrapper.close(
			code = CloseReason.Codes.NORMAL.code,
			reason = "Connection closed by client",
		)
	}

	override suspend fun onReconnected(callback: suspend (Unit) -> Unit) {
		webSocketWrapper.onReconnect(callback)
	}

	override suspend fun onDisconnected(callback: (code: Short?, reason: String?) -> Unit) {
		webSocketWrapper.onClose(callback)
	}

	override suspend fun onError(callback: (errorMessage: String?, fatal: Boolean) -> Unit) {
		webSocketWrapper.onError(callback)
	}
}
