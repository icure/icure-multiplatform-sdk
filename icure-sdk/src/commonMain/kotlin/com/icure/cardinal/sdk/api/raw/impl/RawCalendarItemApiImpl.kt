package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.CalendarItemAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
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
	private val authProvider: AuthProvider,
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
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun deleteCalendarItems(calendarItemIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun deleteCalendarItem(calendarItemId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndHcPartyId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemsWithIds(calendarItemIds: ListOfIds): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemIdsByDataOwnerPatientStartTime(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byDataOwnerPatientStartTime")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byRecurrenceId")
				parameter("recurrenceId", recurrenceId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchCalendarItemsBy(filter: AbstractFilter<CalendarItem>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(CalendarItemAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
