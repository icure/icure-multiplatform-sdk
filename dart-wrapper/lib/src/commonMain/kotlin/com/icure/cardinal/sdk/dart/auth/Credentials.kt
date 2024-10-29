package com.icure.cardinal.sdk.dart.auth

import com.icure.cardinal.sdk.auth.ThirdPartyProvider
import kotlinx.serialization.Serializable

@Serializable
sealed interface Credentials {

	fun toKt(): com.icure.cardinal.sdk.auth.Credentials

	@Serializable
	data class UsernamePassword(val username: String, val password: String) : Credentials {
		override fun toKt() = com.icure.cardinal.sdk.auth.UsernamePassword(username, password)
	}

	data class UsernameLongToken(val username: String, val token: String) : Credentials {
		override fun toKt() = com.icure.cardinal.sdk.auth.UsernameLongToken(username, token)
	}

	data class ThirdPartyAuthentication(val token: String, val provider: ThirdPartyProvider) : Credentials {
		override fun toKt() = com.icure.cardinal.sdk.auth.ThirdPartyAuthentication(token, provider)
	}

}