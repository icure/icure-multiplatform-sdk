package com.icure.sdk.utils.pagination

class IdsPageIterator<T : Any>(
	ids: List<String>,
	private val retrieve: suspend (ids: List<String>) -> List<T>
) : PaginatedListIterator<T> {

	private val idsToRetrieve = ids.toMutableList()
	private var retrieved = listOf<T>()
	private var retrievedIndex = 0
	private val batchSize = 100

	override tailrec suspend fun hasNext(): Boolean = when {
		retrievedIndex < retrieved.size -> true
		idsToRetrieve.isNotEmpty() -> {
			val batchToRetrieve = idsToRetrieve.take(batchSize)
			idsToRetrieve.removeAll(batchToRetrieve)
			retrieved = retrieve(batchToRetrieve)
			retrievedIndex = 0
			hasNext()
		}
		else -> false
	}

	override suspend fun tryNext(): T? = if(hasNext()) {
		val element = retrieved[retrievedIndex]
		retrievedIndex++
		element
	} else null

	override suspend fun next(): T = tryNext() ?: throw NoSuchElementException("There are no more elements available for this iterator")

}
