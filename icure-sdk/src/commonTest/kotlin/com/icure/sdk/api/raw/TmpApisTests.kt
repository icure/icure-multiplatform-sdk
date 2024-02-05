package com.icure.sdk.api.raw

import com.icure.sdk.api.extended.AnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import io.kotest.core.spec.style.StringSpec

const val baseUrl = "http://127.0.0.1:16044"
const val username = "user-6cbd09c8-ee1b-4ffc-a500-824729e99afa"
const val password = "e6e1a174-94b0-4ea2-9e42-fe0904d562f3"

class TmpApisTests : StringSpec({
	"Tmp api test" {
		val authService = JwtAuthService(
			AnonymousAuthApiImpl(baseUrl),
			UsernamePassword(username, password),
		)
		val api = RawDataownerApi(baseUrl, authService)
		println(api.getCurrentDataOwner().successBody())
	}
})