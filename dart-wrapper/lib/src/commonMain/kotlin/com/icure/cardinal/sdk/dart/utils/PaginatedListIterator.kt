package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@InternalIcureApi
object PaginatedListIterator {

	fun hasNext(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String
	) {
		ApiScope.execute(
			dartResultCallback,
			Boolean.serializer()
		) {
			NativeReferences.get<PaginatedListIterator<JsonElement>>(sdkId).hasNext()
		}
	}

	fun next(
		dartResultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
		sdkId: String,
		limitString: String
	) {
		val limit = fullLanguageInteropJson.decodeFromString(
			Int.serializer(),
			limitString
		)
		ApiScope.execute(
			dartResultCallback,
			ListSerializer(JsonElement.serializer())
		) {
			NativeReferences.get<PaginatedListIterator<JsonElement>>(sdkId).next(limit)
		}
	}
}