package com.icure.sdk.websocket

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.util.InternalAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@OptIn(InternalAPI::class)
class BasicWebSocketTest: StringSpec({
	"Should emit open event" {
		var connected = false

		val connection = ConnectionImpl(WebSocketWrapper(this))

		launch {
			connection.onConnected {
				println("Connected")
				connected = true
				connection.close()
			}
		}

		launch {
			connection.onMessage {
				println("Message received: $it")
			}
		}

		delay(1.seconds)

		connected shouldBe true
	}
})
