// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.model.embed.EmbeddedTimeTableHour
import com.icure.cardinal.sdk.model.embed.EmbeddedTimeTableItem
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun embeddedTimeTableItem_toJs(obj: EmbeddedTimeTableItem): EmbeddedTimeTableItemJs {
	val rrule = obj.rrule
	val rruleStartDate = nullToUndefined(
		intToNumber(obj.rruleStartDate)
	)
	val notBeforeInMinutes = nullToUndefined(
		intToNumber(obj.notBeforeInMinutes)
	)
	val notAfterInMinutes = nullToUndefined(
		intToNumber(obj.notAfterInMinutes)
	)
	val hours = listToArray(
		obj.hours,
		{ x1: EmbeddedTimeTableHour ->
			embeddedTimeTableHour_toJs(x1)
		},
	)
	val calendarItemTypesIds = setToArray(
		obj.calendarItemTypesIds,
		{ x1: String ->
			x1
		},
	)
	val availabilities = intToNumber(obj.availabilities)
	val reservingRights = setToArray(
		obj.reservingRights,
		{ x1: String ->
			x1
		},
	)
	val public = obj.public
	return EmbeddedTimeTableItemJs(js("{" +
		"rrule:rrule," +
		"rruleStartDate:rruleStartDate," +
		"notBeforeInMinutes:notBeforeInMinutes," +
		"notAfterInMinutes:notAfterInMinutes," +
		"hours:hours," +
		"calendarItemTypesIds:calendarItemTypesIds," +
		"availabilities:availabilities," +
		"reservingRights:reservingRights," +
		"public:public" +
	"}"))
}

public fun embeddedTimeTableItem_fromJs(obj: EmbeddedTimeTableItemJs): EmbeddedTimeTableItem {
	val rrule = obj.rrule
	val rruleStartDate = numberToInt(obj.rruleStartDate, "obj.rruleStartDate")
	val notBeforeInMinutes = numberToInt(obj.notBeforeInMinutes, "obj.notBeforeInMinutes")
	val notAfterInMinutes = numberToInt(obj.notAfterInMinutes, "obj.notAfterInMinutes")
	val hours = arrayToList(
		obj.hours,
		"obj.hours",
		{ x1: EmbeddedTimeTableHourJs ->
			embeddedTimeTableHour_fromJs(x1)
		},
	)
	val calendarItemTypesIds = arrayToSet(
		obj.calendarItemTypesIds,
		"obj.calendarItemTypesIds",
		{ x1: String ->
			x1
		},
	)
	val availabilities = numberToInt(obj.availabilities, "obj.availabilities")
	val reservingRights = arrayToSet(
		obj.reservingRights,
		"obj.reservingRights",
		{ x1: String ->
			x1
		},
	)
	val public = obj.public
	return EmbeddedTimeTableItem(
		rrule = rrule,
		rruleStartDate = rruleStartDate,
		notBeforeInMinutes = notBeforeInMinutes,
		notAfterInMinutes = notAfterInMinutes,
		hours = hours,
		calendarItemTypesIds = calendarItemTypesIds,
		availabilities = availabilities,
		reservingRights = reservingRights,
		public = public,
	)
}
