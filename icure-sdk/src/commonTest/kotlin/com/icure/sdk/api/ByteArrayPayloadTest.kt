package com.icure.sdk.api

import createHcpUser
import io.kotest.core.spec.style.StringSpec

class ByteArrayPayloadTest : StringSpec({

	"It is possible to send a ByteArray payload and retrieve it" {
		val hcpUser = createHcpUser()
		val api = hcpUser.api()
	}

})
