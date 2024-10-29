package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@OptIn(InternalIcureApi::class)
object PaginatedListIterator {
	fun hasNext(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		paginatedListIteratorId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			Boolean.serializer()
		) {
			NativeReferences.get<PaginatedListIteratorWithSerializer<*>>(paginatedListIteratorId).hasNext()
		}
	}

	fun next(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		paginatedListIteratorId: String,
		limitString: String
	) {
		val limit = fullLanguageInteropJson.decodeFromString(
			Int.serializer(),
			limitString
		)
		ApiScope.execute(
			dartResultCallback,
			JsonElement.serializer()
		) {
			NativeReferences.get<PaginatedListIteratorWithSerializer<*>>(paginatedListIteratorId).nextAsJson(limit)
		}
	}
}