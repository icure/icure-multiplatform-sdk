package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawAgendaApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Agenda
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
import kotlinx.serialization.json.Json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAgendaApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawAgendaApi {
	// region common endpoints

	override suspend fun getAgendas(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Agenda>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(agendaDto)
		}.wrap()

	override suspend fun deleteAgendas(agendaIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(agendaIds)
		}.wrap()

	override suspend fun deleteAgenda(agendaId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", agendaId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getAgenda(agendaId: String): HttpResponse<Agenda> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", agendaId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "byUser")
				parameter("userId", userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getReadableAgendasForUser(userId: String): HttpResponse<List<Agenda>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "readableForUser")
				parameter("userId", userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(agendaDto)
		}.wrap()

	// endregion
}
