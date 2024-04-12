package com.icure.sdk.websocket

import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import io.ktor.server.websocket.WebSockets
import io.ktor.server.websocket.webSocket
import io.ktor.util.InternalAPI
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@OptIn(InternalAPI::class)
class BasicWebSocketTest : StringSpec({

	val fakeWebsocketServer = embeddedServer(Netty, port = 25565) {
		install(WebSockets)
		routing {
			webSocket {
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
				println("SERVER: Sending ping")
				send(Frame.Text("ping"))
				send(Frame.Text(Json.encodeToString(DecryptedHealthElement.serializer(), DecryptedHealthElement(id = UUID.randomUUID().toString()))))
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
					send(Frame.Text(Json.encodeToString(DecryptedHealthElement.serializer(), DecryptedHealthElement(id = UUID.randomUUID().toString()))))
				}
			}
		}
	}.start(wait = false)

	afterSpec {
		fakeWebsocketServer.stop(0, 0)
	}

	"Should be able to reconnect if didn't received a ping within the configured delay" {
		val completable = CompletableDeferred<Unit>()

		val authProvider = mockk<WebSocketAuthProvider>() {
			coEvery { getBearerToken() } returns "token"
		}

		while (!fakeWebsocketServer.application.isActive) {
			delay(1.seconds)
		}

		val connection = ConnectionImpl.initialize(
			hostname = "localhost:25565",
			path = "/",
			events = setOf(SubscriptionEventType.Create),
			filter = HealthElementByHcPartyFilter(
				hcpId = "fake-uuid",
			),
			qualifiedName = "com.icure.sdk.model.health.HealthElement",
			subscriptionSerializer = { "" },
			serializer = DecryptedHealthElement.serializer(),
			webSocketAuthProvider = authProvider,
			onOpenListener = {
				println("CLIENT: Connected")
			},
			retryDelay = 500.milliseconds,
			retryDelayExponentFactor = 2.0,
			maxRetries = 5,
			durationBetweenPings = 1.seconds,
			eventCallback = { element ->
				println("CLIENT: Received HealthElement event for ${element.id}")
			},
		)

		connection.onReconnected {
			println("CLIENT: Reconnected")
			connection.close()
			completable.complete(Unit)
		}

		withTimeoutOrNull(10.seconds) {
			completable.await()
		} ?: fail("Didn't reconnected within 10 seconds")
	}

	"Should close the connection if the queue is full" {
		val completableDisconnected = CompletableDeferred<Unit>()
		val completableFatal = CompletableDeferred<Boolean>()

		val authProvider = mockk<WebSocketAuthProvider>() {
			coEvery { getBearerToken() } returns "token"
		}

		while (!fakeWebsocketServer.application.isActive) {
			delay(1.seconds)
		}

		val connection = ConnectionImpl.initialize(
			hostname = "localhost:25565",
			path = "/load",
			events = setOf(SubscriptionEventType.Create),
			filter = HealthElementByHcPartyFilter(
				hcpId = "fake-uuid",
			),
			qualifiedName = "com.icure.sdk.model.health.HealthElement",
			subscriptionSerializer = { "" },
			serializer = DecryptedHealthElement.serializer(),
			webSocketAuthProvider = authProvider,
			onOpenListener = {
				println("CLIENT: Connected")
			},
			retryDelay = 1.seconds,
			retryDelayExponentFactor = 2.0,
			maxRetries = 5,
			durationBetweenPings = 5.seconds,
			eventCallback = { element ->
				println("CLIENT: Received HealthElement event for ${element.id}")
				delay(1.seconds) // Simulate processing time
			},
		)

		connection.onError { errorMessage, fatal ->
			println("CLIENT: Error $errorMessage")
			if (fatal) {
				completableFatal.complete(fatal)
			}
		}

		connection.onDisconnected { code, reason ->
			println("CLIENT: Disconnected with code $code and reason $reason")
			completableDisconnected.complete(Unit)
		}

		withTimeoutOrNull(20.seconds) {
			completableFatal.await() shouldBe true
			completableDisconnected.await()
		} ?: fail("Didn't reconnected within 10 seconds")
	}
})
