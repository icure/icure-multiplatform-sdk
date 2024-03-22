package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MessageReadStatus(
  public val time: Long? = null,
  public val read: Boolean = false,
) {
	// region MessageReadStatus-MessageReadStatus
	// endregion
}