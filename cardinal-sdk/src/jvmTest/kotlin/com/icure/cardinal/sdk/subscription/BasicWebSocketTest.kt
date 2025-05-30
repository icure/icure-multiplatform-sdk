package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.auth.services.TokenBasedAuthService
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.cardinal.sdk.serialization.HealthElementAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.newPlatformHttpClient
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import io.ktor.server.websocket.WebSockets
import io.ktor.server.websocket.webSocket
import io.ktor.websocket.CloseReason
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.channels.ChannelResult
import kotlinx.coroutines.channels.onClosed
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@InternalIcureApi
class BasicWebSocketTest : StringSpec({
	val client = newPlatformHttpClient {
		install(ContentNegotiation) {
			json(json = Serialization.json)
		}
		install(HttpTimeout)
		install(io.ktor.client.plugins.websocket.WebSockets)
	}

	val fakeWebsocketServer = embeddedServer(Netty, port = 25565) {
		install(WebSockets)
		routing {
			webSocket {
				println("SERVER: Sending ping")
				send(Frame.Text("ping"))
				send(Frame.Text(Json.encodeToString(EncryptedHealthElement.serializer(), EncryptedHealthElement(id = UUID.randomUUID().toString()))))
				close(CloseReason(CloseReason.Codes.NORMAL, "Closed by server"))
			}
			webSocket("/load") {
				launch {
					for (frame in incoming) {
						when (frame) {
							is Frame.Text -> {
								val content = frame.readText()
								println("SERVER: Received message: $content")
							}
							else -> println("SERVER: Received frame: $frame")
						}
					}
				}
				repeat(100) {
					send(Frame.Text(Json.encodeToString(EncryptedHealthElement.serializer(), EncryptedHealthElement(id = UUID.randomUUID().toString()))))
				}
			}
		}
	}.start(wait = false)

	afterSpec {
		client.close()
		fakeWebsocketServer.stop(0, 0)
	}

	"Should be able to reconnect if didn't received a ping within the configured delay" {
		val authService = mockk<TokenBasedAuthService<JwtBearer>> {
			coEvery { getToken() } returns JwtBearer("token")
		}
		val authProvider = mockk<JwtBasedAuthProvider> {
			coEvery { getAuthService() } returns authService
		}

		while (!fakeWebsocketServer.application.isActive) {
			delay(1.seconds)
		}

		val connection = WebSocketSubscription.initialize(
			client = client,
			hostname = "http://localhost:25565",
			path = "/",
			clientJson = Serialization.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = setOf(SubscriptionEventType.Create),
			filter = HealthElementByHcPartyFilter(
				hcpId = "fake-uuid",
			),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(
					SubscriptionSerializer(
						HealthElementAbstractFilterSerializer
					), it
				)
			},
			webSocketAuthProvider = authProvider,
			config = null
		)

		val events = mutableListOf<EntitySubscriptionEvent<*>>()
		withTimeoutOrNull(10.seconds) {
			do {
				events.add(connection.eventChannel.receive().also { println("Client received: $it") })
			} while (events.last() != EntitySubscriptionEvent.Reconnected)
		} ?: fail("Didn't reconnected within 10 seconds")
		events shouldContain EntitySubscriptionEvent.ConnectionError.ClosedByServer
	}

	"Should close the connection if the queue is full" {
		val authService = mockk<TokenBasedAuthService<JwtBearer>> {
			coEvery { getToken() } returns JwtBearer("token")
		}
		val authProvider = mockk<JwtBasedAuthProvider> {
			coEvery { getAuthService() } returns authService
		}


		while (!fakeWebsocketServer.application.isActive) {
			delay(1.seconds)
		}

		val connection = WebSocketSubscription.initialize(
			client = client,
			hostname = "http://localhost:25565",
			path = "/load",
			clientJson = Serialization.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = setOf(SubscriptionEventType.Create),
			filter = HealthElementByHcPartyFilter(
				hcpId = "fake-uuid",
			),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = authProvider,
			config = EntitySubscriptionConfiguration(channelBufferCapacity = 10)
		)

		withTimeoutOrNull(10.seconds) {
			while (connection.closeReason == null) {
				delay(100.milliseconds)
			}
		} ?: fail("Subscription was not closed within 10 seconds")
		connection.closeReason shouldBe EntitySubscriptionCloseReason.ChannelFull
		val received = mutableListOf<ChannelResult<EntitySubscriptionEvent<*>>>()
		do {
			received.add(connection.eventChannel.receiveCatching())
		} while (received.last().isSuccess)
		received.last().isClosed shouldBe true
		received.last().onClosed {
			println("Channel was closed")
			it shouldBe null
		}
	}
})
