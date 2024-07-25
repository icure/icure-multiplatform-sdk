package com.icure.sdk.options

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.auth.services.SmartAuthProvider
import com.icure.sdk.utils.InternalIcureApi

sealed interface AuthenticationMethod {
	data class UsingCredentials(val usernamePassword: UsernamePassword) : AuthenticationMethod
	data class UsingProvider(val authProvider: AuthProvider) : AuthenticationMethod
	data class UsingSecretProvider(val username: String, val password: String? = null, val secretProvider: AuthSecretProvider) : AuthenticationMethod
}

@OptIn(InternalIcureApi::class)
fun AuthenticationMethod.getAuthProvider(authApi: RawAnonymousAuthApi): AuthProvider = when(this) {
	is AuthenticationMethod.UsingCredentials -> JwtAuthService(authApi, this.usernamePassword)
	is AuthenticationMethod.UsingProvider -> this.authProvider
	is AuthenticationMethod.UsingSecretProvider -> SmartAuthProvider.initialise(
		authApi = authApi,
		login = username,
		secretProvider = secretProvider,
		initialSecret = password?.let { SmartAuthProvider.InitialSecret.PlainSecret(secret = it) }
	)
}
