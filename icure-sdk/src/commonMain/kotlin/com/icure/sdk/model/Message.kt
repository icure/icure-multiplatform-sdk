package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.MessageAttachment
import com.icure.sdk.model.embed.MessageReadStatus
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Message : StoredDocument, ICureDocument<String>, Encryptable {
  override val id: String

  override val rev: String?

  override val created: Long?

  override val modified: Long?

  override val author: String?

  override val responsible: String?

  override val medicalLocationId: String?

  override val tags: Set<CodeStub>

  override val codes: Set<CodeStub>

  override val endOfLife: Long?

  override val deletionDate: Long?

  public val fromAddress: String?

  public val fromHealthcarePartyId: String?

  public val formId: String?

  public val status: Int?

  public val recipientsType: String?

  public val recipients: Set<String>

  public val toAddresses: Set<String>

  public val received: Long?

  public val sent: Long?

  public val metas: Map<String, String>

  public val readStatus: Map<String, MessageReadStatus>

  public val messageAttachments: List<MessageAttachment>

  public val transportGuid: String?

  public val remark: String?

  public val conversationGuid: String?

  public val subject: String?

  public val invoiceIds: Set<String>

  public val parentId: String?

  public val externalRef: String?

  public val unassignedResults: Set<String>

  public val assignedResults: Map<String, String>

  public val senderReferences: Map<String, String>

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
	// region Message-Message
	// endregion
}

data class DecryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	override val formId: String? = null,
	override val status: Int? = null,
	override val recipientsType: String? = null,
	override val recipients: Set<String> = emptySet(),
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	override val metas: Map<String, String> = emptyMap(),
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	override val messageAttachments: List<MessageAttachment> = emptyList(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
	override val externalRef: String? = null,
	override val unassignedResults: Set<String> = emptySet(),
	override val assignedResults: Map<String, String> = emptyMap(),
	override val senderReferences: Map<String, String> = emptyMap(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Message {
	// region Message-DecryptedMessage
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Message

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

data class EncryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	override val formId: String? = null,
	override val status: Int? = null,
	override val recipientsType: String? = null,
	override val recipients: Set<String> = emptySet(),
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	override val metas: Map<String, String> = emptyMap(),
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	override val messageAttachments: List<MessageAttachment> = emptyList(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
	override val externalRef: String? = null,
	override val unassignedResults: Set<String> = emptySet(),
	override val assignedResults: Map<String, String> = emptyMap(),
	override val senderReferences: Map<String, String> = emptyMap(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Message {
	// region Message-EncryptedMessage
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Message

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun Message.copy(
	id: String = this.id,
	rev: String? = this.rev,
	created: Long? = this.created,
	modified: Long? = this.modified,
	author: String? = this.author,
	responsible: String? = this.responsible,
	medicalLocationId: String? = this.medicalLocationId,
	tags: Set<CodeStub> = this.tags,
	codes: Set<CodeStub> = this.codes,
	endOfLife: Long? = this.endOfLife,
	deletionDate: Long? = this.deletionDate,
	fromAddress: String? = this.fromAddress,
	fromHealthcarePartyId: String? = this.fromHealthcarePartyId,
	formId: String? = this.formId,
	status: Int? = this.status,
	recipientsType: String? = this.recipientsType,
	recipients: Set<String> = this.recipients,
	toAddresses: Set<String> = this.toAddresses,
	received: Long? = this.received,
	sent: Long? = this.sent,
	metas: Map<String, String> = this.metas,
	readStatus: Map<String, MessageReadStatus> = this.readStatus,
	messageAttachments: List<MessageAttachment> = this.messageAttachments,
	transportGuid: String? = this.transportGuid,
	remark: String? = this.remark,
	conversationGuid: String? = this.conversationGuid,
	subject: String? = this.subject,
	invoiceIds: Set<String> = this.invoiceIds,
	parentId: String? = this.parentId,
	externalRef: String? = this.externalRef,
	unassignedResults: Set<String> = this.unassignedResults,
	assignedResults: Map<String, String> = this.assignedResults,
	senderReferences: Map<String, String> = this.senderReferences,
	secretForeignKeys: Set<String> = this.secretForeignKeys,
	cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
	delegations: Map<String, Set<Delegation>> = this.delegations,
	encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
	encryptedSelf: Base64String? = this.encryptedSelf,
	securityMetadata: SecurityMetadata? = this.securityMetadata,
): Message {
                                      return when(this) {
                                          is DecryptedMessage -> copy(id = id, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, fromAddress = fromAddress, fromHealthcarePartyId =
          fromHealthcarePartyId, formId = formId, status = status, recipientsType = recipientsType,
          recipients = recipients, toAddresses = toAddresses, received = received, sent = sent,
          metas = metas, readStatus = readStatus, messageAttachments = messageAttachments,
          transportGuid = transportGuid, remark = remark, conversationGuid = conversationGuid,
          subject = subject, invoiceIds = invoiceIds, parentId = parentId, externalRef =
          externalRef, unassignedResults = unassignedResults, assignedResults = assignedResults,
          senderReferences = senderReferences, secretForeignKeys = secretForeignKeys,
          cryptedForeignKeys = cryptedForeignKeys, delegations = delegations, encryptionKeys =
          encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedMessage -> copy(id = id, rev = rev, created = created, modified = modified, author
          = author, responsible = responsible, medicalLocationId = medicalLocationId, tags = tags,
          codes = codes, endOfLife = endOfLife, deletionDate = deletionDate, fromAddress =
          fromAddress, fromHealthcarePartyId = fromHealthcarePartyId, formId = formId, status =
          status, recipientsType = recipientsType, recipients = recipients, toAddresses =
          toAddresses, received = received, sent = sent, metas = metas, readStatus = readStatus,
          messageAttachments = messageAttachments, transportGuid = transportGuid, remark = remark,
          conversationGuid = conversationGuid, subject = subject, invoiceIds = invoiceIds, parentId
          = parentId, externalRef = externalRef, unassignedResults = unassignedResults,
          assignedResults = assignedResults, senderReferences = senderReferences, secretForeignKeys
          = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata)
                                          }

}