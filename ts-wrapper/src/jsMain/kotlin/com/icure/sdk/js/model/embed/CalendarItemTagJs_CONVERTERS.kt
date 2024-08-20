// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.CalendarItemTag
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemTag_toJs(obj: CalendarItemTag): CalendarItemTagJs {
	val code = nullToUndefined(
		obj.code
	)
	val date = nullToUndefined(
		longToNumber(obj.date)
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val userName = nullToUndefined(
		obj.userName
	)
	return CalendarItemTagJs(js("{" +
		"code:code," +
		"date:date," +
		"userId:userId," +
		"userName:userName" +
	"}"))
}

public fun calendarItemTag_fromJs(obj: CalendarItemTagJs): CalendarItemTag {
	val code = undefinedToNull(obj.code)
	val date = numberToLong(obj.date, "obj.date")
	val userId = undefinedToNull(obj.userId)
	val userName = undefinedToNull(obj.userName)
	return CalendarItemTag(
		code = code,
		date = date,
		userId = userId,
		userName = userName,
	)
}
