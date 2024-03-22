package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Receipt
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
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
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawReceiptApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createReceipt(receiptDto: Receipt): HttpResponse<EncryptedReceipt> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptDto)
		}.wrap()


	suspend fun deleteReceipts(receiptIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptIds)
		}.wrap()


	suspend fun deleteReceipt(receiptId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt",receiptId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getReceiptAttachment(receiptId: String, attachmentId: String):
			HttpResponse<ByteArray> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt",receiptId,"attachment",attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun setReceiptAttachment(
		receiptId: String,
		blobType: String,
		rev: String,
		payload: ByteArray,
	): HttpResponse<EncryptedReceipt> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt",receiptId,"attachment",blobType)
				parameter("rev", rev)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			setBody(ByteReadChannel(payload))
		}.wrap()


	suspend fun getReceipt(receiptId: String): HttpResponse<EncryptedReceipt> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt",receiptId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listByReference(ref: String): HttpResponse<List<EncryptedReceipt>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt","byRef",ref)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyReceipt(receiptDto: Receipt): HttpResponse<EncryptedReceipt> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(receiptDto)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","receipt","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}