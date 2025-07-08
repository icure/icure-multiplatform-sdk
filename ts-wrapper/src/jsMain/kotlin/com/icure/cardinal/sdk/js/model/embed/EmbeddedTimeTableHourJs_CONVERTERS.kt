// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.embed.EmbeddedTimeTableHour
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun embeddedTimeTableHour_toJs(obj: EmbeddedTimeTableHour): EmbeddedTimeTableHourJs {
	val startHour = intToNumber(obj.startHour)
	val endHour = intToNumber(obj.endHour)
	return EmbeddedTimeTableHourJs(js("{" +
		"startHour:startHour," +
		"endHour:endHour" +
	"}"))
}

public fun embeddedTimeTableHour_fromJs(obj: EmbeddedTimeTableHourJs): EmbeddedTimeTableHour {
	val startHour = numberToInt(obj.startHour, "obj.startHour")
	val endHour = numberToInt(obj.endHour, "obj.endHour")
	return EmbeddedTimeTableHour(
		startHour = startHour,
		endHour = endHour,
	)
}
