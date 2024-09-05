
 package com.icure.cardinal.sdk.utils.pagination

/**
 * This interface provides method to easily retrieve entities from a [PaginatedList], hiding the complexity of the multiple
 * requests required to exhaust a page.
 */
interface PaginatedListIterator<out T : Any> {

	/**
	 * As this is a suspend version of the hasNext behaviour, it is responsibility of this function to pre-fetch results and
	 * evaluate possible conditions specified by the concrete implementations of this interface.
	 *
	 * @return true if there is at least one more element available in the page, false otherwise.
	 */
	suspend fun hasNext(): Boolean

	/**
	 * Retrieves [limit] items or the amount of remaining items, whichever is lower.
	 * Implementations of this method may retrieve more than the requested amount of items and buffer them.
	 * Make sure to use a reasonable value for limit, if too high the request may take very long.
	 * @param limit maximum number of items to retrieve from this call
	 * @return a list with the retrieved items.
	 */
	suspend fun next(limit: Int): List<T>
}

suspend fun <T : Any> PaginatedListIterator<T>.forEach(block: suspend (T) -> Unit) {
	while (hasNext()) {
		next(100).forEach { block(it) }
	}
}
