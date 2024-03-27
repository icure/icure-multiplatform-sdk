package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
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
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawAccessLogApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun createAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(accessLogDto)
        }.wrap()

    suspend fun deleteAccessLogs(accessLogIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(accessLogIds)
        }.wrap()

    suspend fun deleteAccessLog(accessLogId: String): HttpResponse<DocIdentifier> =
        delete {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", accessLogId)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getAccessLog(accessLogId: String): HttpResponse<EncryptedAccessLog> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", accessLogId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findAccessLogsBy(
        fromEpoch: Long? = null,
        toEpoch: Long? = null,
        startKey: Long? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        descending: Boolean? = null,
    ): HttpResponse<PaginatedList<EncryptedAccessLog, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog")
                parameter("fromEpoch", fromEpoch)
                parameter("toEpoch", toEpoch)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("descending", descending)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findAccessLogsByUserAfterDate(
        userId: String,
        accessType: String? = null,
        startDate: Long? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        descending: Boolean? = null,
    ): HttpResponse<PaginatedList<EncryptedAccessLog, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "byUser")
                parameter("userId", userId)
                parameter("accessType", accessType)
                parameter("startDate", startDate)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("descending", descending)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listAccessLogsByHCPartyAndPatientForeignKeys(
        hcPartyId: String,
        secretFKeys: String,
    ): HttpResponse<List<EncryptedAccessLog>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "byHcPartySecretForeignKeys")
                parameter("hcPartyId", hcPartyId)
                parameter("secretFKeys", secretFKeys)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findAccessLogsByHCPartyPatientForeignKey(
        hcPartyId: String,
        secretFKey: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedAccessLog, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "byHcPartySecretForeignKey")
                parameter("hcPartyId", hcPartyId)
                parameter("secretFKey", secretFKey)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findAccessLogsByHCPartyPatientForeignKeys(
        hcPartyId: String,
        secretPatientKeys: List<String>,
    ): HttpResponse<List<EncryptedAccessLog>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "byHcPartySecretForeignKeys")
                parameter("hcPartyId", hcPartyId)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(secretPatientKeys)
        }.wrap()

    suspend fun modifyAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(accessLogDto)
        }.wrap()

    suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "bulkSharedMetadataUpdate")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    // endregion

    // region cloud endpoints

    suspend fun findAccessLogsInGroup(
        groupId: String,
        fromEpoch: Long? = null,
        toEpoch: Long? = null,
        startKey: Long? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedAccessLog, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId)
                parameter("fromEpoch", fromEpoch)
                parameter("toEpoch", toEpoch)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    // endregion
}
