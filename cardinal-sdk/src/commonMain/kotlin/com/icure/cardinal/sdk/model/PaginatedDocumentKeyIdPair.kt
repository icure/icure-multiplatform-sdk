package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PaginatedDocumentKeyIdPair(
	public val startKey: JsonElement? = null,
	public val startKeyDocId: String? = null,
) {
	// region PaginatedDocumentKeyIdPair-PaginatedDocumentKeyIdPair

	// endregion
}
