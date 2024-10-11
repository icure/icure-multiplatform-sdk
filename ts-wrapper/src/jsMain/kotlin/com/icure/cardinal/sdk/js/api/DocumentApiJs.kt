// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.DocumentShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedDocumentJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
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

@JsName("DocumentApi")
public external interface DocumentApiJs {
	public val encrypted: DocumentFlavouredApiJs<EncryptedDocumentJs>

	public val tryAndRecover: DocumentFlavouredApiJs<DocumentJs>

	public fun createDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs>

	public fun withEncryptionMetadata(
		base: DecryptedDocumentJs?,
		message: MessageJs?,
		options: dynamic,
	): Promise<DecryptedDocumentJs>

	public fun getAndTryDecryptMainAttachment(document: DocumentJs, options: dynamic):
			Promise<ByteArray?>

	public fun getAndTryDecryptMainAttachmentAsPlainText(document: DocumentJs, options: dynamic):
			Promise<String?>

	public fun getAndTryDecryptMainAttachmentAsJson(document: DocumentJs, options: dynamic):
			Promise<dynamic>

	public fun getAndDecryptMainAttachment(document: DocumentJs, options: dynamic): Promise<ByteArray>

	public fun encryptAndSetMainAttachment(
		document: DocumentJs,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs>

	public fun getAndDecryptSecondaryAttachment(
		document: DocumentJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray>

	public fun encryptAndSetSecondaryAttachment(
		document: DocumentJs,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs>

	public fun getEncryptionKeysOf(document: DocumentJs): Promise<Array<String>>

	public fun hasWriteAccess(document: DocumentJs): Promise<Boolean>

	public fun decryptPatientIdOf(document: DocumentJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: DocumentJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(document: EncryptedDocumentJs): Promise<DecryptedDocumentJs>

	public fun tryDecrypt(document: EncryptedDocumentJs): Promise<DocumentJs>

	public fun tryDecryptAttachment(
		document: DocumentJs,
		encryptedAttachment: ByteArray,
		options: dynamic,
	): Promise<ByteArray?>

	public fun matchDocumentsBy(filter: FilterOptionsJs<DocumentJs>): Promise<Array<String>>

	public fun matchDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>>

	@JsName("deleteDocumentUnsafe")
	public fun deleteDocument(entityId: String): Promise<DocIdentifierJs>

	@JsName("deleteDocumentsUnsafe")
	public fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteDocumentById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteDocumentsByIds(entityIds: Array<IdWithMandatoryRevJs>):
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

	public fun shareWith(
		delegateId: String,
		document: DecryptedDocumentJs,
		options: dynamic,
	): Promise<DecryptedDocumentJs>

	public fun shareWithMany(document: DecryptedDocumentJs,
			delegates: Record<String, DocumentShareOptionsJs>): Promise<DecryptedDocumentJs>

	public fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedDocumentJs>>

	public fun filterDocumentsBy(filter: FilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<DecryptedDocumentJs>>

	public fun filterDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<DecryptedDocumentJs>>

	public fun undeleteDocumentById(id: String, rev: String): Promise<DecryptedDocumentJs>

	public fun undeleteDocument(document: DocumentJs): Promise<DecryptedDocumentJs>

	public fun modifyDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs>

	public fun getDocument(entityId: String): Promise<DecryptedDocumentJs>

	public fun getDocumentByExternalUuid(externalUuid: String): Promise<DecryptedDocumentJs>

	public fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<DecryptedDocumentJs>>

	public fun getDocuments(entityIds: Array<String>): Promise<Array<DecryptedDocumentJs>>

	public fun modifyDocuments(entities: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>>

	public fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<DecryptedDocumentJs>>

	public fun findWithoutDelegation(limit: Double?): Promise<Array<DecryptedDocumentJs>>
}
