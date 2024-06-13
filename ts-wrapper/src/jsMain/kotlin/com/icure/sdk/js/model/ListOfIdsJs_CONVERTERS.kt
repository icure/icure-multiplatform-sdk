package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.ListOfIds
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun listOfIds_toJs(obj: ListOfIds): ListOfIdsJs {
	val ids = listToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	return ListOfIdsJs(js("{" +
		"ids:ids" +
	"}"))
}

public fun listOfIds_fromJs(obj: ListOfIdsJs): ListOfIds {
	val ids = arrayToList(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	return ListOfIds(
		ids = ids,
	)
}
