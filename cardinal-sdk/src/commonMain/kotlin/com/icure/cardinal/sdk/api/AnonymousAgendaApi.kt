package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.PublicAgendasAndCalendarItemTypes

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
		limit: Int? = null,
	): List<Long>
}
