package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
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

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawTarificationApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun findTarificationsByLabel(
        region: String? = null,
        types: String? = null,
        language: String? = null,
        label: String? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<Tarification, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification", "byLabel")
                parameter("region", region)
                parameter("types", types)
                parameter("language", language)
                parameter("label", label)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findTarificationsBy(
        region: String? = null,
        type: String? = null,
        tarification: String? = null,
        version: String? = null,
        startDocumentId: String? = null,
        startKey: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<Tarification, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification")
                parameter("region", region)
                parameter("type", type)
                parameter("tarification", tarification)
                parameter("version", version)
                parameter("startDocumentId", startDocumentId)
                parameter("startKey", startKey)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findTarificationsBy(
        region: String? = null,
        type: String? = null,
        tarification: String? = null,
        version: String? = null,
    ): HttpResponse<List<Tarification>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification", "byRegionTypeTarification")
                parameter("region", region)
                parameter("type", type)
                parameter("tarification", tarification)
                parameter("version", version)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createTarification(c: Tarification): HttpResponse<Tarification> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(c)
        }.wrap()

    suspend fun getTarifications(tarificationIds: ListOfIds): HttpResponse<List<Tarification>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification", "byIds")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(tarificationIds)
        }.wrap()

    suspend fun getTarification(tarificationId: String): HttpResponse<Tarification> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification", tarificationId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getTarificationWithParts(
        type: String,
        tarification: String,
        version: String,
    ): HttpResponse<Tarification> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification", type, tarification, version)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun modifyTarification(tarificationDto: Tarification): HttpResponse<Tarification> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "tarification")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(tarificationDto)
        }.wrap()

    // endregion
}
