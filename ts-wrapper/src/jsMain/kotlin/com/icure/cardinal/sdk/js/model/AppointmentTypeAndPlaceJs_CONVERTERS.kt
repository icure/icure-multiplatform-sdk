// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.embed.address_fromJs
import com.icure.cardinal.sdk.js.model.embed.address_toJs
import com.icure.cardinal.sdk.model.AppointmentTypeAndPlace
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun appointmentTypeAndPlace_toJs(obj: AppointmentTypeAndPlace): AppointmentTypeAndPlaceJs {
	val calendarItemTypeId = obj.calendarItemTypeId
	val name = nullToUndefined(
		obj.name
	)
	val color = nullToUndefined(
		obj.color
	)
	val duration = intToNumber(obj.duration)
	val subjectByLanguage = nullToUndefined(
		mapToObject(
			obj.subjectByLanguage,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	)
	val placeId = nullToUndefined(
		obj.placeId
	)
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	val acceptsNewPatients = obj.acceptsNewPatients
	return AppointmentTypeAndPlaceJs(js("{" +
		"calendarItemTypeId:calendarItemTypeId," +
		"name:name," +
		"color:color," +
		"duration:duration," +
		"subjectByLanguage:subjectByLanguage," +
		"placeId:placeId," +
		"address:address," +
		"acceptsNewPatients:acceptsNewPatients" +
	"}"))
}

public fun appointmentTypeAndPlace_fromJs(obj: AppointmentTypeAndPlaceJs): AppointmentTypeAndPlace {
	val calendarItemTypeId = obj.calendarItemTypeId
	val name = undefinedToNull(obj.name)
	val color = undefinedToNull(obj.color)
	val duration = numberToInt(obj.duration, "obj.duration")
	val subjectByLanguage = objectToMapNullsafe(
		obj.subjectByLanguage,
		"obj.subjectByLanguage",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val placeId = undefinedToNull(obj.placeId)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val acceptsNewPatients = obj.acceptsNewPatients
	return AppointmentTypeAndPlace(
		calendarItemTypeId = calendarItemTypeId,
		name = name,
		color = color,
		duration = duration,
		subjectByLanguage = subjectByLanguage,
		placeId = placeId,
		address = address,
		acceptsNewPatients = acceptsNewPatients,
	)
}
