package com.icure.sdk.options

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.Credentials
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.auth.services.SmartAuthProvider
import com.icure.sdk.utils.InternalIcureApi

sealed interface AuthenticationMethod {
	data class UsingCredentials(val credentials: Credentials) : AuthenticationMethod
	data class UsingProvider(val authProvider: AuthProvider) : AuthenticationMethod
	data class UsingSecretProvider(
		val username: String,
		val password: String? = null,
		val existingJwt: String? = null,
		val existingRefreshJwt: String? = null,
		val secretProvider: AuthSecretProvider
	) : AuthenticationMethod
}

@OptIn(InternalIcureApi::class)
fun AuthenticationMethod.getAuthProvider(authApi: RawAnonymousAuthApi): AuthProvider = when(this) {
	is AuthenticationMethod.UsingCredentials -> JwtAuthService(authApi, this.credentials)
	is AuthenticationMethod.UsingProvider -> this.authProvider
	is AuthenticationMethod.UsingSecretProvider -> SmartAuthProvider.initialise(
		authApi = authApi,
		login = username,
		secretProvider = secretProvider,
		initialAuthToken = existingJwt,
		initialRefreshToken = existingRefreshJwt,
		initialSecret = password?.let { SmartAuthProvider.InitialSecret.PlainSecret(secret = it) }
	)
}
