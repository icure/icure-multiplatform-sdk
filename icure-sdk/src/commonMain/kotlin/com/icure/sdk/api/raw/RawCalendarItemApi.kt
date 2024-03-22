package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getCalendarItems(startDocumentId: String? = null, limit: Int? = null):
			HttpResponse<PaginatedList<EncryptedCalendarItem, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createCalendarItem(calendarItemDto: CalendarItem):
			HttpResponse<EncryptedCalendarItem> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemDto)
		}.wrap()


	suspend fun deleteCalendarItems(calendarItemIds: ListOfIds):
			HttpResponse<List<DocIdentifier>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemIds)
		}.wrap()


	suspend fun deleteCalendarItem(calendarItemId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem",calendarItemId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteCalendarItemsWithPost(calendarItemIds: String):
			HttpResponse<List<DocIdentifier>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem",calendarItemIds)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem",calendarItemId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyCalendarItem(calendarItemDto: CalendarItem):
			HttpResponse<EncryptedCalendarItem> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemDto)
		}.wrap()


	suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): HttpResponse<List<EncryptedCalendarItem>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byPeriodAndHcPartyId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedCalendarItem>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getCalendarItemsWithIds(calendarItemIds: ListOfIds?):
			HttpResponse<List<EncryptedCalendarItem>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(calendarItemIds)
		}.wrap()


	suspend fun listCalendarItemsByHCPartyPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedCalendarItem>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listCalendarItemsByHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: List<String>): HttpResponse<List<EncryptedCalendarItem>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byHcPartySecretForeignKeys","page","$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem, JsonString>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byHcPartySecretForeignKeys","page","$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedCalendarItem, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","byRecurrenceId")
				parameter("recurrenceId", recurrenceId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","calendarItem","bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}