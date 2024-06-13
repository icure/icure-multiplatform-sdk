package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactByServiceIdsFilter_toJs(obj: ContactByServiceIdsFilter):
		ContactByServiceIdsFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val ids = nullToUndefined(
		listToArray(
			obj.ids,
			{ x1: String ->
				x1
			},
		)
	)
	return ContactByServiceIdsFilterJs(js("{" +
		"desc:desc," +
		"ids:ids" +
	"}"))
}

public fun contactByServiceIdsFilter_fromJs(obj: ContactByServiceIdsFilterJs):
		ContactByServiceIdsFilter {
	val desc = undefinedToNull(obj.desc)
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
