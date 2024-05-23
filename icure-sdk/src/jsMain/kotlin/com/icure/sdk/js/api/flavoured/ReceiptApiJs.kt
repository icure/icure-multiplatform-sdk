// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedReceiptJs
import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.ReceiptJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptApi")
public external interface ReceiptApiJs {
	public val encrypted: ReceiptFlavouredApiJs<EncryptedReceiptJs>

	public val tryAndRecover: ReceiptFlavouredApiJs<ReceiptJs>

	public fun createReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun withEncryptionMetadata(
		base: DecryptedReceiptJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedReceiptJs>

	public fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray>

	public fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun deleteReceipt(entityId: String): Promise<DocIdentifierJs>

	public fun deleteReceipts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray>

	public fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun shareWith(
		delegateId: String,
		receipt: DecryptedReceiptJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedReceiptJs>>
}
