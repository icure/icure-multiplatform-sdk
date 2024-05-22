// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DocumentJs
import com.icure.sdk.js.model.EncryptedDocumentJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentFlavouredApi")
public external interface DocumentFlavouredApiJs<E : DocumentJs> {
	public fun shareWith(
		delegateId: String,
		document: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyDocument(entity: E): Promise<E>

	public fun getDocument(entityId: String): Promise<E>

	public fun getDocumentByExternalUuid(externalUuid: String): Promise<E>

	public fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<E>>

	public fun getDocuments(entityIds: Array<String>): Promise<Array<E>>

	public fun modifyDocuments(entities: Array<E>): Promise<Array<E>>

	public fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<E>>

	public fun findWithoutDelegation(limit: Double?): Promise<Array<E>>

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

	public fun deleteMainAttachment(entityId: String, rev: String): Promise<E>

	public fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		attachmentId: String,
	): Promise<E>
}
