package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.AnonymousMedicalLocation
import com.icure.cardinal.sdk.model.AppointmentTypeAndPlace
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.UserAndHealthcareParty

interface AnonymousApi {

	suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): List<AppointmentTypeAndPlace>

	suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		startDate: Long,
		endDate: Long,
		isNewPatient: Boolean = false,
		placeId: String? = null,
		limit: Int? = null,
	): List<Long>

	suspend fun listHealthcarePartiesInGroup(groupId: String): List<UserAndHealthcareParty>

	suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<AnonymousMedicalLocation>

}
