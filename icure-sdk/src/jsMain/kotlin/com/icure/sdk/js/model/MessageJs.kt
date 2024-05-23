// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.js.model.base.ICureDocumentJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.EncryptableJs
import com.icure.sdk.js.model.embed.MessageAttachmentJs
import com.icure.sdk.js.model.embed.SecurityMetadataJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Message")
public sealed external interface MessageJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val fromAddress: String?

	public val fromHealthcarePartyId: String?

	public val formId: String?

	public val status: Double?

	public val recipientsType: String?

	public val recipients: Array<out String>

	public val toAddresses: Array<out String>

	public val received: Double?

	public val sent: Double?

	public val metas: dynamic

	public val readStatus: dynamic

	public val messageAttachments: Array<out MessageAttachmentJs>

	public val transportGuid: String?

	public val remark: String?

	public val conversationGuid: String?

	public val subject: String?

	public val invoiceIds: Array<out String>

	public val parentId: String?

	public val externalRef: String?

	public val unassignedResults: Array<out String>

	public val assignedResults: dynamic

	public val senderReferences: dynamic

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedMessage")
public external class DecryptedMessageJs(
	partial: dynamic,
) : MessageJs {
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

	override val fromAddress: String?

	override val fromHealthcarePartyId: String?

	override val formId: String?

	override val status: Double?

	override val recipientsType: String?

	override val recipients: Array<String>

	override val toAddresses: Array<String>

	override val received: Double?

	override val sent: Double?

	override val metas: dynamic

	override val readStatus: dynamic

	override val messageAttachments: Array<MessageAttachmentJs>

	override val transportGuid: String?

	override val remark: String?

	override val conversationGuid: String?

	override val subject: String?

	override val invoiceIds: Array<String>

	override val parentId: String?

	override val externalRef: String?

	override val unassignedResults: Array<String>

	override val assignedResults: dynamic

	override val senderReferences: dynamic

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedMessage")
public external class EncryptedMessageJs(
	partial: dynamic,
) : MessageJs {
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

	override val fromAddress: String?

	override val fromHealthcarePartyId: String?

	override val formId: String?

	override val status: Double?

	override val recipientsType: String?

	override val recipients: Array<String>

	override val toAddresses: Array<String>

	override val received: Double?

	override val sent: Double?

	override val metas: dynamic

	override val readStatus: dynamic

	override val messageAttachments: Array<MessageAttachmentJs>

	override val transportGuid: String?

	override val remark: String?

	override val conversationGuid: String?

	override val subject: String?

	override val invoiceIds: Array<String>

	override val parentId: String?

	override val externalRef: String?

	override val unassignedResults: Array<String>

	override val assignedResults: dynamic

	override val senderReferences: dynamic

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: dynamic

	override val delegations: dynamic

	override val encryptionKeys: dynamic

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean

	override val ktClass: String
}
