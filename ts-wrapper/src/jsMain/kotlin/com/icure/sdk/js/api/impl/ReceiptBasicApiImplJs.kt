// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.ReceiptBasicApi
import com.icure.sdk.js.api.ReceiptBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.receipt_fromJs
import com.icure.sdk.js.model.receipt_toJs
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ReceiptBasicApiImplJs(
	private val receiptBasicApi: ReceiptBasicApi,
) : ReceiptBasicApiJs {
	override fun deleteReceipt(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = receiptBasicApi.deleteReceipt(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteReceipts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = receiptBasicApi.deleteReceipts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray> =
			GlobalScope.promise {
		val receiptIdConverted: String = receiptId
		val attachmentIdConverted: String = attachmentId
		val result = receiptBasicApi.getRawReceiptAttachment(
			receiptIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		val receiptIdConverted: String = receiptId
		val revConverted: String = rev
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val result = receiptBasicApi.setRawReceiptAttachment(
			receiptIdConverted,
			revConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedReceipt = receipt_fromJs(entity)
		val result = receiptBasicApi.modifyReceipt(
			entityConverted,
		)
		receipt_toJs(result)
	}

	override fun getReceipt(entityId: String): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = receiptBasicApi.getReceipt(
			entityIdConverted,
		)
		receipt_toJs(result)
	}

	override fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>> =
			GlobalScope.promise {
		val referenceConverted: String = reference
		val result = receiptBasicApi.listByReference(
			referenceConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}
}
