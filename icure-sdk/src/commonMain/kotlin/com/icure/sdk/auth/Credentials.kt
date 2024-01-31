package com.icure.sdk.auth

sealed interface Credentials

data class UsernamePassword(
	val username: String,
	val password: String
) : Credentials

data class ThirdPartyTokens(
	val tokens: Map<ThirdPartyProvider, String>
) : Credentials