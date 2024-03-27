package com.icure.sdk.model.base

import com.icure.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class NotificationEvent(
    @Serializable(with = InstantSerializer::class)
    public val date: Instant? = null,
    public val status: Status? = null,
) {
    @Serializable
    public enum class Status() {
        @SerialName("SENT")
        Sent,

        @SerialName("RECEIVED")
        Received,

        @SerialName("ERROR")
        Error,
    }
  // region NotificationEvent-NotificationEvent

  // endregion
}
