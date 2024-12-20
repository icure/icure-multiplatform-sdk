package com.icure.cardinal.sdk.dart.auth

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthenticationMethod {

	fun toMultiplatform(): com.icure.cardinal.sdk.options.AuthenticationMethod

	@Serializable
	data class UsingCredentials(val credentials: Credentials) : AuthenticationMethod {
		override fun toMultiplatform() =
			com.icure.cardinal.sdk.options.AuthenticationMethod.UsingCredentials(credentials.toKt())
	}

}