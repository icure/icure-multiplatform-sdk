// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DocumentBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DocumentBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.document_fromJs
import com.icure.cardinal.sdk.js.model.document_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentBasicApiImplJs(
	private val documentBasicApi: DocumentBasicApi,
) : DocumentBasicApiJs {
	override fun matchDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
		val result = documentBasicApi.matchDocumentsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Document> =
				baseSortableFilterOptions_fromJs(filter)
		val result = documentBasicApi.matchDocumentsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
		val result = documentBasicApi.filterDocumentsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun filterDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Document> =
				baseSortableFilterOptions_fromJs(filter)
		val result = documentBasicApi.filterDocumentsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

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

	override fun deleteDocumentById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentBasicApi.deleteDocumentById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDocumentsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = documentBasicApi.deleteDocumentsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDocumentById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		documentBasicApi.purgeDocumentById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteDocument(document: DocumentJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentBasicApi.deleteDocument(
			documentConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDocuments(documents: Array<DocumentJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val documentsConverted: List<Document> = arrayToList(
			documents,
			"documents",
			{ x1: DocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.deleteDocuments(
			documentsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDocument(document: DocumentJs): Promise<Unit> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		documentBasicApi.purgeDocument(
			documentConverted,
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

	override fun undeleteDocumentById(id: String, rev: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = documentBasicApi.undeleteDocumentById(
			idConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun undeleteDocument(document: DocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentBasicApi.undeleteDocument(
			documentConverted,
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
