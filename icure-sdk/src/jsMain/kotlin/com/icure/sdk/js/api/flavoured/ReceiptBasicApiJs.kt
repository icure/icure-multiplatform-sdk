// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("ReceiptBasicApi")
public external interface ReceiptBasicApiJs {
	public fun deleteReceipt(entityId: String): Promise<DocIdentifierJs>

	public fun deleteReceipts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray>

	public fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs>

	public fun getReceipt(entityId: String): Promise<EncryptedReceiptJs>

	public fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>>
}
