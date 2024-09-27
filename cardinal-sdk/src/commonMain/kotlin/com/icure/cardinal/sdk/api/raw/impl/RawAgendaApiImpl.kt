package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawAgendaApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.AgendaAbstractFilterSerializer
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
	private val authProvider: AuthProvider,
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
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(agendaDto)
		}.wrap()

	override suspend fun deleteAgendas(agendaIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(agendaIds)
		}.wrap()

	override suspend fun deleteAgendasWithRev(agendaIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(agendaIds)
		}.wrap()

	override suspend fun deleteAgenda(agendaId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", agendaId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteAgenda(agendaId: String): HttpResponse<Agenda> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "undelete", agendaId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeAgenda(agendaId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "purge", agendaId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getAgenda(agendaId: String): HttpResponse<Agenda> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", agendaId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "byUser")
				parameter("userId", userId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getReadableAgendasForUser(userId: String): HttpResponse<List<Agenda>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "readableForUser")
				parameter("userId", userId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(agendaDto)
		}.wrap()

	override suspend fun matchAgendasBy(filter: AbstractFilter<Agenda>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(AgendaAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getAgendasByIds(agendaIds: ListOfIds): HttpResponse<List<Agenda>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "agenda", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(agendaIds)
		}.wrap()

	// endregion
}
