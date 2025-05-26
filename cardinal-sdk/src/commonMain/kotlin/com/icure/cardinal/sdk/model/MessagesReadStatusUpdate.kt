package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MessagesReadStatusUpdate(
	public val ids: List<String>? = null,
	public val time: Long? = null,
	public val status: Boolean? = null,
	public val userId: String? = null,
	internal val dtoSerialName: String,
) {
	// region MessagesReadStatusUpdate-MessagesReadStatusUpdate

	// endregion
}
