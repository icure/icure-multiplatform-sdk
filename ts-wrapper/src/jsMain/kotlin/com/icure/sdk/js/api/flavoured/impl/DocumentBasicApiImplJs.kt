// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.DocumentBasicApi
import com.icure.sdk.js.api.flavoured.DocumentBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.EncryptedDocumentJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.document_fromJs
import com.icure.sdk.js.model.document_toJs
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentBasicApiImplJs(
	private val documentBasicApi: DocumentBasicApi,
) : DocumentBasicApiJs {
	override fun deleteDocument(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentBasicApi.deleteDocument(
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
		val result = documentBasicApi.deleteDocuments(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawMainAttachment(documentId: String): Promise<ByteArray> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val result = documentBasicApi.getRawMainAttachment(
			documentIdConverted,
		)
		result
	}

	override fun getMainAttachmentAsPlainText(documentId: String): Promise<String> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val result = documentBasicApi.getMainAttachmentAsPlainText(
			documentIdConverted,
		)
		result
	}

	override fun getMainAttachmentAsJson(documentId: String): Promise<dynamic> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val result = documentBasicApi.getMainAttachmentAsJson(
			documentIdConverted,
		)
		jsonToDynamic(result)
	}

	override fun getRawSecondaryAttachment(documentId: String, key: String): Promise<ByteArray> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val result = documentBasicApi.getRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
		)
		result
	}

	override fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val revConverted: String = rev
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentBasicApi.setRawMainAttachment(
			documentIdConverted,
			revConverted,
			utisConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val revConverted: String = rev
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentBasicApi.setRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
			utisConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentBasicApi.deleteMainAttachment(
			entityIdConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val revConverted: String = rev
		val result = documentBasicApi.deleteSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedDocument = document_fromJs(entity)
		val result = documentBasicApi.modifyDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun getDocument(entityId: String): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentBasicApi.getDocument(
			entityIdConverted,
		)
		document_toJs(result)
	}

	override fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val externalUuidConverted: String = externalUuid
		val result = documentBasicApi.getDocumentByExternalUuid(
			externalUuidConverted,
		)
		document_toJs(result)
	}

	override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>
			= GlobalScope.promise {
		val externalUuidConverted: String = externalUuid
		val result = documentBasicApi.getDocumentsByExternalUuid(
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
		val result = documentBasicApi.getDocuments(
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
		val result = documentBasicApi.modifyDocuments(
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
		val result = documentBasicApi.listDocumentsByHcPartyMessageForeignKeys(
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
		val result = documentBasicApi.findWithoutDelegation(
			limitConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}
}
