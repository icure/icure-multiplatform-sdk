package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawAnonymousApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.model.AnonymousMedicalLocation
import com.icure.sdk.model.AppointmentTypeAndPlace
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.UserAndHealthcareParty
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.appendPathSegments
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAnonymousApiImpl(
	internal val apiUrl: String,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawAnonymousApi {
	// region anonymous medicallocation endpoints

	override suspend fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<AnonymousMedicalLocation>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "aa", "medicallocation", "byGroup", groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(ContentType.Application.Json)
		}.wrap()

	// endregion

	// region anonymous healthcareparty endpoints

	override suspend fun listHealthcarePartiesInGroup(groupId: String): HttpResponse<List<UserAndHealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "aa", "hcparty", "inGroup", groupId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(ContentType.Application.Json)
		}.wrap()

	// endregion

	// region anonymous calendaritem endpoints

	override suspend fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Long,
		endDate: Long,
	): HttpResponse<List<AppointmentTypeAndPlace>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "aa", "appointmentType", "inGroup", groupId, "forUser", userId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("ts", GMTDate().timestamp)
			}
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		isNewPatient: Boolean,
		startDate: Long,
		endDate: Long,
		hcpId: String,
		placeId: String?,
		limit: Int?,
	): HttpResponse<List<Long>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "aa", "available", "inGroup", groupId, "forUser", userId, "type", calendarItemTypeId)
				parameter("isNewPatient", isNewPatient)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcpId", hcpId)
				parameter("placeId", placeId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(ContentType.Application.Json)
		}.wrap()

	// endregion
}
