package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Message
import com.icure.sdk.model.MessagesReadStatusUpdate
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
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
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawMessageApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawMessageApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Message)

	// region common endpoints

	override suspend fun createMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun deleteMessages(messageIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun deleteMessage(messageId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessage(messageId: String): HttpResponse<EncryptedMessage> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessages(messageIds: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun listMessagesByTransportGuids(
		hcpId: String,
		transportGuids: ListOfIds,
	): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byTransportGuid", "list")
				parameter("hcpId", hcpId)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(transportGuids)
		}.wrap()

	override suspend fun findMessagesByHCPartyPatientForeignKeys(secretFKeys: String): HttpResponse<List<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byHcPartySecretForeignKeys")
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun listMessageIdsByDataOwnerPatientSentDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byDataOwnerPatientSentDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byHcPartySecretForeignKeys")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findMessages(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getChildrenMessages(messageId: String): HttpResponse<List<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", messageId, "children")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getMessagesChildren(parentIds: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "children", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(parentIds)
		}.wrap()

	override suspend fun listMessagesByInvoices(ids: ListOfIds): HttpResponse<List<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byInvoice")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun findMessagesByTransportGuid(
		transportGuid: String?,
		received: Boolean?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
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
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
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
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		reverse: Boolean?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
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
			accept(Application.Json)
		}.wrap()

	override suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "byFromAddress")
				parameter("fromAddress", fromAddress)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("hcpId", hcpId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun setMessagesStatusBits(
		status: Int,
		messageIds: ListOfIds,
	): HttpResponse<List<EncryptedMessage>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "status", "$status")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageIds)
		}.wrap()

	override suspend fun setMessagesReadStatus(`data`: MessagesReadStatusUpdate): HttpResponse<List<EncryptedMessage>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "readstatus")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(data)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMessage>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun filterMessagesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Message>,
	): HttpResponse<PaginatedList<EncryptedMessage>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun matchMessagesBy(filter: AbstractFilter<Message>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "match")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MessageAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createMessageInTopic(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "message", "topic")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	// endregion
}
