package com.icure.sdk.js.model.filter.user

import com.icure.sdk.model.filter.user.AllUsersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allUsersFilter_toJs(obj: AllUsersFilter): AllUsersFilterJs {
	val desc = obj.desc ?: undefined
	return AllUsersFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allUsersFilter_fromJs(obj: AllUsersFilterJs): AllUsersFilter {
	val desc = obj.desc
	return AllUsersFilter(
		desc = desc,
	)
}
