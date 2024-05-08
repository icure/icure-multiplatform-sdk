package com.icure.sdk.utils.pagination

import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T : Any> exhaustPaginatedRequest(
	request: suspend (nextKeyPair: PaginatedDocumentKeyIdPair?) -> PaginatedList<T>
): Flow<T> = flow {
	var next = request(null).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	while (next != null) {
		next = request(next).also { res -> res.rows.forEach { emit(it) } }.nextKeyPair
	}
}
