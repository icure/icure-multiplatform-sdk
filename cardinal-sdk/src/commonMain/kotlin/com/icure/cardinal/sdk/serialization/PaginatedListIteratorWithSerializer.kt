package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonElement

@InternalIcureApi
class PaginatedListIteratorWithSerializer<T : Any>(
	private val iterator: PaginatedListIterator<T>,
	private val serializer: KSerializer<T>
) {
	suspend fun hasNext(): Boolean =
		iterator.hasNext()

	suspend fun nextAsJson(limit: Int): JsonElement =
		Serialization.fullLanguageInteropJson.encodeToJsonElement(ListSerializer(serializer), iterator.next(limit))
}