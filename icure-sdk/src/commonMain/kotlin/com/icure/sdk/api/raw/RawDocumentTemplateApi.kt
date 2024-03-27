package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
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
import io.ktor.utils.io.ByteReadChannel
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawDocumentTemplateApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun getDocumentTemplate(documentTemplateId: String): HttpResponse<DocumentTemplate> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", documentTemplateId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun deleteDocumentTemplates(documentTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(documentTemplateIds)
        }.wrap()

    suspend fun listDocumentTemplatesBySpeciality(specialityCode: String): HttpResponse<List<DocumentTemplate>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", "bySpecialty", specialityCode)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listDocumentTemplatesByDocumentType(documentTypeCode: String): HttpResponse<List<DocumentTemplate>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", "byDocumentType", documentTypeCode)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: String): HttpResponse<List<DocumentTemplate>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", "byDocumentTypeForCurrentUser", documentTypeCode)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listDocumentTemplates(): HttpResponse<List<DocumentTemplate>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findAllDocumentTemplates(
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<DocumentTemplate, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", "find", "all")
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createDocumentTemplate(ft: DocumentTemplate): HttpResponse<DocumentTemplate> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(ft)
        }.wrap()

    suspend fun modifyDocumentTemplate(
        documentTemplateId: String,
        ft: DocumentTemplate,
    ): HttpResponse<DocumentTemplate> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", documentTemplateId)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(ft)
        }.wrap()

    suspend fun getDocumentTemplateAttachment(
        documentTemplateId: String,
        attachmentId: String,
    ): HttpResponse<ByteArray> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachment", attachmentId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getAttachmentText(
        documentTemplateId: String,
        attachmentId: String,
    ): HttpResponse<ByteArray> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachmentText", attachmentId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun setDocumentTemplateAttachment(
        documentTemplateId: String,
        payload: ByteArray,
    ): HttpResponse<DocumentTemplate> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "doctemplate", documentTemplateId, "attachment")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.OctetStream)
            setBody(ByteReadChannel(payload))
        }.wrap()

    // endregion
}
