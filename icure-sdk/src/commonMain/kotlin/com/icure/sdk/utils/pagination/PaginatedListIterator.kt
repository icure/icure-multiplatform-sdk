
 package com.icure.sdk.utils.pagination

/**
 * This interface provides method to easily retrieve entities from a [PaginatedList], hiding the complexity of the multiple
 * requests required to exhaust a page.
 */
interface PaginatedListIterator<T : Any> {

	/**
	 * As this is a suspend version of the hasNext behaviour, it is responsibility of this function to pre-fetch results and
	 * evaluate possible conditions specified by the concrete implementations of this interface.
	 *
	 * @return true if there is at least one more element available in the page, false otherwise.
	 */
	suspend fun hasNext(): Boolean

	/**
	 * @return the next element [T] of the page.
	 * @throws NoSuchElementException if there are no elements left.
	 */
	suspend fun next(): T

	/**
	 * @return the next element [T] of the page, or null if there are no elements left.
	 */
	suspend fun tryNext(): T?
}

suspend fun <T : Any> PaginatedListIterator<T>.forEach(block: suspend (T) -> Unit) {
	while (hasNext()) {
		block(next())
	}
}

/**
 * Retrieves [limit] items or the amount of remaining items, whichever is lower. While filling the result the iterator
 * may use only buffered data or may need to perform multiple requests to the backend, this method does not provide any
 * form of control over it.
 * Once the iterator has exhausted all items any more calls to this method will return an empty list.
 * @param limit maximum number of items to retrieve from this call
 * @return a list with the retrieved items.
 */
suspend fun <T : Any> PaginatedListIterator<T>.next(limit: Int): List<T> {
	val res = ArrayList<T>(limit)
	while (res.size < limit && hasNext()) { res.add(next()) }
	return res
}
