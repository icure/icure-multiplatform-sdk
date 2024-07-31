package com.icure.sdk.auth

import com.icure.sdk.model.embed.AuthenticationClass

sealed interface AuthSecretDetails {

	sealed interface Cacheable : AuthSecretDetails

	val type: AuthenticationClass
	val secret: String

	data class PasswordDetails(override val secret: String) : AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.Password
	}

	data class TwoFactorAuthTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.TwoFactorAuthentication
	}

	data class ShortLivedTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.ShortLivedToken
	}

	data class LongLivedTokenDetails(override val secret: String) : AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.LongLivedToken
	}

	data class ExternalAuthenticationDetails(override val secret: String, val oauthType: ThirdPartyProvider): AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.ExternalAuthentication
	}

	data class DigitalIdDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.DigitalId
	}
}
