// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedDocumentJs
import com.icure.sdk.js.model.DocumentJs
import com.icure.sdk.js.model.EncryptedDocumentJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
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
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedDocumentJs>

	public fun getAndTryDecryptMainAttachment(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray?>

	public fun getAndTryDecryptMainAttachmentAsPlainText(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<String?>

	public fun getAndTryDecryptMainAttachmentAsJson(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<dynamic>

	public fun getAndDecryptMainAttachment(
		document: DocumentJs,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray>

	public fun encryptAndSetMainAttachment(
		document: DocumentJs,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs>

	public fun getAndDecryptSecondaryAttachment(
		document: DocumentJs,
		key: String,
		attachmentId: String,
		decryptedDocumentValidator: (ByteArray) -> Promise<Boolean>,
	): Promise<ByteArray>

	public fun encryptAndSetSecondaryAttachment(
		document: DocumentJs,
		key: String,
		utis: Array<String>,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs>

	public fun getEncryptionKeysOf(document: DocumentJs): Promise<Array<String>>

	public fun hasWriteAccess(document: DocumentJs): Promise<Boolean>

	public fun decryptPatientIdOf(document: DocumentJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: DocumentJs, delegates: Array<String>):
			Promise<Unit>

	public fun deleteDocument(entityId: String): Promise<DocIdentifierJs>

	public fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getRawMainAttachment(documentId: String, attachmentId: String): Promise<ByteArray>

	public fun getMainAttachmentAsPlainText(documentId: String, attachmentId: String): Promise<String>

	public fun getMainAttachmentAsJson(documentId: String, attachmentId: String): Promise<dynamic>

	public fun getRawSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<ByteArray>

	public fun shareWith(
		delegateId: String,
		document: DecryptedDocumentJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedDocumentJs>>

	public fun tryShareWithMany(document: DecryptedDocumentJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedDocumentJs>>

	public fun shareWithMany(document: DecryptedDocumentJs, delegates: dynamic):
			Promise<DecryptedDocumentJs>

	public fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedDocumentJs>>

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

	public fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs>

	public fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs>

	public fun deleteMainAttachment(entityId: String, rev: String): Promise<DecryptedDocumentJs>

	public fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<DecryptedDocumentJs>
}
