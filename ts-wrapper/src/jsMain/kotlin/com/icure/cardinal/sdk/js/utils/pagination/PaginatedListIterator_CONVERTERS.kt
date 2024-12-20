package com.icure.cardinal.sdk.js.utils.pagination

import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

fun <T : Any, T_JS : Any> paginatedListIterator_toJs(
	paginatedListIterator: PaginatedListIterator<T>,
	tConverter: (T) -> T_JS,
) = object : PaginatedListIteratorJs<T_JS> {
	override fun hasNext(): Promise<Boolean> = GlobalScope.promise {
		paginatedListIterator.hasNext()
	}

	override fun next(limit: Int): Promise<Array<T_JS>> = GlobalScope.promise {
		paginatedListIterator.next(limit).map(tConverter).toTypedArray()
	}
}