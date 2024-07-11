package com.icure.sdk.model.utils

import com.fasterxml.jackson.databind.JsonNode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface ExternalFilterKey<T> {
	public val key: T

	@Serializable
	@SerialName("string")
	public data class ExternalFilterStringKey(
		override val key: String,
	) : ExternalFilterKey<String>

	@Serializable
	@SerialName("long")
	public data class ExternalFilterLongKey(
		override val key: Long,
	) : ExternalFilterKey<Long>

	@Serializable
	@SerialName("complexKey")
	public data class ExternalFilterComplexKey(
		override val key: JsonElement,
	) : ExternalFilterKey<JsonNode>
	// region ExternalFilterKey-ExternalFilterKey

	// endregion
}
