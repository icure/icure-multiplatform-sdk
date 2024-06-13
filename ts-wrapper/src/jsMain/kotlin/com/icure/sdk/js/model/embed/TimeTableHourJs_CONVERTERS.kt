package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.TimeTableHour
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timeTableHour_toJs(obj: TimeTableHour): TimeTableHourJs {
	val startHour = longToNumber(obj.startHour)
	val endHour = longToNumber(obj.endHour)
	return TimeTableHourJs(js("{" +
		"startHour:startHour," +
		"endHour:endHour" +
	"}"))
}

public fun timeTableHour_fromJs(obj: TimeTableHourJs): TimeTableHour {
	val startHour = numberToLong(obj.startHour, "obj.startHour")
	val endHour = numberToLong(obj.endHour, "obj.endHour")
	return TimeTableHour(
		startHour = startHour,
		endHour = endHour,
	)
}
