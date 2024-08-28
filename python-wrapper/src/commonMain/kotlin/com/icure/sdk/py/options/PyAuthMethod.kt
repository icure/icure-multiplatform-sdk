package com.icure.sdk.py.options

import com.icure.sdk.auth.ThirdPartyProvider
import com.icure.sdk.options.AuthenticationMethod
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface PyAuthMethod {
	fun toKt(): AuthenticationMethod

	@Serializable
	data class UsernamePassword(val username: String, val password: String): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.sdk.auth.UsernamePassword(username, password))
	}
	@Serializable
	data class UsernameLongToken(val username: String, val token: String): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.sdk.auth.UsernameLongToken(username, token))
	}
	@Serializable
	data class ThirdPartyAuthentication(val token: String, val provider: ThirdPartyProvider): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.sdk.auth.ThirdPartyAuthentication(token, provider))
	}
}