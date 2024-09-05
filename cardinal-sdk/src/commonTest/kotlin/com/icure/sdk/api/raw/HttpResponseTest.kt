package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HttpResponseTest : StringSpec({

	beforeAny {
		initializeTestEnvironment()
	}

	"Can receive a null response body" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()

		api.code.getCodeByRegionLanguageTypeLabel(uuid(), uuid(), uuid(), uuid()) shouldBe null
	}

})
