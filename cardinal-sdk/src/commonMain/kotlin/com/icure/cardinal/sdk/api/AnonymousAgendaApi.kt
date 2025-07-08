package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.PublicAgendasAndCalendarItemTypes
import com.icure.cardinal.sdk.utils.DefaultValue

interface AnonymousAgendaApi {

	suspend fun listAnonymousAgendaAndAppointmentTypes(
		groupId: String,
		userId: String,
	): PublicAgendasAndCalendarItemTypes

	suspend fun listAnonymousAvailabilities(
		groupId: String,
		agendaId: String,
		calendarItemTypeId: String,
		startDate: Long,
		endDate: Long,
		@DefaultValue("null")
		limit: Int? = null,
	): List<Long>
}
