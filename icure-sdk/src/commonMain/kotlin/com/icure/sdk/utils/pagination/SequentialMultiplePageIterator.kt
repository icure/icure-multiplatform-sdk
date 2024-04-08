package com.icure.sdk.utils.pagination

import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.base.Versionable

class SequentialMultiplePageIterator<T : Versionable<String>, P>(
	requestParameters: List<P>,
	parametersComparator: Comparator<P> ? = null,
	private val requestNextPage: suspend (params: P, nextKeyPair: PaginatedDocumentKeyIdPair?) -> PaginatedList<T>
) : PaginatedListIterator<T> {

	private val requestParams = (parametersComparator?.let { requestParameters.sortedWith(it) } ?: requestParameters)
	private var paramsIndex = 0
	private var currentIterator: SingleSourcePageIterator<T> = SingleSourcePageIterator { PaginatedList() }
	private var currentValue: T? = null
	private val emittedIds: MutableSet<String> = mutableSetOf()

	// It's important for this to be tail recursive, because in case of a lot of entities to skip the space occupied in the stack
	// will be not negligible.
	override tailrec suspend fun hasNext(): Boolean = when {
		currentValue != null && !emittedIds.contains(currentValue?.id) -> {
			println("Ok")
			true
		}
		!currentIterator.hasNext() && paramsIndex >= requestParams.size -> {
			println("Finished")
			false
		}
		!currentIterator.hasNext() -> {
			currentIterator = SingleSourcePageIterator { requestNextPage(requestParams[paramsIndex], it) }
			paramsIndex += 1
			hasNext()
		}
		currentValue == null || emittedIds.contains(currentValue?.id) -> {
			currentValue = currentIterator.tryNext()
			hasNext()
		}
		else -> {
			println("What")
			false
		}
	}

	override suspend fun tryNext(): T? = if(hasNext()) {
		val next = currentValue
		if(next != null) {
			emittedIds.add(next.id)
			currentValue = null
		}
		println(next)
		next
	} else null

	override suspend fun next(): T = tryNext() ?: throw NoSuchElementException("There are no more elements available for this iterator")
}
