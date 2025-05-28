package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AnonymousApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.cardinal.sdk.model.AnonymousMedicalLocation
import com.icure.cardinal.sdk.model.AppointmentTypeAndPlace
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.UserAndHealthcareParty
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class AnonymousApiImpl(
	private val rawAnonymousApi: RawAnonymousApi,
): AnonymousApi {
	override suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): List<AppointmentTypeAndPlace> = rawAnonymousApi.listAppointmentTypesForUser(
		groupId = groupId,
		userId = userId,
		startDate = startDate,
		endDate = endDate
	).successBody()

	override suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		startDate: Long,
		endDate: Long,
		isNewPatient: Boolean,
		placeId: String?,
		limit: Int?,
	): List<Long> = rawAnonymousApi.getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId = groupId,
		userId = userId,
		calendarItemTypeId = calendarItemTypeId,
		startDate = startDate,
		endDate = endDate,
		isNewPatient = isNewPatient,
		placeId = placeId,
		limit = limit,
		hcpId = ""
	).successBody()

	override suspend fun listHealthcarePartiesInGroup(groupId: String): List<UserAndHealthcareParty> =
		rawAnonymousApi.listHealthcarePartiesInGroup(groupId).successBody()

	override suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<AnonymousMedicalLocation> = rawAnonymousApi.getPublicMedicalLocationsByGroupId(
		groupId = groupId,
		startKey = startKey,
		startDocumentId = startDocumentId,
		limit = limit
	).successBody()
}
