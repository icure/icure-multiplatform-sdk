package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MessagesReadStatusUpdate
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
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
class RawMessageApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun createMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(messageDto)
        }.wrap()

    suspend fun deleteMessages(messageIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "delete", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(messageIds)
        }.wrap()

    suspend fun deleteMessage(messageId: String): HttpResponse<DocIdentifier> =
        delete {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", messageId)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getMessage(messageId: String): HttpResponse<EncryptedMessage> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", messageId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun listMessagesByTransportGuids(
        hcpId: String,
        transportGuids: ListOfIds,
    ): HttpResponse<List<EncryptedMessage>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byTransportGuid", "list")
                parameter("hcpId", hcpId)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(transportGuids)
        }.wrap()

    suspend fun findMessagesByHCPartyPatientForeignKeys(secretFKeys: String): HttpResponse<List<EncryptedMessage>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byHcPartySecretForeignKeys")
                parameter("secretFKeys", secretFKeys)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): HttpResponse<List<EncryptedMessage>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byHcPartySecretForeignKeys")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(secretPatientKeys)
        }.wrap()

    suspend fun findMessagesByHCPartyPatientForeignKey(
        secretFKey: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byHcPartySecretForeignKey")
                parameter("secretFKey", secretFKey)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findMessages(
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message")
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getChildrenMessages(messageId: String): HttpResponse<List<EncryptedMessage>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", messageId, "children")
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun getMessagesChildren(parentIds: ListOfIds): HttpResponse<List<EncryptedMessage>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "children", "batch")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(parentIds)
        }.wrap()

    suspend fun listMessagesByInvoices(ids: ListOfIds): HttpResponse<List<EncryptedMessage>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byInvoice")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(ids)
        }.wrap()

    suspend fun findMessagesByTransportGuid(
        transportGuid: String? = null,
        received: Boolean? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        hcpId: String? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byTransportGuid")
                parameter("transportGuid", transportGuid)
                parameter("received", received)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("hcpId", hcpId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findMessagesByTransportGuidSentDate(
        transportGuid: String,
        from: Long,
        to: Long,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        hcpId: String? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byTransportGuidSentDate")
                parameter("transportGuid", transportGuid)
                parameter("from", from)
                parameter("to", to)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("hcpId", hcpId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findMessagesByToAddress(
        toAddress: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        reverse: Boolean? = null,
        hcpId: String? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byToAddress")
                parameter("toAddress", toAddress)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("reverse", reverse)
                parameter("hcpId", hcpId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun findMessagesByFromAddress(
        fromAddress: String,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        hcpId: String? = null,
    ): HttpResponse<PaginatedList<EncryptedMessage, JsonString>> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "byFromAddress")
                parameter("fromAddress", fromAddress)
                parameter("startKey", startKey)
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
                parameter("hcpId", hcpId)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun modifyMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(messageDto)
        }.wrap()

    suspend fun setMessagesStatusBits(
        status: Int,
        messageIds: ListOfIds,
    ): HttpResponse<List<EncryptedMessage>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "status", "$status")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(messageIds)
        }.wrap()

    suspend fun setMessagesReadStatus(`data`: MessagesReadStatusUpdate): HttpResponse<List<EncryptedMessage>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "readstatus")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(data)
        }.wrap()

    suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMessage>>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "bulkSharedMetadataUpdate")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.wrap()

    suspend fun filterMessagesBy(
        startDocumentId: String? = null,
        limit: Int? = null,
        filterChain: FilterChain<EncryptedMessage>,
    ): HttpResponse<PaginatedList<EncryptedMessage, *>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "filter")
                parameter("startDocumentId", startDocumentId)
                parameter("limit", limit)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(filterChain)
        }.wrap()

    suspend fun matchMessagesBy(filter: AbstractFilter<EncryptedMessage>): HttpResponse<List<String>> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "match")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(filter)
        }.wrap()

    // endregion

    // region cloud endpoints

    suspend fun createMessageInTopic(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "message", "topic")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(messageDto)
        }.wrap()

    // endregion
}
