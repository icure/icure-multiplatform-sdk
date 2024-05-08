package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawReceiptApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawReceiptApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawReceiptApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Receipt)

	// region common endpoints

	override suspend fun createReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun deleteReceipts(receiptIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptIds)
		}.wrap()

	override suspend fun deleteReceipt(receiptId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getReceiptAttachment(
		receiptId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId, "attachment", attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun setReceiptAttachment(
		receiptId: String,
		blobType: String,
		rev: String,
		payload: ByteArray,
	): HttpResponse<EncryptedReceipt> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId, "attachment", blobType)
				parameter("rev", rev)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			setBody(ByteReadChannel(payload))
		}.wrap()

	override suspend fun getReceipt(receiptId: String): HttpResponse<EncryptedReceipt> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", receiptId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listByReference(ref: String): HttpResponse<List<EncryptedReceipt>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "byRef", ref)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptDto)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "receipt", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
