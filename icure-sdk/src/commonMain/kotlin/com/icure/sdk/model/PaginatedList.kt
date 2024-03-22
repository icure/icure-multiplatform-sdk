package com.icure.sdk.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class PaginatedList<T : Any>(
	val pageSize: Int = 0,
	val totalSize: Int = 0,
	val rows: List<T> = emptyList(),
	val nextKeyPair: PaginatedDocumentKeyIdPair? = null
)

@Serializable
data class PaginatedDocumentKeyIdPair(
	val startKey: JsonElement? = null, // The start key for the next page, it should not be interpreted and just sent back as is to the server.
	val startKeyDocId: String? = null
)