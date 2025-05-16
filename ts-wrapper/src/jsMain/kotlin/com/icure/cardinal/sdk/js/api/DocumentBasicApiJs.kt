// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentBasicApi")
public external interface DocumentBasicApiJs {
	public fun matchDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>): Promise<Array<String>>

	public fun matchDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>>

	public fun filterDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>>

	public fun filterDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>>

	public fun deleteDocumentUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteDocumentsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteDocumentById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeDocumentById(id: String, rev: String): Promise<Unit>

	public fun deleteDocument(document: DocumentJs): Promise<DocIdentifierJs>

	public fun deleteDocuments(documents: Array<DocumentJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeDocument(document: DocumentJs): Promise<Unit>

	public fun getRawMainAttachment(documentId: String): Promise<ByteArray>

	public fun getMainAttachmentAsPlainText(documentId: String): Promise<String>

	public fun getMainAttachmentAsJson(documentId: String): Promise<dynamic>

	public fun getRawSecondaryAttachment(documentId: String, key: String): Promise<ByteArray>

	public fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs>

	public fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs>

	public fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs>

	public fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): Promise<EncryptedDocumentJs>

	public fun createDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs>

	public fun undeleteDocumentById(id: String, rev: String): Promise<EncryptedDocumentJs>

	public fun undeleteDocument(document: DocumentJs): Promise<EncryptedDocumentJs>

	public fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs>

	public fun getDocument(entityId: String): Promise<EncryptedDocumentJs?>

	public fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs>

	public fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>

	public fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>>

	public fun modifyDocuments(entities: Array<EncryptedDocumentJs>):
			Promise<Array<EncryptedDocumentJs>>

	public fun findWithoutDelegation(limit: Double?): Promise<Array<EncryptedDocumentJs>>
}
