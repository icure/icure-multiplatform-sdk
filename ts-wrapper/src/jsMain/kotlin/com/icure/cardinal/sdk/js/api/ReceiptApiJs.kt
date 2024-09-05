// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.model.DecryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
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
		options: dynamic,
	): Promise<DecryptedReceiptJs>

	public fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray>

	public fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun getEncryptionKeysOf(receipt: ReceiptJs): Promise<Array<String>>

	public fun hasWriteAccess(receipt: ReceiptJs): Promise<Boolean>

	public fun decryptPatientIdOf(receipt: ReceiptJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: ReceiptJs, delegates: Array<String>):
			Promise<Unit>

	public fun logReceipt(
		user: UserJs,
		docId: String,
		refs: Array<String>,
		blobType: String,
		blob: ByteArray,
	): Promise<ReceiptJs>

	public fun decrypt(receipt: EncryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun tryDecrypt(receipt: EncryptedReceiptJs): Promise<ReceiptJs>

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
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedReceiptJs>>

	public fun tryShareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedReceiptJs>>

	public fun shareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>): Promise<DecryptedReceiptJs>

	public fun modifyReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun getReceipt(entityId: String): Promise<DecryptedReceiptJs>

	public fun listByReference(reference: String): Promise<Array<DecryptedReceiptJs>>
}
