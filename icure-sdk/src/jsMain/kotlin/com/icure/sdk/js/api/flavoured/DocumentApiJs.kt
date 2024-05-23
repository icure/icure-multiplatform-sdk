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

	public fun deleteDocument(entityId: String): Promise<DocIdentifierJs>

	public fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getRawMainAttachment(documentId: String, attachmentId: String): Promise<ByteArray>

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

	public fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedDocumentJs>>
}
