package com.icure.sdk.auth

sealed interface AuthToken

data class Jwt(
	val jwt: String,
	val refreshJwt: String
) : AuthToken, Credentials