// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedDocumentJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentBasicApi")
public external interface DocumentBasicApiJs {
	public fun deleteDocument(entityId: String): Promise<DocIdentifierJs>

	public fun deleteDocuments(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

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

	public fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs>

	public fun getDocument(entityId: String): Promise<EncryptedDocumentJs>

	public fun getDocumentByExternalUuid(externalUuid: String): Promise<EncryptedDocumentJs>

	public fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<EncryptedDocumentJs>>

	public fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>>

	public fun modifyDocuments(entities: Array<EncryptedDocumentJs>):
			Promise<Array<EncryptedDocumentJs>>

	public fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<EncryptedDocumentJs>>

	public fun findWithoutDelegation(limit: Double?): Promise<Array<EncryptedDocumentJs>>
}
