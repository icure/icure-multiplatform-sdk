package com.icure.sdk.utils.pagination

import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.specializations.JsonString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T : Any> exhaustPaginatedRequest(
	request: suspend (nextKeyPair: PaginatedDocumentKeyIdPair<JsonString>?) -> PaginatedList<T, JsonString>
): Flow<T> = flow {
	var next = request(null).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	while (next != null) {
		next = request(next).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	}
}
