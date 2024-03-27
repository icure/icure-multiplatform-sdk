package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class AuthenticationClass() {
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
