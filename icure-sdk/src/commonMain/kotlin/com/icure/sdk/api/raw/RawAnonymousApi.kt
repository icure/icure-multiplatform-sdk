package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.AppointmentTypeAndPlace
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.AnonymousMedicalLocation
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.specializations.JsonString

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawAnonymousApi(
	private val apiUrl: String,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region anonymous calendaritem endpoints

	suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): HttpResponse<List<AppointmentTypeAndPlace>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","aa","appointmentType","inGroup",groupId,"forUser",userId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("ts", GMTDate().timestamp)
			}
		}.wrap()


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
	): HttpResponse<List<Long>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","aa","available","inGroup",groupId,"forUser",userId,"type",calendarItemTypeId)
				parameter("isNewPatient", isNewPatient)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcpId", hcpId)
				parameter("placeId", placeId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
		}.wrap()

	// endregion

	// region anonymous healthcareparty endpoints

	suspend fun listHealthcarePartiesInGroup(groupId: String):
			HttpResponse<List<HealthcareParty>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","aa","hcparty","inGroup",groupId)
				parameter("ts", GMTDate().timestamp)
			}
		}.wrap()

	// endregion

	// region anonymous medicallocation endpoints

	suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<AnonymousMedicalLocation, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","aa","medicallocation","byGroup",groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
		}.wrap()

	// endregion

}