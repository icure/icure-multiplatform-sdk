package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class IndexingInfo(
	public val statuses: Map<String, Int>? = null,
) {
	public val dtoSerialName: String
	// region IndexingInfo-IndexingInfo

	// endregion
}
