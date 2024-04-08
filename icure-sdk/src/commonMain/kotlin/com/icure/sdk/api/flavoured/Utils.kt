package com.icure.sdk.api.flavoured

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive

/**
 * Encodes a json element that represents the start key for a paginated query.
 * Returns null if the element is null or JsonNull.
 * Returns the unquoted string if the element is a string JsonPrimitive.
 * Returns the json string representation of the element otherwise.
 */
fun JsonElement?.encodeStartKey(): String? =
	when {
		this is JsonPrimitive && this.isString -> this.content
		this is JsonNull || this == null -> null
		else -> this.toString()
	}
