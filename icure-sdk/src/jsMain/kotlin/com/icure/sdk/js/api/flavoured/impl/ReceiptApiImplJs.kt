// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ReceiptApi
import com.icure.sdk.js.api.flavoured.ReceiptApiJs
import com.icure.sdk.js.api.flavoured.ReceiptFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedReceiptJs
import com.icure.sdk.js.model.EncryptedReceiptJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.ReceiptJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.receipt_fromJs
import com.icure.sdk.js.model.receipt_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.Receipt
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)}


		override fun tryShareWithMany(receipt: EncryptedReceiptJs, delegates: dynamic):
				Promise<SimpleShareResultJs<EncryptedReceiptJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				receiptApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)}


		override fun shareWithMany(receipt: EncryptedReceiptJs, delegates: dynamic):
				Promise<EncryptedReceiptJs> = GlobalScope.promise {
			receipt_toJs(receiptApi.encrypted.shareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
			  },
			)))}


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
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)}


		override fun tryShareWithMany(receipt: ReceiptJs, delegates: dynamic):
				Promise<SimpleShareResultJs<ReceiptJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				receiptApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
				  },
				)),
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)}


		override fun shareWithMany(receipt: ReceiptJs, delegates: dynamic): Promise<ReceiptJs> =
				GlobalScope.promise {
			receipt_toJs(receiptApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
			  },
			)))}


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
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
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


	override fun getEncryptionKeysOf(receipt: ReceiptJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			receiptApi.getEncryptionKeysOf(receipt_fromJs(receipt)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(receipt: ReceiptJs): Promise<Boolean> = GlobalScope.promise {
		receiptApi.hasWriteAccess(receipt_fromJs(receipt))}


	override fun decryptPatientIdOf(receipt: ReceiptJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			receiptApi.decryptPatientIdOf(receipt_fromJs(receipt)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: ReceiptJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		receiptApi.createDelegationDeAnonymizationMetadata(receipt_fromJs(entity), arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun logReceipt(
		user: UserJs,
		docId: String,
		refs: Array<String>,
		blobType: String,
		blob: ByteArray,
	): Promise<ReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.logReceipt(com.icure.sdk.js.model.user_fromJs(user), docId,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  refs,
		  "refs",
		  { x1: kotlin.String ->
		    x1
		  },
		), blobType, blob))}


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
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)}


	override fun tryShareWithMany(receipt: DecryptedReceiptJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedReceiptJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			receiptApi.tryShareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)}


	override fun shareWithMany(receipt: DecryptedReceiptJs, delegates: dynamic):
			Promise<DecryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.shareWithMany(com.icure.sdk.js.model.receipt_fromJs(receipt),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.ReceiptShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.receiptShareOptions_fromJs(x1)
		  },
		)))}


	override fun modifyReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		receipt_toJs(receiptApi.modifyReceipt(com.icure.sdk.js.model.receipt_fromJs(entity)))}


	override fun getReceipt(entityId: String): Promise<DecryptedReceiptJs> = GlobalScope.promise {
		receipt_toJs(receiptApi.getReceipt(entityId))}


	override fun listByReference(reference: String): Promise<Array<DecryptedReceiptJs>> =
			GlobalScope.promise {
		listToArray(
			receiptApi.listByReference(reference),
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)}

}
