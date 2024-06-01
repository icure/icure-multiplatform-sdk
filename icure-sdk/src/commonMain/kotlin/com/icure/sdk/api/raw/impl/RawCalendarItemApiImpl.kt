package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawCalendarItemApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.CalendarItem)

	// region common endpoints

	override suspend fun getCalendarItems(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun createCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun deleteCalendarItems(calendarItemIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun deleteCalendarItem(calendarItemId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun deleteCalendarItemsWithPost(calendarItemIds: String): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemIds)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun modifyCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndHcPartyId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getCalendarItemsWithIds(calendarItemIds: ListOfIds): HttpResponse<List<EncryptedCalendarItem>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemIdsByDataOwnerPatientStartTime(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byDataOwnerPatientStartTime")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byRecurrenceId")
				parameter("recurrenceId", recurrenceId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
