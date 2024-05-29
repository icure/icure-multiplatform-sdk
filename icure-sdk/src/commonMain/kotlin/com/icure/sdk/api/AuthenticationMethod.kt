package com.icure.sdk.api

import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthService

sealed interface BasicAuthenticationMethod {
	data class UsingCredentials(val usernamePassword: UsernamePassword) : BasicAuthenticationMethod
	data class UsingService(val authService: AuthService) : BasicAuthenticationMethod
}
