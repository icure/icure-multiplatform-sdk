package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedClassification
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
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawClassificationApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun createClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(c)
        }.wrap()

    suspend fun getClassification(classificationId: String): HttpResponse<EncryptedClassification> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", classificationId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getClassificationByHcPartyId(ids: String): HttpResponse<List<EncryptedClassification>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "byIds", ids)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findClassificationsByHCPartyPatientForeignKeys(
        hcPartyId: String,
        secretFKeys: String,
    ): HttpResponse<List<EncryptedClassification>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "byHcPartySecretForeignKeys")
                parameter("hcPartyId", hcPartyId)
                parameter("secretFKeys", secretFKeys)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findClassificationsByHCPartyPatientForeignKey(
        hcPartyId: String,
        secretFKey: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedClassification, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "byHcPartySecretForeignKey")
                parameter("hcPartyId", hcPartyId)
                parameter("secretFKey", secretFKey)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun deleteClassifications(classificationIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(classificationIds)
        }.wrap()

    suspend fun deleteClassification(classificationId: String): HttpResponse<DocIdentifier> =
        delete {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", classificationId)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun modifyClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(classificationDto)
        }.wrap()

    suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "bulkSharedMetadataUpdate")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    suspend fun bulkShareMinimal(
        request: BulkShareOrUpdateMetadataParams,
    ): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "classification", "bulkSharedMetadataUpdateMinimal")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    // endregion
}
