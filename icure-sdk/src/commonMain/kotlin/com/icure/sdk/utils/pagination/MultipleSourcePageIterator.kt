package com.icure.sdk.utils.pagination

import com.icure.sdk.model.Identifiable
import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.specializations.JsonString

class MultipleSourcePageIterator<T : Identifiable<String>, P : Any>(
	requestParameters: List<P>,
	private val elementComparator: Comparator<T> = Comparator { a, b -> a.id.compareTo(b.id) },
	request: suspend (params: P, nextKeyPair: PaginatedDocumentKeyIdPair<JsonString>?) -> PaginatedList<T, JsonString>
) : PaginatedListIterator<T> {

	private val iteratorBuffer = requestParameters.map { params ->
		SingleSourcePageIterator { nextKey -> request(params, nextKey) }
	}
	private val emissionBuffer: MutableList<T?> = MutableList(requestParameters.size) { null }
	private val emittedIds: MutableSet<String> = mutableSetOf()

	override suspend fun hasNext(): Boolean = iteratorBuffer.any { it.hasNext() }

	override suspend fun tryNext(): T? {
		if(!hasNext()) return null

		iteratorBuffer.forEachIndexed { idx, iterator ->
			if(emissionBuffer[idx] == null) {
				emissionBuffer[idx] = iterator.tryNext()
			}
		}
		return emissionBuffer.filterNotNull().takeIf { it.isNotEmpty() }?.minWith(elementComparator)?.let { minElement ->
			val minIndex = emissionBuffer.indexOfFirst { it?.id == minElement.id }
			emissionBuffer[minIndex] = null
			if(emittedIds.contains(minElement.id)) {
				tryNext()
			} else {
				emittedIds.add(minElement.id)
				minElement
			}
		}
	}

	override suspend fun next(): T = tryNext() ?: throw NoSuchElementException("There are no more elements available for this iterator")
}
