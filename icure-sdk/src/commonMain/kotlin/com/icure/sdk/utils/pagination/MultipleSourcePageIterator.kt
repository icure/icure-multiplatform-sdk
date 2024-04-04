package com.icure.sdk.utils.pagination

import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.specializations.JsonString

class MultipleSourcePageIterator<T : Versionable<String>, P : Any>(
	requestParameters: List<P>,
	private val elementComparator: Comparator<T> = Comparator { a, b -> a.id.compareTo(b.id) },
	requestNextPage: suspend (params: P, nextKeyPair: PaginatedDocumentKeyIdPair<JsonString>?) -> PaginatedList<T, JsonString>
) : PaginatedListIterator<T> {

	private val iteratorBuffer = requestParameters.map { params ->
		SingleSourcePageIterator { nextKey -> requestNextPage(params, nextKey) }
	}
	private val emissionBuffer: MutableList<T?> = MutableList(requestParameters.size) { null }
	private val emittedIds: MutableSet<String> = mutableSetOf()

	private suspend fun tryNextUntilNotEmitted(idx: Int): T? {
		var next: T?
		do {
			next = iteratorBuffer[idx].tryNext()
		} while (next != null && emittedIds.contains(next.id))
		return next
	}

	override suspend fun hasNext(): Boolean =
		iteratorBuffer.mapIndexed { idx, iterator ->
			when {
				emissionBuffer[idx] != null && !emittedIds.contains(emissionBuffer[idx]?.id) -> true
				!iterator.hasNext() -> {
					emissionBuffer[idx] = null
					false
				}
				iterator.hasNext() -> {
					val next = tryNextUntilNotEmitted(idx)
					emissionBuffer[idx] = next
					next != null
				}
				else -> {
					emissionBuffer[idx] = null
					false
				}
			}
		}.any { it }

	override suspend fun tryNext(): T? {
		if(!hasNext()) return null

		return emissionBuffer.filterNotNull().takeIf { it.isNotEmpty() }?.minWith(elementComparator)?.let { minElement ->
			val minIndex = emissionBuffer.indexOfFirst { it?.id == minElement.id }
			emissionBuffer[minIndex] = null
			emittedIds.add(minElement.id)
			minElement
		}
	}

	override suspend fun next(): T = tryNext() ?: throw NoSuchElementException("There are no more elements available for this iterator")
}
