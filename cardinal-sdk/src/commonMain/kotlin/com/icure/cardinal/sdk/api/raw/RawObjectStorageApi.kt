package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.objectstorage.StoredObjectInformation
import com.icure.utils.InternalIcureApi
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.Unit

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawObjectStorageApi {
	// region cloud endpoints

	suspend fun createAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
		size: Long,
		md5Hash: String,
		startByte: Long? = null,
		content: ByteArray,
	): HttpResponse<Unit>

	suspend fun getAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun getAttachmentInfo(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<StoredObjectInformation>
	// endregion
}
