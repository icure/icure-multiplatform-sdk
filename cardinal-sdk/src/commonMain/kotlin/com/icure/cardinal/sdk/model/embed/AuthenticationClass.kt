package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AuthenticationClass() {
	@SerialName("DIGITAL_ID")
	DigitalId,

	@SerialName("TWO_FACTOR_AUTHENTICATION")
	TwoFactorAuthentication,

	@SerialName("SHORT_LIVED_TOKEN")
	ShortLivedToken,

	@SerialName("EXTERNAL_AUTHENTICATION")
	ExternalAuthentication,

	@SerialName("PASSWORD")
	Password,

	@SerialName("LONG_LIVED_TOKEN")
	LongLivedToken,
}
