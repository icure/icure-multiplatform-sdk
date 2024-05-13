package com.icure.sdk.api.raw

import com.icure.sdk.model.AnonymousMedicalLocation
import com.icure.sdk.model.AppointmentTypeAndPlace
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.UserAndHealthcareParty
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAnonymousApi {
	// region anonymous healthcareparty endpoints

	suspend fun listHealthcarePartiesInGroup(groupId: String): HttpResponse<List<UserAndHealthcareParty>>
	// endregion

	// region anonymous medicallocation endpoints

	suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<AnonymousMedicalLocation>>
	// endregion

	// region anonymous calendaritem endpoints

	suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): HttpResponse<List<AppointmentTypeAndPlace>>

	suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		isNewPatient: Boolean,
		startDate: Long,
		endDate: Long,
		hcpId: String,
		placeId: String? = null,
		limit: Int? = null,
	): HttpResponse<List<Long>>
	// endregion
}
