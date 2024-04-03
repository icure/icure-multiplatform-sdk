package com.icure.sdk.utils.pagination

import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.specializations.JsonString

class SingleSourcePageIterator<T : Any>(
	private val requestNextPage: suspend (nextKeyPair: PaginatedDocumentKeyIdPair<JsonString>?) -> PaginatedList<T, JsonString>
) : PaginatedListIterator<T> {
	private var currentPage: PaginatedList<T, JsonString>? = null
	private var currentIndex: Int = 0

	private fun getAndIncrement(): T? {
		val next = currentPage?.rows?.getOrNull(currentIndex)
		currentIndex += 1
		return next
	}

	override suspend fun hasNext(): Boolean = when {
		currentPage == null -> {
			currentPage = requestNextPage(null)
			hasNext()
		}
		currentIndex >= (currentPage?.rows?.size ?: 0) && currentPage?.nextKeyPair != null -> {
			currentPage = requestNextPage(currentPage?.nextKeyPair)
			currentIndex = 0
			hasNext()
		}
		else -> currentIndex < (currentPage?.rows?.size ?: 0)
	}

	override suspend fun tryNext(): T? = if(hasNext()) {
		getAndIncrement()
	} else null

	override suspend fun next(): T = tryNext() ?: throw NoSuchElementException("There are no more elements available for this iterator")
}
