package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.CalendarItemTag
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemTag_toJs(obj: CalendarItemTag): CalendarItemTagJs {
	val code = obj.code
	val date = longToNumber(obj.date)
	val userId = obj.userId
	val userName = obj.userName
	return CalendarItemTagJs(js("{" +
		"code:code," +
		"date:date," +
		"userId:userId," +
		"userName:userName" +
	"}"))
}

public fun calendarItemTag_fromJs(obj: CalendarItemTagJs): CalendarItemTag {
	val code = obj.code
	val date = numberToLong(obj.date, "obj.date")
	val userId = obj.userId
	val userName = obj.userName
	return CalendarItemTag(
		code = code,
		date = date,
		userId = userId,
		userName = userName,
	)
}
