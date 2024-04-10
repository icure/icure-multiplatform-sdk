package com.icure.sdk.websocket

import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@OptIn(InternalAPI::class)
class BasicWebSocketTest : StringSpec({

	lateinit var  hcpUser: DataOwnerDetails

	beforeSpec {
		initialiseTestEnvironment()
		hcpUser = createHcpUser()
	}

	"Should subscribe to HealthElement updates" {
		val completable = CompletableDeferred<Unit>()

		val connection = hcpUser
			.api()
			.healthElement
			.encrypted
			.subscribeToEvents(
				events = setOf(SubscriptionEventType.Create),
				filter = HealthElementByHcPartyFilter(
					hcpId = hcpUser.dataOwnerId,
				),
				onConnected = {
					println("Connected")
					completable.complete(Unit)
				}
			) {
				println(it.id)
			}

		withTimeoutOrNull(5.seconds) {
			completable.await()
			connection.close()

		} ?: fail("Didn't received OPEN event within 5 seconds")
	}

	"Should be able to listen to HealthElement creation updates" {
		val completable = CompletableDeferred<Unit>()

		val connection = hcpUser
			.api()
			.healthElement
			.encrypted
			.subscribeToEvents(
				setOf(SubscriptionEventType.Create),
				HealthElementByHcPartyFilter(
					hcpId = hcpUser.dataOwnerId,
				),
			) {
				println("Received HealthElement creation event for ${it.id}")
				completable.complete(Unit)
			}.also { connection ->
				connection.onReconnected {
					println("Connected")
				}
			}

		val patient = hcpUser
			.api()
			.patient
			.initialiseEncryptionMetadata(
				DecryptedPatient(id = UUID.randomUUID().toString())
			).let {
				hcpUser.api().patient.encryptAndCreate(it)
			}

		val currentUser = hcpUser.api().user.getCurrentUser()

		hcpUser
			.api()
			.healthElement
			.initialiseEncryptionMetadata(
				DecryptedHealthElement(id = UUID.randomUUID().toString()),
				patient!!,
				currentUser
			).let {
				hcpUser
					.api()
					.healthElement
					.createHealthcareElement(it)
				println("Created HealthElement")
			}

		withTimeoutOrNull(5.seconds) {
			completable.await()
			connection.close()
		} ?: fail("Didn't received MESSAGE event within 5 seconds")
	}

	"Should be able to reconnect if didn't received a ping within the configured delay" {
		val completable = CompletableDeferred<Unit>()

		val authProvider = mockk<WebSocketAuthProvider>() {
			coEvery { getBearerToken() } returns "token"
		}

		val ktorServer = embeddedServer(Netty, port = 25565) {
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
				}
		}.start(wait = false)

		delay(5.seconds)

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
			durationBetweenPings = 2.seconds,
			eventCallback = { element ->
				println("CLIENT: Received HealthElement event for ${element.id}")
			},
		)

		connection.onReconnected {
			println("CLIENT: Reconnected")
			connection.close()
			completable.complete(Unit)
			ktorServer.stop(0, 0)
		}

		withTimeoutOrNull(10.seconds) {
			completable.await()
		} ?: fail("Didn't reconnected within 50 seconds")
	}
})
