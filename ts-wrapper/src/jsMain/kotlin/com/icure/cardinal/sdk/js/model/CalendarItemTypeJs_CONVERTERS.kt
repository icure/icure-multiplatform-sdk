// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.CalendarItemType
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemType_toJs(obj: CalendarItemType): CalendarItemTypeJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val agendaId = nullToUndefined(
		obj.agendaId
	)
	val defaultCalendarItemType = obj.defaultCalendarItemType
	val name = nullToUndefined(
		obj.name
	)
	val color = nullToUndefined(
		obj.color
	)
	val duration = intToNumber(obj.duration)
	val externalRef = nullToUndefined(
		obj.externalRef
	)
	val mikronoId = nullToUndefined(
		obj.mikronoId
	)
	val docIds = setToArray(
		obj.docIds,
		{ x1: String ->
			x1
		},
	)
	val otherInfos = mapToObject(
		obj.otherInfos,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val subjectByLanguage = mapToObject(
		obj.subjectByLanguage,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CalendarItemTypeJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"healthcarePartyId:healthcarePartyId," +
		"agendaId:agendaId," +
		"defaultCalendarItemType:defaultCalendarItemType," +
		"name:name," +
		"color:color," +
		"duration:duration," +
		"externalRef:externalRef," +
		"mikronoId:mikronoId," +
		"docIds:docIds," +
		"otherInfos:otherInfos," +
		"subjectByLanguage:subjectByLanguage" +
	"}"))
}

public fun calendarItemType_fromJs(obj: CalendarItemTypeJs): CalendarItemType {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val agendaId = undefinedToNull(obj.agendaId)
	val defaultCalendarItemType = obj.defaultCalendarItemType
	val name = undefinedToNull(obj.name)
	val color = undefinedToNull(obj.color)
	val duration = numberToInt(obj.duration, "obj.duration")
	val externalRef = undefinedToNull(obj.externalRef)
	val mikronoId = undefinedToNull(obj.mikronoId)
	val docIds = arrayToSet(
		obj.docIds,
		"obj.docIds",
		{ x1: String ->
			x1
		},
	)
	val otherInfos = objectToMap(
		obj.otherInfos,
		"obj.otherInfos",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val subjectByLanguage = objectToMap(
		obj.subjectByLanguage,
		"obj.subjectByLanguage",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CalendarItemType(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		healthcarePartyId = healthcarePartyId,
		agendaId = agendaId,
		defaultCalendarItemType = defaultCalendarItemType,
		name = name,
		color = color,
		duration = duration,
		externalRef = externalRef,
		mikronoId = mikronoId,
		docIds = docIds,
		otherInfos = otherInfos,
		subjectByLanguage = subjectByLanguage,
	)
}
