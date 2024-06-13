package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.user.UserByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userByIdsFilter_toJs(obj: UserByIdsFilter): UserByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = nullToUndefined(
		obj.desc
	)
	return UserByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun userByIdsFilter_fromJs(obj: UserByIdsFilterJs): UserByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = undefinedToNull(obj.desc)
	return UserByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
