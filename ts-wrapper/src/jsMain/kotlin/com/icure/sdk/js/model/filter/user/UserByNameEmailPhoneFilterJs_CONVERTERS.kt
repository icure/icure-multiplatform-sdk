package com.icure.sdk.js.model.filter.user

import com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userByNameEmailPhoneFilter_toJs(obj: UserByNameEmailPhoneFilter):
		UserByNameEmailPhoneFilterJs {
	val searchString = obj.searchString
	val desc = obj.desc ?: undefined
	return UserByNameEmailPhoneFilterJs(js("{" +
		"searchString:searchString," +
		"desc:desc" +
	"}"))
}

public fun userByNameEmailPhoneFilter_fromJs(obj: UserByNameEmailPhoneFilterJs):
		UserByNameEmailPhoneFilter {
	val searchString = obj.searchString
	val desc = obj.desc
	return UserByNameEmailPhoneFilter(
		searchString = searchString,
		desc = desc,
	)
}
