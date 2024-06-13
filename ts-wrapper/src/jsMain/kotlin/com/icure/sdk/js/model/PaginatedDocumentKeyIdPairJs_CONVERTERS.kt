package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun paginatedDocumentKeyIdPair_toJs(obj: PaginatedDocumentKeyIdPair):
		PaginatedDocumentKeyIdPairJs {
	val startKey = jsonToDynamic(obj.startKey) ?: undefined
	val startKeyDocId = obj.startKeyDocId ?: undefined
	return PaginatedDocumentKeyIdPairJs(js("{" +
		"startKey:startKey," +
		"startKeyDocId:startKeyDocId" +
	"}"))
}

public fun paginatedDocumentKeyIdPair_fromJs(obj: PaginatedDocumentKeyIdPairJs):
		PaginatedDocumentKeyIdPair {
	val startKey = dynamicToJsonNullsafe(obj.startKey, "obj.startKey")
	val startKeyDocId = obj.startKeyDocId
	return PaginatedDocumentKeyIdPair(
		startKey = startKey,
		startKeyDocId = startKeyDocId,
	)
}
