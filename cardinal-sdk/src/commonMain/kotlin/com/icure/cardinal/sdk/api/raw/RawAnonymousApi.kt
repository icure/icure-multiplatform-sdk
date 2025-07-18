package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.AnonymousMedicalLocation
import com.icure.cardinal.sdk.model.AppointmentTypeAndPlace
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PublicAgendasAndCalendarItemTypes
import com.icure.cardinal.sdk.model.UserAndHealthcareParty
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAnonymousApi {
	// region anonymous calendaritem endpoints

	suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): HttpResponse<List<AppointmentTypeAndPlace>>

	suspend fun listAnonymousAgendaAndAppointmentTypes(
		groupId: String,
		propertyId: String,
		propertyValue: String,
	): HttpResponse<PublicAgendasAndCalendarItemTypes>

	suspend fun listAnonymousAvailabilities(
		groupId: String,
		agendaId: String,
		calendarItemTypeId: String,
		startDate: Long,
		endDate: Long,
		limit: Int? = null,
	): HttpResponse<List<Long>>

	suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		isNewPatient: Boolean,
		startDate: Long,
		endDate: Long,
		placeId: String? = null,
		limit: Int? = null,
	): HttpResponse<List<Long>>
	// endregion

	// region anonymous healthcareparty endpoints

	suspend fun listHealthcarePartiesInGroup(groupId: String): HttpResponse<List<UserAndHealthcareParty>>

	suspend fun listPublicHealthcarePartiesInGroup(groupId: String): HttpResponse<List<HealthcareParty>>
	// endregion

	// region anonymous icure endpoints

	suspend fun getPermissions(): HttpResponse<List<String>>
	// endregion

	// region anonymous medicallocation endpoints

	suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<AnonymousMedicalLocation>>
	// endregion
}
