package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter
import kotlin.String

public fun contactByServiceIdsFilter_toJs(obj: ContactByServiceIdsFilter):
		ContactByServiceIdsFilterJs {
	val desc = obj.desc
	val ids = listToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	return ContactByServiceIdsFilterJs(js("{" +
		"desc:desc," +
		"ids:ids" +
	"}"))
}

public fun contactByServiceIdsFilter_fromJs(obj: ContactByServiceIdsFilterJs):
		ContactByServiceIdsFilter {
	val desc = obj.desc
	val ids = arrayToList(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	return ContactByServiceIdsFilter(
		desc = desc,
		ids = ids,
	)
}
