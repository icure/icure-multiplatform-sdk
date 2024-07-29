package com.icure.sdk.auth

import com.icure.sdk.model.embed.AuthenticationClass

sealed interface AuthSecret {
	val secret: String
}

sealed interface AuthSecretDetails : AuthSecret {

	val type: AuthenticationClass

	data class PasswordDetails(override val secret: String) : AuthSecretDetails {
		override val type = com.icure.sdk.model.embed.AuthenticationClass.Password
	}

	data class TwoFactorAuthTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = com.icure.sdk.model.embed.AuthenticationClass.TwoFactorAuthentication
	}

	data class ShortLivedTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = com.icure.sdk.model.embed.AuthenticationClass.ShortLivedToken
	}

	data class LongLivedTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = com.icure.sdk.model.embed.AuthenticationClass.LongLivedToken
	}

	data class ExternalAuthenticationDetails(override val secret: String, val oauthType: ThirdPartyProvider): AuthSecretDetails {
		override val type = com.icure.sdk.model.embed.AuthenticationClass.ExternalAuthentication
	}

	data class DigitalIdDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.DigitalId
	}
}
