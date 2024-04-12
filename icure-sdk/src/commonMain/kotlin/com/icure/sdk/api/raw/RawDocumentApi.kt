package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDocumentApi(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Document)

	// region common endpoints

	suspend fun createDocument(
		documentDto: EncryptedDocument,
		strict: Boolean? = null,
	): HttpResponse<EncryptedDocument> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document")
				parameter("strict", strict)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDto)
		}.wrap()

	suspend fun deleteDocuments(documentIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentIds)
		}.wrap()

	suspend fun deleteDocument(documentId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getMainAttachment(
		documentId: String,
		fileName: String? = null,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteAttachment(
		documentId: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("rev", rev)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun setDocumentAttachment(
		documentId: String,
		rev: String,
		utis: List<String>? = null,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean? = null,
	): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "attachment")
				parameter("rev", rev)
				parameter("utis", utis)
				parameter("encrypted", encrypted)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			header("Content-Length", lengthHeader)
			setBody(ByteReadChannel(payload))
		}.wrap()

	suspend fun getDocument(documentId: String): HttpResponse<EncryptedDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getDocumentByExternalUuid(externalUuid: String): HttpResponse<EncryptedDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getDocumentsByExternalUuid(externalUuid: String): HttpResponse<List<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid, "all")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getDocuments(documentIds: ListOfIds): HttpResponse<List<EncryptedDocument>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentIds)
		}.wrap()

	suspend fun modifyDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDto)
		}.wrap()

	suspend fun modifyDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDtos)
		}.wrap()

	suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String? = null,
		secretMessageKeys: List<String>,
	): HttpResponse<List<EncryptedDocument>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("documentTypeCode", documentTypeCode)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretMessageKeys)
		}.wrap()

	suspend fun findDocumentsByHCPartyMessageForeignKey(
		hcPartyId: String,
		secretMessageKeys: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byHcPartySecretForeignKey")
				parameter("hcPartyId", hcPartyId)
				parameter("secretMessageKeys", secretMessageKeys)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findWithoutDelegation(limit: Int? = null): HttpResponse<List<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "woDelegation")
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun setSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>? = null,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean? = null,
	): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("rev", rev)
				parameter("utis", utis)
				parameter("encrypted", encrypted)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			header("Content-Length", lengthHeader)
			setBody(ByteReadChannel(payload))
		}.wrap()

	suspend fun getSecondaryAttachment(
		documentId: String,
		key: String,
		fileName: String? = null,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedDocument> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId, "secondaryAttachments", key)
				parameter("rev", rev)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
