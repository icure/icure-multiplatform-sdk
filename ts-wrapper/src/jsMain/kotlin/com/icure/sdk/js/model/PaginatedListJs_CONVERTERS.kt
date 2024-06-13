package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.PaginatedList
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <T, T_JS> paginatedList_toJs(obj: PaginatedList<T>, convertT: (T) -> T_JS):
		PaginatedListJs<T_JS> {
	val rows = listToArray(
		obj.rows,
		{ x1: T ->
			convertT(x1)
		},
	)
	val nextKeyPair = obj.nextKeyPair?.let { nonNull1 ->
		paginatedDocumentKeyIdPair_toJs(nonNull1)
	} ?: undefined
	return PaginatedListJs<T_JS>(js("{" +
		"rows:rows," +
		"nextKeyPair:nextKeyPair" +
	"}"))
}

public fun <T, T_KT> paginatedList_fromJs(obj: PaginatedListJs<T>, convertT: (T) -> T_KT):
		PaginatedList<T_KT> {
	val rows = arrayToList(
		obj.rows,
		"obj.rows",
		{ x1: T ->
			convertT(x1)
		},
	)
	val nextKeyPair = obj.nextKeyPair?.let { nonNull1 ->
		paginatedDocumentKeyIdPair_fromJs(nonNull1)
	}
	return PaginatedList<T_KT>(
		rows = rows,
		nextKeyPair = nextKeyPair,
	)
}
