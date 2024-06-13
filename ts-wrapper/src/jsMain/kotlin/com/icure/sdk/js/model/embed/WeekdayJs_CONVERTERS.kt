package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.Weekday
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun weekday_toJs(obj: Weekday): WeekdayJs {
	val weekday = nullToUndefined(
		obj.weekday?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val weekNumber = nullToUndefined(
		intToNumber(obj.weekNumber)
	)
	return WeekdayJs(js("{" +
		"weekday:weekday," +
		"weekNumber:weekNumber" +
	"}"))
}

public fun weekday_fromJs(obj: WeekdayJs): Weekday {
	val weekday = obj.weekday?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val weekNumber = numberToInt(obj.weekNumber, "obj.weekNumber")
	return Weekday(
		weekday = weekday,
		weekNumber = weekNumber,
	)
}
