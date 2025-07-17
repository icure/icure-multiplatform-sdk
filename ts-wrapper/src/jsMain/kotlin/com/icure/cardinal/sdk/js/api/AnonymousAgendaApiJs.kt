// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.PublicAgendasAndCalendarItemTypesJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AnonymousAgendaApi")
public external interface AnonymousAgendaApiJs {
	public fun listAnonymousAgendaAndAppointmentTypes(
		groupId: String,
		propertyId: String,
		propertyValue: String,
	): Promise<PublicAgendasAndCalendarItemTypesJs>

	public fun listAnonymousAvailabilities(
		groupId: String,
		agendaId: String,
		calendarItemTypeId: String,
		startDate: Double,
		endDate: Double,
		options: dynamic,
	): Promise<Array<Double>>
}
