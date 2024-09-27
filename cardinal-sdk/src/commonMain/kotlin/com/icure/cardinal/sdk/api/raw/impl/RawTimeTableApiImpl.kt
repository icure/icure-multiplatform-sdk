package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawTimeTableApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.TimeTableAbstractFilterSerializer
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
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTimeTableApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawTimeTableApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.TimeTable)

	// region common endpoints

	override suspend fun createTimeTable(timeTableDto: EncryptedTimeTable): HttpResponse<EncryptedTimeTable> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(timeTableDto)
		}.wrap()

	override suspend fun deleteTimeTables(timeTableIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(timeTableIds)
		}.wrap()

	override suspend fun deleteTimeTablesWithRev(timeTableIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(timeTableIds)
		}.wrap()

	override suspend fun deleteTimeTable(timeTableId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", timeTableId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteTimeTable(timeTableId: String): HttpResponse<EncryptedTimeTable> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "undelete", timeTableId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeTimeTable(timeTableId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "purge", timeTableId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTimeTable(timeTableId: String): HttpResponse<EncryptedTimeTable> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", timeTableId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTimeTables(timeTableIds: ListOfIds): HttpResponse<List<EncryptedTimeTable>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(timeTableIds)
		}.wrap()

	override suspend fun modifyTimeTable(timeTableDto: EncryptedTimeTable): HttpResponse<EncryptedTimeTable> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(timeTableDto)
		}.wrap()

	override suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedTimeTable>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTimeTablesByAgendaId(agendaId: String): HttpResponse<List<EncryptedTimeTable>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "byAgendaId")
				parameter("agendaId", agendaId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun matchTimeTablesBy(filter: AbstractFilter<TimeTable>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TimeTableAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTimeTable>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "timeTable", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
