package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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
			NativeReferences.get<PaginatedListIteratorWithSerializer<*>>(sdkId).hasNext()
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
			JsonElement.serializer()
		) {
			NativeReferences.get<PaginatedListIteratorWithSerializer<*>>(sdkId).nextAsJson(limit)
		}
	}
}