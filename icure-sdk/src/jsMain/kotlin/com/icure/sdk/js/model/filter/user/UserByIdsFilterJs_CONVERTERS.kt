package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.user.UserByIdsFilter
import kotlin.String

public fun userByIdsFilter_toJs(obj: UserByIdsFilter): UserByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
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
	val desc = obj.desc
	return UserByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
