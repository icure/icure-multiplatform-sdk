package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class FrontEndMigrationStatus() {
    @SerialName("STARTED")
    Started,

    @SerialName("PAUSED")
    Paused,

    @SerialName("ERROR")
    Error,

    @SerialName("SUCCESS")
    Success,
}
