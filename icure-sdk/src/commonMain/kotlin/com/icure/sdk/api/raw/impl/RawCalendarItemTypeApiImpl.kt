package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawCalendarItemTypeApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.CalendarItemType
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemTypeApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawCalendarItemTypeApi {
	// region common endpoints

	override suspend fun getCalendarItemTypes(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<CalendarItemType>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<CalendarItemType>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "includeDeleted")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	override suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun getCalendarItemType(calendarItemTypeId: String): HttpResponse<CalendarItemType> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", calendarItemTypeId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	// endregion
}
