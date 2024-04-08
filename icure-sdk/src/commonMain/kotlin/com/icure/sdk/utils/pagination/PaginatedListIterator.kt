package com.icure.sdk.utils.pagination

/**
 * This interface provides method to easily retrieve entities from a [PaginatedList], hiding the complexity of the multiple calls required
 * to exhaust a page.
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
