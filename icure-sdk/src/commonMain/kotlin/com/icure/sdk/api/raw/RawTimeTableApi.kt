package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
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
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTimeTableApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createTimeTable(timeTableDto: TimeTable): HttpResponse<EncryptedTimeTable> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(timeTableDto)
		}.wrap()


	suspend fun deleteTimeTables(timeTableIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(timeTableIds)
		}.wrap()


	suspend fun deleteTimeTable(timeTableId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable",timeTableId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTimeTable(timeTableId: String): HttpResponse<EncryptedTimeTable> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable",timeTableId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyTimeTable(timeTableDto: TimeTable): HttpResponse<EncryptedTimeTable> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(timeTableDto)
		}.wrap()


	suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedTimeTable>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable","byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getTimeTablesByAgendaId(agendaId: String):
			HttpResponse<List<EncryptedTimeTable>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable","byAgendaId")
				parameter("agendaId", agendaId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedTimeTable>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","timeTable","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}