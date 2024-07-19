// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.DocumentApi
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.DocumentApiJs
import com.icure.sdk.js.api.flavoured.DocumentFlavouredApiJs
import com.icure.sdk.js.crypto.entities.DocumentShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.documentShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.DecryptedDocumentJs
import com.icure.sdk.js.model.DocumentJs
import com.icure.sdk.js.model.EncryptedDocumentJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.document_fromJs
import com.icure.sdk.js.model.document_toJs
import com.icure.sdk.js.model.message_fromJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentApiImplJs(
	private val documentApi: DocumentApi,
) : DocumentApiJs {
	override val encrypted: DocumentFlavouredApiJs<EncryptedDocumentJs> = object :
			DocumentFlavouredApiJs<EncryptedDocumentJs> {
		override fun shareWith(
			delegateId: String,
			document: EncryptedDocumentJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val documentConverted: EncryptedDocument = document_fromJs(document)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = documentApi.encrypted.shareWith(
					delegateIdConverted,
					documentConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(document: EncryptedDocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val documentConverted: EncryptedDocument = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.encrypted.tryShareWithMany(
				documentConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun shareWithMany(document: EncryptedDocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val documentConverted: EncryptedDocument = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.encrypted.shareWithMany(
				documentConverted,
				delegatesConverted,
			)
			document_toJs(result)
		}

		override fun findDocumentsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = documentApi.encrypted.findDocumentsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedDocument = document_fromJs(entity)
			val result = documentApi.encrypted.modifyDocument(
				entityConverted,
			)
			document_toJs(result)
		}

		override fun getDocument(entityId: String): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = documentApi.encrypted.getDocument(
				entityIdConverted,
			)
			document_toJs(result)
		}

		override fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val externalUuidConverted: String = externalUuid
			val result = documentApi.encrypted.getDocumentByExternalUuid(
				externalUuidConverted,
			)
			document_toJs(result)
		}

		override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>
				= GlobalScope.promise {
			val externalUuidConverted: String = externalUuid
			val result = documentApi.encrypted.getDocumentsByExternalUuid(
				externalUuidConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.encrypted.getDocuments(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun modifyDocuments(entities: Array<EncryptedDocumentJs>):
				Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedDocument> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.encrypted.modifyDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun listDocumentsByHcPartyMessageForeignKeys(
			hcPartyId: String,
			documentTypeCode: String?,
			secretMessageKeys: Array<String>,
		): Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val documentTypeCodeConverted: String? = undefinedToNull(documentTypeCode)
			val secretMessageKeysConverted: List<String> = arrayToList(
				secretMessageKeys,
				"secretMessageKeys",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.encrypted.listDocumentsByHcPartyMessageForeignKeys(
				hcPartyIdConverted,
				documentTypeCodeConverted,
				secretMessageKeysConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun findWithoutDelegation(limit: Double?): Promise<Array<EncryptedDocumentJs>> =
				GlobalScope.promise {
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = documentApi.encrypted.findWithoutDelegation(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun setRawMainAttachment(
			documentId: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val revConverted: String = rev
			val utisConverted: List<String> = arrayToList(
				utis,
				"utis",
				{ x1: String ->
					x1
				},
			)
			val blobTypeConverted: String = blobType
			val attachmentConverted: ByteArray = attachment
			val encryptedConverted: Boolean = encrypted
			val result = documentApi.encrypted.setRawMainAttachment(
				documentIdConverted,
				revConverted,
				utisConverted,
				blobTypeConverted,
				attachmentConverted,
				encryptedConverted,
			)
			document_toJs(result)
		}

		override fun setRawSecondaryAttachment(
			documentId: String,
			key: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val keyConverted: String = key
			val revConverted: String = rev
			val utisConverted: List<String> = arrayToList(
				utis,
				"utis",
				{ x1: String ->
					x1
				},
			)
			val blobTypeConverted: String = blobType
			val attachmentConverted: ByteArray = attachment
			val encryptedConverted: Boolean = encrypted
			val result = documentApi.encrypted.setRawSecondaryAttachment(
				documentIdConverted,
				keyConverted,
				revConverted,
				utisConverted,
				blobTypeConverted,
				attachmentConverted,
				encryptedConverted,
			)
			document_toJs(result)
		}

		override fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val revConverted: String = rev
			val result = documentApi.encrypted.deleteMainAttachment(
				entityIdConverted,
				revConverted,
			)
			document_toJs(result)
		}

		override fun deleteSecondaryAttachment(
			documentId: String,
			key: String,
			attachmentId: String,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val keyConverted: String = key
			val attachmentIdConverted: String = attachmentId
			val result = documentApi.encrypted.deleteSecondaryAttachment(
				documentIdConverted,
				keyConverted,
				attachmentIdConverted,
			)
			document_toJs(result)
		}
	}

	override val tryAndRecover: DocumentFlavouredApiJs<DocumentJs> = object :
			DocumentFlavouredApiJs<DocumentJs> {
		override fun shareWith(
			delegateId: String,
			document: DocumentJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<DocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val documentConverted: Document = document_fromJs(document)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = documentApi.tryAndRecover.shareWith(
					delegateIdConverted,
					documentConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(document: DocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>): Promise<SimpleShareResultJs<DocumentJs>> =
				GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.tryShareWithMany(
				documentConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun shareWithMany(document: DocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>): Promise<DocumentJs> = GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.shareWithMany(
				documentConverted,
				delegatesConverted,
			)
			document_toJs(result)
		}

		override fun findDocumentsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<DocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = documentApi.tryAndRecover.findDocumentsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun modifyDocument(entity: DocumentJs): Promise<DocumentJs> = GlobalScope.promise {
			val entityConverted: Document = document_fromJs(entity)
			val result = documentApi.tryAndRecover.modifyDocument(
				entityConverted,
			)
			document_toJs(result)
		}

		override fun getDocument(entityId: String): Promise<DocumentJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = documentApi.tryAndRecover.getDocument(
				entityIdConverted,
			)
			document_toJs(result)
		}

		override fun getDocumentByExternalUuid(externalUuid: String): Promise<DocumentJs> =
				GlobalScope.promise {
			val externalUuidConverted: String = externalUuid
			val result = documentApi.tryAndRecover.getDocumentByExternalUuid(
				externalUuidConverted,
			)
			document_toJs(result)
		}

		override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val externalUuidConverted: String = externalUuid
			val result = documentApi.tryAndRecover.getDocumentsByExternalUuid(
				externalUuidConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun getDocuments(entityIds: Array<String>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.tryAndRecover.getDocuments(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun modifyDocuments(entities: Array<DocumentJs>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Document> = arrayToList(
				entities,
				"entities",
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.modifyDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun listDocumentsByHcPartyMessageForeignKeys(
			hcPartyId: String,
			documentTypeCode: String?,
			secretMessageKeys: Array<String>,
		): Promise<Array<DocumentJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val documentTypeCodeConverted: String? = undefinedToNull(documentTypeCode)
			val secretMessageKeysConverted: List<String> = arrayToList(
				secretMessageKeys,
				"secretMessageKeys",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.tryAndRecover.listDocumentsByHcPartyMessageForeignKeys(
				hcPartyIdConverted,
				documentTypeCodeConverted,
				secretMessageKeysConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun findWithoutDelegation(limit: Double?): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = documentApi.tryAndRecover.findWithoutDelegation(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun setRawMainAttachment(
			documentId: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val revConverted: String = rev
			val utisConverted: List<String> = arrayToList(
				utis,
				"utis",
				{ x1: String ->
					x1
				},
			)
			val blobTypeConverted: String = blobType
			val attachmentConverted: ByteArray = attachment
			val encryptedConverted: Boolean = encrypted
			val result = documentApi.tryAndRecover.setRawMainAttachment(
				documentIdConverted,
				revConverted,
				utisConverted,
				blobTypeConverted,
				attachmentConverted,
				encryptedConverted,
			)
			document_toJs(result)
		}

		override fun setRawSecondaryAttachment(
			documentId: String,
			key: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val keyConverted: String = key
			val revConverted: String = rev
			val utisConverted: List<String> = arrayToList(
				utis,
				"utis",
				{ x1: String ->
					x1
				},
			)
			val blobTypeConverted: String = blobType
			val attachmentConverted: ByteArray = attachment
			val encryptedConverted: Boolean = encrypted
			val result = documentApi.tryAndRecover.setRawSecondaryAttachment(
				documentIdConverted,
				keyConverted,
				revConverted,
				utisConverted,
				blobTypeConverted,
				attachmentConverted,
				encryptedConverted,
			)
			document_toJs(result)
		}

		override fun deleteMainAttachment(entityId: String, rev: String): Promise<DocumentJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val revConverted: String = rev
			val result = documentApi.tryAndRecover.deleteMainAttachment(
				entityIdConverted,
				revConverted,
			)
			document_toJs(result)
		}

		override fun deleteSecondaryAttachment(
			documentId: String,
			key: String,
			attachmentId: String,
		): Promise<DocumentJs> = GlobalScope.promise {
			val documentIdConverted: String = documentId
			val keyConverted: String = key
			val attachmentIdConverted: String = attachmentId
			val result = documentApi.tryAndRecover.deleteSecondaryAttachment(
				documentIdConverted,
				keyConverted,
				attachmentIdConverted,
			)
			document_toJs(result)
		}
	}

	override fun createDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedDocument = document_fromJs(entity)
		val result = documentApi.createDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedDocumentJs?,
		message: MessageJs?,
		options: dynamic,
	): Promise<DecryptedDocumentJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
				document_fromJs(nonNull1)
			}
			val messageConverted: Message? = message?.let { nonNull1 ->
				message_fromJs(nonNull1)
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
			val secretIdConverted: SecretIdOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId: SecretIdOptionJs ->
				secretIdOption_fromJs(secretId)
			}
			val result = documentApi.withEncryptionMetadata(
				baseConverted,
				messageConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			document_toJs(result)
		}
	}

	override fun getAndTryDecryptMainAttachment(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray?> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val attachmentIdConverted: String = attachmentId
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0,
			).await()
		}
		val result = documentApi.getAndTryDecryptMainAttachment(
			documentConverted,
			attachmentIdConverted,
			decryptedDocumentValidatorConverted,
		)
		nullToUndefined(
			result
		)
	}

	override fun getAndTryDecryptMainAttachmentAsPlainText(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<String?> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val attachmentIdConverted: String = attachmentId
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0,
			).await()
		}
		val result = documentApi.getAndTryDecryptMainAttachmentAsPlainText(
			documentConverted,
			attachmentIdConverted,
			decryptedDocumentValidatorConverted,
		)
		nullToUndefined(
			result
		)
	}

	override fun getAndTryDecryptMainAttachmentAsJson(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<dynamic> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val attachmentIdConverted: String = attachmentId
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0,
			).await()
		}
		val result = documentApi.getAndTryDecryptMainAttachmentAsJson(
			documentConverted,
			attachmentIdConverted,
			decryptedDocumentValidatorConverted,
		)
		nullToUndefined(
			jsonToDynamic(result)
		)
	}

	override fun getAndDecryptMainAttachment(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val attachmentIdConverted: String = attachmentId
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0,
			).await()
		}
		val result = documentApi.getAndDecryptMainAttachment(
			documentConverted,
			attachmentIdConverted,
			decryptedDocumentValidatorConverted,
		)
		result
	}

	override fun encryptAndSetMainAttachment(
		document: DocumentJs,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val utisConverted: List<String> = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = documentApi.encryptAndSetMainAttachment(
			documentConverted,
			utisConverted,
			attachmentConverted,
		)
		document_toJs(result)
	}

	override fun getAndDecryptSecondaryAttachment(
		document: DocumentJs,
		key: String,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val keyConverted: String = key
		val attachmentIdConverted: String = attachmentId
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0,
			).await()
		}
		val result = documentApi.getAndDecryptSecondaryAttachment(
			documentConverted,
			keyConverted,
			attachmentIdConverted,
			decryptedDocumentValidatorConverted,
		)
		result
	}

	override fun encryptAndSetSecondaryAttachment(
		document: DocumentJs,
		key: String,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val keyConverted: String = key
		val utisConverted: List<String> = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = documentApi.encryptAndSetSecondaryAttachment(
			documentConverted,
			keyConverted,
			utisConverted,
			attachmentConverted,
		)
		document_toJs(result)
	}

	override fun getEncryptionKeysOf(document: DocumentJs): Promise<Array<String>> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.getEncryptionKeysOf(
			documentConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(document: DocumentJs): Promise<Boolean> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.hasWriteAccess(
			documentConverted,
		)
		result
	}

	override fun decryptPatientIdOf(document: DocumentJs): Promise<Array<String>> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.decryptPatientIdOf(
			documentConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: DocumentJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Document = document_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		documentApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteDocument(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentApi.deleteDocument(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = documentApi.deleteDocuments(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawMainAttachment(documentId: String, attachmentId: String): Promise<ByteArray> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val attachmentIdConverted: String = attachmentId
		val result = documentApi.getRawMainAttachment(
			documentIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun getMainAttachmentAsPlainText(documentId: String, attachmentId: String):
			Promise<String> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val attachmentIdConverted: String = attachmentId
		val result = documentApi.getMainAttachmentAsPlainText(
			documentIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun getMainAttachmentAsJson(documentId: String, attachmentId: String): Promise<dynamic> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val attachmentIdConverted: String = attachmentId
		val result = documentApi.getMainAttachmentAsJson(
			documentIdConverted,
			attachmentIdConverted,
		)
		jsonToDynamic(result)
	}

	override fun getRawSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<ByteArray> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val attachmentIdConverted: String = attachmentId
		val result = documentApi.getRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun shareWith(
		delegateId: String,
		document: DecryptedDocumentJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedDocumentJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val documentConverted: DecryptedDocument = document_fromJs(document)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareEncryptionKeys",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys: String ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareOwningEntityIds",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds: String ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
				_options,
				"requestedPermission",
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission: String ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = documentApi.shareWith(
				delegateIdConverted,
				documentConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(document: DecryptedDocumentJs,
			delegates: Record<String, DocumentShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedDocumentJs>> = GlobalScope.promise {
		val documentConverted: DecryptedDocument = document_fromJs(document)
		val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: DocumentShareOptionsJs ->
				documentShareOptions_fromJs(x1)
			},
		)
		val result = documentApi.tryShareWithMany(
			documentConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun shareWithMany(document: DecryptedDocumentJs,
			delegates: Record<String, DocumentShareOptionsJs>): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: DecryptedDocument = document_fromJs(document)
		val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: DocumentShareOptionsJs ->
				documentShareOptions_fromJs(x1)
			},
		)
		val result = documentApi.shareWithMany(
			documentConverted,
			delegatesConverted,
		)
		document_toJs(result)
	}

	override fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedDocumentJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = documentApi.findDocumentsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}
	}

	override fun modifyDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedDocument = document_fromJs(entity)
		val result = documentApi.modifyDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun getDocument(entityId: String): Promise<DecryptedDocumentJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentApi.getDocument(
			entityIdConverted,
		)
		document_toJs(result)
	}

	override fun getDocumentByExternalUuid(externalUuid: String): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val externalUuidConverted: String = externalUuid
		val result = documentApi.getDocumentByExternalUuid(
			externalUuidConverted,
		)
		document_toJs(result)
	}

	override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<DecryptedDocumentJs>>
			= GlobalScope.promise {
		val externalUuidConverted: String = externalUuid
		val result = documentApi.getDocumentsByExternalUuid(
			externalUuidConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun getDocuments(entityIds: Array<String>): Promise<Array<DecryptedDocumentJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = documentApi.getDocuments(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun modifyDocuments(entities: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedDocument> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentApi.modifyDocuments(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val documentTypeCodeConverted: String? = undefinedToNull(documentTypeCode)
		val secretMessageKeysConverted: List<String> = arrayToList(
			secretMessageKeys,
			"secretMessageKeys",
			{ x1: String ->
				x1
			},
		)
		val result = documentApi.listDocumentsByHcPartyMessageForeignKeys(
			hcPartyIdConverted,
			documentTypeCodeConverted,
			secretMessageKeysConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun findWithoutDelegation(limit: Double?): Promise<Array<DecryptedDocumentJs>> =
			GlobalScope.promise {
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = documentApi.findWithoutDelegation(
			limitConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val revConverted: String = rev
		val utisConverted: List<String> = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentApi.setRawMainAttachment(
			documentIdConverted,
			revConverted,
			utisConverted,
			blobTypeConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val revConverted: String = rev
		val utisConverted: List<String> = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentApi.setRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
			utisConverted,
			blobTypeConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun deleteMainAttachment(entityId: String, rev: String): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentApi.deleteMainAttachment(
			entityIdConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<DecryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val attachmentIdConverted: String = attachmentId
		val result = documentApi.deleteSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			attachmentIdConverted,
		)
		document_toJs(result)
	}
}
