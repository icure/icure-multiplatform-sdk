package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Agenda
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.delete
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

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawAgendaApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun getAgendas(
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<Agenda, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda")
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(agendaDto)
        }.wrap()

    suspend fun deleteAgendas(agendaIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(agendaIds)
        }.wrap()

    suspend fun deleteAgenda(agendaId: String): HttpResponse<DocIdentifier> =
        delete {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda", agendaId)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getAgenda(agendaId: String): HttpResponse<Agenda> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda", agendaId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda", "byUser")
                parameter("userId", userId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getReadableAgendasForUser(userId: String): HttpResponse<List<Agenda>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda", "readableForUser")
                parameter("userId", userId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "agenda")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(agendaDto)
        }.wrap()

    // endregion
}
