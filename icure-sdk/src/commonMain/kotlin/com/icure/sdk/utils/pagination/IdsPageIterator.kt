package com.icure.sdk.utils.pagination

class IdsPageIterator<T : Any>(
	private var ids: List<String>,
	private val retrieve: suspend (ids: List<String>) -> List<T>
) : PaginatedListIterator<T> {
	private var buffer = listOf<T>()
	private val defaultBatchSize = 100

	override tailrec suspend fun hasNext(): Boolean = when {
		buffer.isNotEmpty() -> true
		ids.isNotEmpty() -> {
			retrieveBatch(1)
			hasNext()
		}
		else -> false
	}

	private suspend fun retrieveBatch(minBatchSize: Int) {
		val batchSize = maxOf(minBatchSize, defaultBatchSize)
		val toRetrieve = ids.take(batchSize)
		if (toRetrieve.isNotEmpty()) {
			ids = ids.drop(batchSize)
			buffer = retrieve(toRetrieve)
		} else {
			buffer = emptyList()
		}
	}

	private fun consumeBuffer(maxAmount: Int): List<T> = buffer.take(maxAmount).also {
		buffer = buffer.drop(maxAmount)
	}

	override suspend fun next(limit: Int): List<T> =
		if (buffer.isNotEmpty()) {
			val buffered = consumeBuffer(limit)
			if (buffered.size < limit && ids.isNotEmpty()) {
				val remainingCount = limit - buffered.size
				retrieveBatch(remainingCount)
				val remainingItems = consumeBuffer(remainingCount)
				buffered + remainingItems
			} else {
				buffered
			}
		} else {
			retrieveBatch(limit)
			consumeBuffer(limit)
		}
}
