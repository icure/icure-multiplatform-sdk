package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userByNameEmailPhoneFilter_toJs(obj: UserByNameEmailPhoneFilter):
		UserByNameEmailPhoneFilterJs {
	val searchString = obj.searchString
	val desc = nullToUndefined(
		obj.desc
	)
	return UserByNameEmailPhoneFilterJs(js("{" +
		"searchString:searchString," +
		"desc:desc" +
	"}"))
}

public fun userByNameEmailPhoneFilter_fromJs(obj: UserByNameEmailPhoneFilterJs):
		UserByNameEmailPhoneFilter {
	val searchString = obj.searchString
	val desc = undefinedToNull(obj.desc)
	return UserByNameEmailPhoneFilter(
		searchString = searchString,
		desc = desc,
	)
}
