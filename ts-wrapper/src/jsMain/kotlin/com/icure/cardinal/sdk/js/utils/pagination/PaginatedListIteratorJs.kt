package com.icure.cardinal.sdk.js.utils.pagination

import kotlin.js.Promise

@JsExport
@JsName("PaginatedListIterator")
interface PaginatedListIteratorJs<T : Any> {

	/**
	 * As this is a suspend version of the hasNext behaviour, it is responsibility of this function to pre-fetch results and
	 * evaluate possible conditions specified by the concrete implementations of this interface.
	 *
	 * @return true if there is at least one more element available in the page, false otherwise.
	 */
	fun hasNext(): Promise<Boolean>

	/**
	 * @return the next element [T] of the page.
	 * @throws NoSuchElementException if there are no elements left.
	 */
	fun next(limit: Int): Promise<Array<T>>
}