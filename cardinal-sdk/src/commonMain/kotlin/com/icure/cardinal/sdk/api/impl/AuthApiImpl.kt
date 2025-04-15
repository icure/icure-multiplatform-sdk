package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class AuthApiImpl(val authProvider: AuthProvider) : AuthApi {
	override suspend fun getBearerToken(): String {
		if (authProvider is JwtBasedAuthProvider) {
			return authProvider.getBearerAndRefreshToken().bearer.token
		} else {
			throw UnsupportedOperationException("The AuthProvider ${authProvider::class} does not support bearer tokens")
		}
	}
}
