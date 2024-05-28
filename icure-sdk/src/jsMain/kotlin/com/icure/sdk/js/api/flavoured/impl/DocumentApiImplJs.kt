// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.DocumentApi
import com.icure.sdk.js.api.flavoured.DocumentApiJs
import com.icure.sdk.js.api.flavoured.DocumentFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
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
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.OptIn
import kotlin.String
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
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedDocumentJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				documentApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.document_fromJs(document),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun findDocumentsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				documentApi.encrypted.findDocumentsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			document_toJs(documentApi.encrypted.modifyDocument(com.icure.sdk.js.model.document_fromJs(entity)))}


		override fun getDocument(entityId: String): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.encrypted.getDocument(entityId))}


		override fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			document_toJs(documentApi.encrypted.getDocumentByExternalUuid(externalUuid))}


		override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>
				= GlobalScope.promise {
			listToArray(
				documentApi.encrypted.getDocumentsByExternalUuid(externalUuid),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.encrypted.getDocuments(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun modifyDocuments(entities: Array<EncryptedDocumentJs>):
				Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
			listToArray(
				documentApi.encrypted.modifyDocuments(arrayToList(
					entities,
					"entities",
					{ x1: EncryptedDocumentJs ->
						document_fromJs(x1)
					},
				)),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun listDocumentsByHcPartyMessageForeignKeys(
			hcPartyId: String,
			documentTypeCode: String?,
			secretMessageKeys: Array<String>,
		): Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
			listToArray(
				documentApi.encrypted.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode,
						arrayToList(
					secretMessageKeys,
					"secretMessageKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun findWithoutDelegation(limit: Double?): Promise<Array<EncryptedDocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.encrypted.findWithoutDelegation(numberToInt(limit, "limit")),
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)}


		override fun setRawMainAttachment(
			documentId: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.encrypted.setRawMainAttachment(documentId, rev,
					com.icure.sdk.js.model.CheckedConverters.arrayToList(
			  utis,
			  "utis",
			  { x1: kotlin.String ->
			    x1
			  },
			), blobType, attachment, encrypted))}


		override fun setRawSecondaryAttachment(
			documentId: String,
			key: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.encrypted.setRawSecondaryAttachment(documentId, key, rev,
					com.icure.sdk.js.model.CheckedConverters.arrayToList(
			  utis,
			  "utis",
			  { x1: kotlin.String ->
			    x1
			  },
			), blobType, attachment, encrypted))}


		override fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			document_toJs(documentApi.encrypted.deleteMainAttachment(entityId, rev))}


		override fun deleteSecondaryAttachment(
			documentId: String,
			key: String,
			attachmentId: String,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.encrypted.deleteSecondaryAttachment(documentId, key, attachmentId))}

	}

	override val tryAndRecover: DocumentFlavouredApiJs<DocumentJs> = object :
			DocumentFlavouredApiJs<DocumentJs> {
		override fun shareWith(
			delegateId: String,
			document: DocumentJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<DocumentJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				documentApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.document_fromJs(document),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun findDocumentsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<DocumentJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				documentApi.tryAndRecover.findDocumentsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun modifyDocument(entity: DocumentJs): Promise<DocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.modifyDocument(com.icure.sdk.js.model.document_fromJs(entity)))}


		override fun getDocument(entityId: String): Promise<DocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.getDocument(entityId))}


		override fun getDocumentByExternalUuid(externalUuid: String): Promise<DocumentJs> =
				GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.getDocumentByExternalUuid(externalUuid))}


		override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.tryAndRecover.getDocumentsByExternalUuid(externalUuid),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun getDocuments(entityIds: Array<String>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.tryAndRecover.getDocuments(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun modifyDocuments(entities: Array<DocumentJs>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.tryAndRecover.modifyDocuments(arrayToList(
					entities,
					"entities",
					{ x1: DocumentJs ->
						document_fromJs(x1)
					},
				)),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun listDocumentsByHcPartyMessageForeignKeys(
			hcPartyId: String,
			documentTypeCode: String?,
			secretMessageKeys: Array<String>,
		): Promise<Array<DocumentJs>> = GlobalScope.promise {
			listToArray(
				documentApi.tryAndRecover.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode,
						arrayToList(
					secretMessageKeys,
					"secretMessageKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun findWithoutDelegation(limit: Double?): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			listToArray(
				documentApi.tryAndRecover.findWithoutDelegation(numberToInt(limit, "limit")),
				{ x1: Document ->
					document_toJs(x1)
				},
			)}


		override fun setRawMainAttachment(
			documentId: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.setRawMainAttachment(documentId, rev,
					com.icure.sdk.js.model.CheckedConverters.arrayToList(
			  utis,
			  "utis",
			  { x1: kotlin.String ->
			    x1
			  },
			), blobType, attachment, encrypted))}


		override fun setRawSecondaryAttachment(
			documentId: String,
			key: String,
			rev: String,
			utis: Array<String>,
			blobType: String,
			attachment: ByteArray,
			encrypted: Boolean,
		): Promise<EncryptedDocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.setRawSecondaryAttachment(documentId, key, rev,
					com.icure.sdk.js.model.CheckedConverters.arrayToList(
			  utis,
			  "utis",
			  { x1: kotlin.String ->
			    x1
			  },
			), blobType, attachment, encrypted))}


		override fun deleteMainAttachment(entityId: String, rev: String): Promise<DocumentJs> =
				GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.deleteMainAttachment(entityId, rev))}


		override fun deleteSecondaryAttachment(
			documentId: String,
			key: String,
			attachmentId: String,
		): Promise<DocumentJs> = GlobalScope.promise {
			document_toJs(documentApi.tryAndRecover.deleteSecondaryAttachment(documentId, key,
					attachmentId))}

	}

	override fun createDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentApi.createDocument(com.icure.sdk.js.model.document_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedDocumentJs?,
		message: MessageJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.document_fromJs(nonNull1)
		}, message?.let { nonNull1 ->
		  com.icure.sdk.js.model.message_fromJs(nonNull1)
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


	override fun getAndDecryptMainAttachment(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray> = GlobalScope.promise {
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0).await()
		}
		documentApi.getAndDecryptMainAttachment(document_fromJs(document), attachmentId,
				decryptedDocumentValidatorConverted)}


	override fun encryptAndSetMainAttachment(
		document: DocumentJs,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.encryptAndSetMainAttachment(com.icure.sdk.js.model.document_fromJs(document),
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  utis,
		  "utis",
		  { x1: kotlin.String ->
		    x1
		  },
		), attachment))}


	override fun getAndDecryptSecondaryAttachment(
		document: DocumentJs,
		key: String,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray> = GlobalScope.promise {
		val decryptedDocumentValidatorConverted: suspend (ByteArray) -> Boolean = { arg0 ->
			decryptedDocumentValidator(
				arg0).await()
		}
		documentApi.getAndDecryptSecondaryAttachment(document_fromJs(document), key, attachmentId,
				decryptedDocumentValidatorConverted)}


	override fun encryptAndSetSecondaryAttachment(
		document: DocumentJs,
		key: String,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.encryptAndSetSecondaryAttachment(com.icure.sdk.js.model.document_fromJs(document),
				key, com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  utis,
		  "utis",
		  { x1: kotlin.String ->
		    x1
		  },
		), attachment))}


	override fun deleteDocument(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(documentApi.deleteDocument(entityId))}


	override fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			documentApi.deleteDocuments(arrayToList(
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


	override fun getRawMainAttachment(documentId: String, attachmentId: String): Promise<ByteArray> =
			GlobalScope.promise {
		documentApi.getRawMainAttachment(documentId, attachmentId)}


	override fun getRawSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<ByteArray> = GlobalScope.promise {
		documentApi.getRawSecondaryAttachment(documentId, key, attachmentId)}


	override fun shareWith(
		delegateId: String,
		document: DecryptedDocumentJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedDocumentJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			documentApi.shareWith(delegateId, com.icure.sdk.js.model.document_fromJs(document),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedDocumentJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			documentApi.findDocumentsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun modifyDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentApi.modifyDocument(com.icure.sdk.js.model.document_fromJs(entity)))}


	override fun getDocument(entityId: String): Promise<DecryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.getDocument(entityId))}


	override fun getDocumentByExternalUuid(externalUuid: String): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentApi.getDocumentByExternalUuid(externalUuid))}


	override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<DecryptedDocumentJs>>
			= GlobalScope.promise {
		listToArray(
			documentApi.getDocumentsByExternalUuid(externalUuid),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun getDocuments(entityIds: Array<String>): Promise<Array<DecryptedDocumentJs>> =
			GlobalScope.promise {
		listToArray(
			documentApi.getDocuments(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun modifyDocuments(entities: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		listToArray(
			documentApi.modifyDocuments(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedDocumentJs ->
					document_fromJs(x1)
				},
			)),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		listToArray(
			documentApi.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode, arrayToList(
				secretMessageKeys,
				"secretMessageKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun findWithoutDelegation(limit: Double?): Promise<Array<DecryptedDocumentJs>> =
			GlobalScope.promise {
		listToArray(
			documentApi.findWithoutDelegation(numberToInt(limit, "limit")),
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.setRawMainAttachment(documentId, rev,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  utis,
		  "utis",
		  { x1: kotlin.String ->
		    x1
		  },
		), blobType, attachment, encrypted))}


	override fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.setRawSecondaryAttachment(documentId, key, rev,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  utis,
		  "utis",
		  { x1: kotlin.String ->
		    x1
		  },
		), blobType, attachment, encrypted))}


	override fun deleteMainAttachment(entityId: String, rev: String): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentApi.deleteMainAttachment(entityId, rev))}


	override fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<DecryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentApi.deleteSecondaryAttachment(documentId, key, attachmentId))}

}
