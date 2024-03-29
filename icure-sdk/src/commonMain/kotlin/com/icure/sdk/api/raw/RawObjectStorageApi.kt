package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.objectstorage.StoredObjectInformation
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawObjectStorageApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region cloud endpoints

	suspend fun createAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
		size: Long,
		md5Hash: String,
		startByte: Long? = null,
		content: ByteArray,
	): HttpResponse<Unit> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","objectstorage{entityGroup}",entityId,attachmentId)
				parameter("size", size)
				parameter("md5Hash", md5Hash)
				parameter("startByte", startByte)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.OctetStream)
			setBody(ByteReadChannel(content))
		}.wrap()


	suspend fun getAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","objectstorage{entityGroup}",entityId,attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getAttachmentInfo(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<StoredObjectInformation> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","objectstorage{entityGroup}",entityId,attachmentId,"info")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion

}
