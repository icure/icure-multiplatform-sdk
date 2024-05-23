// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.DeletedAttachmentJs
import com.icure.sdk.js.model.embed.EncryptableJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Document")
public sealed external interface DocumentJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val documentLocation: String?

	public val documentType: String?

	public val documentStatus: String?

	public val externalUri: String?

	public val name: String?

	public val version: String?

	public val storedICureDocumentId: String?

	public val externalUuid: String?

	public val size: Double?

	public val hash: String?

	public val openingContactId: String?

	public val attachmentId: String?

	public val objectStoreReference: String?

	public val mainUti: String?

	public val otherUtis: Array<out String>

	public val secondaryAttachments: dynamic

	public val deletedAttachments: Array<out DeletedAttachmentJs>

	public val encryptedAttachment: ByteArray?

	public val decryptedAttachment: ByteArray?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedDocument")
public external class DecryptedDocumentJs(
	partial: dynamic,
) : DocumentJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val documentLocation: String?

	override val documentType: String?

	override val documentStatus: String?

	override val externalUri: String?

	override val name: String?

	override val version: String?

	override val storedICureDocumentId: String?

	override val externalUuid: String?

	override val size: Double?

	override val hash: String?

	override val openingContactId: String?

	override val attachmentId: String?

	override val objectStoreReference: String?

	override val mainUti: String?

	override val otherUtis: Array<String>

	override val secondaryAttachments: dynamic

	override val deletedAttachments: Array<DeletedAttachmentJs>

	override val encryptedAttachment: ByteArray?

	override val decryptedAttachment: ByteArray?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedDocument")
public external class EncryptedDocumentJs(
	partial: dynamic,
) : DocumentJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val documentLocation: String?

	override val documentType: String?

	override val documentStatus: String?

	override val externalUri: String?

	override val name: String?

	override val version: String?

	override val storedICureDocumentId: String?

	override val externalUuid: String?

	override val size: Double?

	override val hash: String?

	override val openingContactId: String?

	override val attachmentId: String?

	override val objectStoreReference: String?

	override val mainUti: String?

	override val otherUtis: Array<String>

	override val secondaryAttachments: dynamic

	override val deletedAttachments: Array<DeletedAttachmentJs>

	override val encryptedAttachment: ByteArray?

	override val decryptedAttachment: ByteArray?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}
