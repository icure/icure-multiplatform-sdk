package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawReceiptApi {
	// region common endpoints

	suspend fun createReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt>

	suspend fun deleteReceipts(receiptIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteReceipt(receiptId: String): HttpResponse<DocIdentifier>

	suspend fun getReceiptAttachment(
		receiptId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun setReceiptAttachment(
		receiptId: String,
		blobType: String,
		rev: String,
		payload: ByteArray,
	): HttpResponse<EncryptedReceipt>

	suspend fun getReceipt(receiptId: String): HttpResponse<EncryptedReceipt>

	suspend fun listByReference(ref: String): HttpResponse<List<EncryptedReceipt>>

	suspend fun modifyReceipt(receiptDto: EncryptedReceipt): HttpResponse<EncryptedReceipt>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedReceipt>>>
	// endregion
}
