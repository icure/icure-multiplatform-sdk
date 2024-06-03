package com.icure.sdk.api

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawAuthApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.utils.InternalIcureApi

sealed interface AuthenticationMethod {
	data class UsingCredentials(val usernamePassword: UsernamePassword) : AuthenticationMethod
	data class UsingService(val authService: AuthService) : AuthenticationMethod
}

@OptIn(InternalIcureApi::class)
fun AuthenticationMethod.getAuthService(authApi: RawAnonymousAuthApi) = when(this) {
	is AuthenticationMethod.UsingCredentials -> JwtAuthService(authApi, this.usernamePassword)
	is AuthenticationMethod.UsingService -> this.authService
}
