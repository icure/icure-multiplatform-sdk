package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.user.AllUsersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allUsersFilter_toJs(obj: AllUsersFilter): AllUsersFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	return AllUsersFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allUsersFilter_fromJs(obj: AllUsersFilterJs): AllUsersFilter {
	val desc = undefinedToNull(obj.desc)
	return AllUsersFilter(
		desc = desc,
	)
}
