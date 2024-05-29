package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawDocumentApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.ListOfIds
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
import kotlinx.serialization.json.Json.Json
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDocumentApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawDocumentApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Document)

	// region common endpoints

	override suspend fun createDocument(
		documentDto: EncryptedDocument,
		strict: Boolean?,
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

	override suspend fun deleteDocuments(documentIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun deleteDocument(documentId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getMainAttachment(
		documentId: String,
		fileName: String?,
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

	override suspend fun deleteAttachment(
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

	override suspend fun setDocumentAttachment(
		documentId: String,
		rev: String,
		utis: List<String>?,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean?,
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

	override suspend fun getDocument(documentId: String): HttpResponse<EncryptedDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", documentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getDocumentByExternalUuid(externalUuid: String): HttpResponse<EncryptedDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getDocumentsByExternalUuid(externalUuid: String): HttpResponse<List<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "externaluuid", externalUuid, "all")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getDocuments(documentIds: ListOfIds): HttpResponse<List<EncryptedDocument>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentIds)
		}.wrap()

	override suspend fun modifyDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun modifyDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
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

	override suspend fun listDocumentIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "byDataOwnerPatientCreated")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findWithoutDelegation(limit: Int?): HttpResponse<List<EncryptedDocument>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "woDelegation")
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun setSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean?,
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

	override suspend fun getSecondaryAttachment(
		documentId: String,
		key: String,
		fileName: String?,
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

	override suspend fun deleteSecondaryAttachment(
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

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedDocument>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "document", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
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
