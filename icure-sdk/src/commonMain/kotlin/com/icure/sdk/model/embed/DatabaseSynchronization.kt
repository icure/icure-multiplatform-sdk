package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DatabaseSynchronization(
    public val source: String? = null,
    public val target: String? = null,
    public val filter: String? = null,
    public val localTarget: Target? = null,
) {
    @Serializable
    public enum class Target() {
        @SerialName("base")
        Base,

        @SerialName("healthdata")
        Healthdata,

        @SerialName("patient")
        Patient,
    }
    // region DatabaseSynchronization-DatabaseSynchronization

    // endregion
}
