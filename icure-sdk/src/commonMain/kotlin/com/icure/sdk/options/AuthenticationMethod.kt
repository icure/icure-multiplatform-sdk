package com.icure.sdk.options

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.utils.InternalIcureApi

sealed interface AuthenticationMethod {
	data class UsingCredentials(val usernamePassword: UsernamePassword) : AuthenticationMethod
	data class UsingService(val authService: AuthService) : AuthenticationMethod
	data class UsingProvider(val authProvider: AuthProvider) : AuthenticationMethod
}

@OptIn(InternalIcureApi::class)
fun AuthenticationMethod.getAuthService(authApi: RawAnonymousAuthApi) = when(this) {
	is AuthenticationMethod.UsingCredentials -> JwtAuthService(authApi, this.usernamePassword)
	is AuthenticationMethod.UsingService -> this.authService
	is AuthenticationMethod.UsingProvider -> this.authProvider.getAuthService()
}

@OptIn(InternalIcureApi::class)
fun AuthenticationMethod.getAuthProvider(authApi: RawAnonymousAuthApi): AuthProvider = when(this) {
	is AuthenticationMethod.UsingCredentials -> JwtAuthService(authApi, this.usernamePassword)
	is AuthenticationMethod.UsingService -> throw IllegalStateException("Cannot instantiate provider using service")
	is AuthenticationMethod.UsingProvider -> this.authProvider
}
