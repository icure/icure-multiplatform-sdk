// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ReceiptBasicApi
import com.icure.sdk.js.api.flavoured.ReceiptBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.receipt_toJs
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ReceiptBasicApiImplJs(
	private val receiptBasicApi: ReceiptBasicApi,
) : ReceiptBasicApiJs {
	override fun deleteReceipt(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(receiptBasicApi.deleteReceipt(entityId))}


	override fun deleteReceipts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			receiptBasicApi.deleteReceipts(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray> =
			GlobalScope.promise {
		receiptBasicApi.getRawReceiptAttachment(receiptId, attachmentId)}


	override fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptBasicApi.setRawReceiptAttachment(receiptId, rev, blobType, attachment))}


	override fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
			GlobalScope.promise {
		receipt_toJs(receiptBasicApi.modifyReceipt(com.icure.sdk.js.model.receipt_fromJs(entity)))}


	override fun getReceipt(entityId: String): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptBasicApi.getReceipt(entityId))}


	override fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>> =
			GlobalScope.promise {
		listToArray(
			receiptBasicApi.listByReference(reference),
			{ x1: EncryptedReceipt ->
				receipt_toJs(x1)
			},
		)}

}
