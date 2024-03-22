package com.icure.sdk.api.extended

import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.ThirdPartyProvider

interface AnonymousAuthApi {

	suspend fun login(username: String, password: String): Jwt

	suspend fun loginWithThirdPartyToken(thirdPartyProvider: ThirdPartyProvider, token: String): Jwt

	suspend fun refresh(refreshJwt: String): Jwt
}