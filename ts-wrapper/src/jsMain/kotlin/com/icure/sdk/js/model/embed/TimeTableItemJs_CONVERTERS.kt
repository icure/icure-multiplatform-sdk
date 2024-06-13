package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.TimeTableHour
import com.icure.sdk.model.embed.TimeTableItem
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timeTableItem_toJs(obj: TimeTableItem): TimeTableItemJs {
	val rruleStartDate = nullToUndefined(
		longToNumber(obj.rruleStartDate)
	)
	val rrule = nullToUndefined(
		obj.rrule
	)
	val notBeforeInMinutes = nullToUndefined(
		intToNumber(obj.notBeforeInMinutes)
	)
	val notAfterInMinutes = nullToUndefined(
		intToNumber(obj.notAfterInMinutes)
	)
	val zoneId = nullToUndefined(
		obj.zoneId
	)
	val days = listToArray(
		obj.days,
		{ x1: String ->
			x1
		},
	)
	val recurrenceTypes = listToArray(
		obj.recurrenceTypes,
		{ x1: String ->
			x1
		},
	)
	val hours = listToArray(
		obj.hours,
		{ x1: TimeTableHour ->
			timeTableHour_toJs(x1)
		},
	)
	val calendarItemTypeId = nullToUndefined(
		obj.calendarItemTypeId
	)
	val homeVisit = obj.homeVisit
	val placeId = nullToUndefined(
		obj.placeId
	)
	val publicTimeTableItem = obj.publicTimeTableItem
	val acceptsNewPatient = obj.acceptsNewPatient
	val unavailable = obj.unavailable
	return TimeTableItemJs(js("{" +
		"rruleStartDate:rruleStartDate," +
		"rrule:rrule," +
		"notBeforeInMinutes:notBeforeInMinutes," +
		"notAfterInMinutes:notAfterInMinutes," +
		"zoneId:zoneId," +
		"days:days," +
		"recurrenceTypes:recurrenceTypes," +
		"hours:hours," +
		"calendarItemTypeId:calendarItemTypeId," +
		"homeVisit:homeVisit," +
		"placeId:placeId," +
		"publicTimeTableItem:publicTimeTableItem," +
		"acceptsNewPatient:acceptsNewPatient," +
		"unavailable:unavailable" +
	"}"))
}

public fun timeTableItem_fromJs(obj: TimeTableItemJs): TimeTableItem {
	val rruleStartDate = numberToLong(obj.rruleStartDate, "obj.rruleStartDate")
	val rrule = undefinedToNull(obj.rrule)
	val notBeforeInMinutes = numberToInt(obj.notBeforeInMinutes, "obj.notBeforeInMinutes")
	val notAfterInMinutes = numberToInt(obj.notAfterInMinutes, "obj.notAfterInMinutes")
	val zoneId = undefinedToNull(obj.zoneId)
	val days = arrayToList(
		obj.days,
		"obj.days",
		{ x1: String ->
			x1
		},
	)
	val recurrenceTypes = arrayToList(
		obj.recurrenceTypes,
		"obj.recurrenceTypes",
		{ x1: String ->
			x1
		},
	)
	val hours = arrayToList(
		obj.hours,
		"obj.hours",
		{ x1: TimeTableHourJs ->
			timeTableHour_fromJs(x1)
		},
	)
	val calendarItemTypeId = undefinedToNull(obj.calendarItemTypeId)
	val homeVisit = obj.homeVisit
	val placeId = undefinedToNull(obj.placeId)
	val publicTimeTableItem = obj.publicTimeTableItem
	val acceptsNewPatient = obj.acceptsNewPatient
	val unavailable = obj.unavailable
	return TimeTableItem(
		rruleStartDate = rruleStartDate,
		rrule = rrule,
		notBeforeInMinutes = notBeforeInMinutes,
		notAfterInMinutes = notAfterInMinutes,
		zoneId = zoneId,
		days = days,
		recurrenceTypes = recurrenceTypes,
		hours = hours,
		calendarItemTypeId = calendarItemTypeId,
		homeVisit = homeVisit,
		placeId = placeId,
		publicTimeTableItem = publicTimeTableItem,
		acceptsNewPatient = acceptsNewPatient,
		unavailable = unavailable,
	)
}
