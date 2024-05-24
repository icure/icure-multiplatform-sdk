// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.DocumentBasicApi
import com.icure.sdk.js.api.flavoured.DocumentBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
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
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentBasicApiImplJs(
	private val documentBasicApi: DocumentBasicApi,
) : DocumentBasicApiJs {
	override fun deleteDocument(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(documentBasicApi.deleteDocument(entityId))}


	override fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			documentBasicApi.deleteDocuments(arrayToList(
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
		documentBasicApi.getRawMainAttachment(documentId, attachmentId)}


	override fun getRawSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<ByteArray> = GlobalScope.promise {
		documentBasicApi.getRawSecondaryAttachment(documentId, key, attachmentId)}


	override fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentBasicApi.modifyDocument(com.icure.sdk.js.model.document_fromJs(entity)))}


	override fun getDocument(entityId: String): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentBasicApi.getDocument(entityId))}


	override fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentBasicApi.getDocumentByExternalUuid(externalUuid))}


	override fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>
			= GlobalScope.promise {
		listToArray(
			documentBasicApi.getDocumentsByExternalUuid(externalUuid),
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)}


	override fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>> =
			GlobalScope.promise {
		listToArray(
			documentBasicApi.getDocuments(arrayToList(
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
			documentBasicApi.modifyDocuments(arrayToList(
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
			documentBasicApi.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode,
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
			documentBasicApi.findWithoutDelegation(numberToInt(limit, "limit")),
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
		document_toJs(documentBasicApi.setRawMainAttachment(documentId, rev,
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
		document_toJs(documentBasicApi.setRawSecondaryAttachment(documentId, key, rev,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  utis,
		  "utis",
		  { x1: kotlin.String ->
		    x1
		  },
		), blobType, attachment, encrypted))}


	override fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		document_toJs(documentBasicApi.deleteMainAttachment(entityId, rev))}


	override fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		document_toJs(documentBasicApi.deleteSecondaryAttachment(documentId, key, attachmentId))}

}
