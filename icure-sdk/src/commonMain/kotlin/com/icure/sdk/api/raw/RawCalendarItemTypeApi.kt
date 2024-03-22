package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.CalendarItemType
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemTypeApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getCalendarItemTypes(startDocumentId: String? = null, limit: Int? = null):
			HttpResponse<PaginatedList<CalendarItemType, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<CalendarItemType, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType","includeDeleted")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType):
			HttpResponse<CalendarItemType> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()


	suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds):
			HttpResponse<List<DocIdentifier>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()


	suspend fun getCalendarItemType(calendarItemTypeId: String): HttpResponse<CalendarItemType>
			= httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType",calendarItemTypeId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType):
			HttpResponse<CalendarItemType> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItemType")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	// endregion

}