// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ReceiptApi
import com.icure.sdk.js.api.flavoured.ReceiptApiJs
import com.icure.sdk.js.api.flavoured.ReceiptFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DecryptedReceiptJs
import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.ReceiptJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.receipt_fromJs
import com.icure.sdk.js.model.receipt_toJs
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.Receipt
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
internal class ReceiptApiImplJs(
	private val receiptApi: ReceiptApi,
) : ReceiptApiJs {
	override val encrypted: ReceiptFlavouredApiJs<EncryptedReceiptJs> = object :
			ReceiptFlavouredApiJs<EncryptedReceiptJs> {
		override fun shareWith(
			delegateId: String,
			receipt: EncryptedReceiptJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedReceiptJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				receiptApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.receipt_fromJs(receipt),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)}


		override fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			receipt_toJs(receiptApi.encrypted.modifyReceipt(com.icure.sdk.js.model.receipt_fromJs(entity)))}


		override fun getReceipt(entityId: String): Promise<EncryptedReceiptJs> = GlobalScope.promise {
			receipt_toJs(receiptApi.encrypted.getReceipt(entityId))}


		override fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>> =
				GlobalScope.promise {
			listToArray(
				receiptApi.encrypted.listByReference(reference),
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: ReceiptFlavouredApiJs<ReceiptJs> = object :
			ReceiptFlavouredApiJs<ReceiptJs> {
		override fun shareWith(
			delegateId: String,
			receipt: ReceiptJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<ReceiptJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				receiptApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.receipt_fromJs(receipt),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)}


		override fun modifyReceipt(entity: ReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
			receipt_toJs(receiptApi.tryAndRecover.modifyReceipt(com.icure.sdk.js.model.receipt_fromJs(entity)))}


		override fun getReceipt(entityId: String): Promise<ReceiptJs> = GlobalScope.promise {
			receipt_toJs(receiptApi.tryAndRecover.getReceipt(entityId))}


		override fun listByReference(reference: String): Promise<Array<ReceiptJs>> = GlobalScope.promise {
			listToArray(
				receiptApi.tryAndRecover.listByReference(reference),
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)}

	}

	override fun createReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		receipt_toJs(receiptApi.createReceipt(com.icure.sdk.js.model.receipt_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedReceiptJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.receipt_fromJs(nonNull1)
		}, patient?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		receiptApi.getAndDecryptReceiptAttachment(receipt_fromJs(receipt), attachmentId)}


	override fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.encryptAndSetReceiptAttachment(com.icure.sdk.js.model.receipt_fromJs(receipt),
				blobType, attachment))}


	override fun deleteReceipt(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(receiptApi.deleteReceipt(entityId))}


	override fun deleteReceipts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			receiptApi.deleteReceipts(arrayToList(
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
		receiptApi.getRawReceiptAttachment(receiptId, attachmentId)}


	override fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.setRawReceiptAttachment(receiptId, rev, blobType, attachment))}


	override fun shareWith(
		delegateId: String,
		receipt: DecryptedReceiptJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedReceiptJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			receiptApi.shareWith(delegateId, com.icure.sdk.js.model.receipt_fromJs(receipt),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)}

}
