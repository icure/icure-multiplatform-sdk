package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.RegimenItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun regimenItem_toJs(obj: RegimenItem): RegimenItemJs {
	val date = nullToUndefined(
		longToNumber(obj.date)
	)
	val dayNumber = nullToUndefined(
		intToNumber(obj.dayNumber)
	)
	val weekday = nullToUndefined(
		obj.weekday?.let { nonNull1 ->
			weekday_toJs(nonNull1)
		}
	)
	val dayPeriod = nullToUndefined(
		obj.dayPeriod?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val timeOfDay = nullToUndefined(
		longToNumber(obj.timeOfDay)
	)
	val administratedQuantity = nullToUndefined(
		obj.administratedQuantity?.let { nonNull1 ->
			administrationQuantity_toJs(nonNull1)
		}
	)
	return RegimenItemJs(js("{" +
		"date:date," +
		"dayNumber:dayNumber," +
		"weekday:weekday," +
		"dayPeriod:dayPeriod," +
		"timeOfDay:timeOfDay," +
		"administratedQuantity:administratedQuantity" +
	"}"))
}

public fun regimenItem_fromJs(obj: RegimenItemJs): RegimenItem {
	val date = numberToLong(obj.date, "obj.date")
	val dayNumber = numberToInt(obj.dayNumber, "obj.dayNumber")
	val weekday = obj.weekday?.let { nonNull1 ->
		weekday_fromJs(nonNull1)
	}
	val dayPeriod = obj.dayPeriod?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val timeOfDay = numberToLong(obj.timeOfDay, "obj.timeOfDay")
	val administratedQuantity = obj.administratedQuantity?.let { nonNull1 ->
		administrationQuantity_fromJs(nonNull1)
	}
	return RegimenItem(
		date = date,
		dayNumber = dayNumber,
		weekday = weekday,
		dayPeriod = dayPeriod,
		timeOfDay = timeOfDay,
		administratedQuantity = administratedQuantity,
	)
}
