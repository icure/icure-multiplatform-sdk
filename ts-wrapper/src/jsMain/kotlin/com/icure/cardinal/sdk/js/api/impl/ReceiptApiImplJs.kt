// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.ReceiptApiJs
import com.icure.cardinal.sdk.js.api.ReceiptFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.crypto.entities.receiptShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.DecryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.receipt_fromJs
import com.icure.cardinal.sdk.js.model.receipt_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
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
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedReceiptJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
				val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ReceiptShareOptionsJs? ->
					options?.let { nonNull1 ->
						receiptShareOptions_fromJs(nonNull1)
					}
				}
				val result = receiptApi.encrypted.shareWith(
					delegateIdConverted,
					receiptConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(receipt: EncryptedReceiptJs,
				delegates: Record<String, ReceiptShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedReceiptJs>> = GlobalScope.promise {
			val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.tryShareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun shareWithMany(receipt: EncryptedReceiptJs,
				delegates: Record<String, ReceiptShareOptionsJs>): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.shareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			receipt_toJs(result)
		}

		override fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedReceipt = receipt_fromJs(entity)
			val result = receiptApi.encrypted.modifyReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun getReceipt(entityId: String): Promise<EncryptedReceiptJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = receiptApi.encrypted.getReceipt(
				entityIdConverted,
			)
			receipt_toJs(result)
		}

		override fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>> =
				GlobalScope.promise {
			val referenceConverted: String = reference
			val result = receiptApi.encrypted.listByReference(
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

	override val tryAndRecover: ReceiptFlavouredApiJs<ReceiptJs> = object :
			ReceiptFlavouredApiJs<ReceiptJs> {
		override fun shareWith(
			delegateId: String,
			receipt: ReceiptJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<ReceiptJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val receiptConverted: Receipt = receipt_fromJs(receipt)
				val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ReceiptShareOptionsJs? ->
					options?.let { nonNull1 ->
						receiptShareOptions_fromJs(nonNull1)
					}
				}
				val result = receiptApi.tryAndRecover.shareWith(
					delegateIdConverted,
					receiptConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(receipt: ReceiptJs,
				delegates: Record<String, ReceiptShareOptionsJs>): Promise<SimpleShareResultJs<ReceiptJs>> =
				GlobalScope.promise {
			val receiptConverted: Receipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.tryShareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun shareWithMany(receipt: ReceiptJs, delegates: Record<String, ReceiptShareOptionsJs>):
				Promise<ReceiptJs> = GlobalScope.promise {
			val receiptConverted: Receipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.shareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			receipt_toJs(result)
		}

		override fun modifyReceipt(entity: ReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
			val entityConverted: Receipt = receipt_fromJs(entity)
			val result = receiptApi.tryAndRecover.modifyReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun getReceipt(entityId: String): Promise<ReceiptJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = receiptApi.tryAndRecover.getReceipt(
				entityIdConverted,
			)
			receipt_toJs(result)
		}

		override fun listByReference(reference: String): Promise<Array<ReceiptJs>> = GlobalScope.promise {
			val referenceConverted: String = reference
			val result = receiptApi.tryAndRecover.listByReference(
				referenceConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}
	}

	override fun createReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedReceipt = receipt_fromJs(entity)
		val result = receiptApi.createReceipt(
			entityConverted,
		)
		receipt_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedReceiptJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedReceiptJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedReceipt? = base?.let { nonNull1 ->
				receipt_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val result = receiptApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			receipt_toJs(result)
		}
	}

	override fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val attachmentIdConverted: String = attachmentId
		val result = receiptApi.getAndDecryptReceiptAttachment(
			receiptConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val result = receiptApi.encryptAndSetReceiptAttachment(
			receiptConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun getEncryptionKeysOf(receipt: ReceiptJs): Promise<Array<String>> =
			GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.getEncryptionKeysOf(
			receiptConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(receipt: ReceiptJs): Promise<Boolean> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.hasWriteAccess(
			receiptConverted,
		)
		result
	}

	override fun decryptPatientIdOf(receipt: ReceiptJs): Promise<Array<String>> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.decryptPatientIdOf(
			receiptConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ReceiptJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Receipt = receipt_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		receiptApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun logReceipt(
		user: UserJs,
		docId: String,
		refs: Array<String>,
		blobType: String,
		blob: ByteArray,
	): Promise<ReceiptJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val docIdConverted: String = docId
		val refsConverted: List<String> = arrayToList(
			refs,
			"refs",
			{ x1: String ->
				x1
			},
		)
		val blobTypeConverted: String = blobType
		val blobConverted: ByteArray = blob
		val result = receiptApi.logReceipt(
			userConverted,
			docIdConverted,
			refsConverted,
			blobTypeConverted,
			blobConverted,
		)
		receipt_toJs(result)
	}

	override fun decrypt(receipt: EncryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
		val result = receiptApi.decrypt(
			receiptConverted,
		)
		receipt_toJs(result)
	}

	override fun tryDecrypt(receipt: EncryptedReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
		val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
		val result = receiptApi.tryDecrypt(
			receiptConverted,
		)
		receipt_toJs(result)
	}

	override fun deleteReceipt(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = receiptApi.deleteReceipt(
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
		val result = receiptApi.deleteReceipts(
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
		val result = receiptApi.getRawReceiptAttachment(
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
		val result = receiptApi.setRawReceiptAttachment(
			receiptIdConverted,
			revConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun shareWith(
		delegateId: String,
		receipt: DecryptedReceiptJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedReceiptJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val receiptConverted: DecryptedReceipt = receipt_fromJs(receipt)
			val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: ReceiptShareOptionsJs? ->
				options?.let { nonNull1 ->
					receiptShareOptions_fromJs(nonNull1)
				}
			}
			val result = receiptApi.shareWith(
				delegateIdConverted,
				receiptConverted,
				optionsConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedReceiptJs>> = GlobalScope.promise {
		val receiptConverted: DecryptedReceipt = receipt_fromJs(receipt)
		val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ReceiptShareOptionsJs ->
				receiptShareOptions_fromJs(x1)
			},
		)
		val result = receiptApi.tryShareWithMany(
			receiptConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun shareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val receiptConverted: DecryptedReceipt = receipt_fromJs(receipt)
		val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ReceiptShareOptionsJs ->
				receiptShareOptions_fromJs(x1)
			},
		)
		val result = receiptApi.shareWithMany(
			receiptConverted,
			delegatesConverted,
		)
		receipt_toJs(result)
	}

	override fun modifyReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedReceipt = receipt_fromJs(entity)
		val result = receiptApi.modifyReceipt(
			entityConverted,
		)
		receipt_toJs(result)
	}

	override fun getReceipt(entityId: String): Promise<DecryptedReceiptJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = receiptApi.getReceipt(
			entityIdConverted,
		)
		receipt_toJs(result)
	}

	override fun listByReference(reference: String): Promise<Array<DecryptedReceiptJs>> =
			GlobalScope.promise {
		val referenceConverted: String = reference
		val result = receiptApi.listByReference(
			referenceConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}
}
