package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DataAttachment
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.DeletedAttachment
import com.icure.sdk.model.embed.DocumentLocation
import com.icure.sdk.model.embed.DocumentStatus
import com.icure.sdk.model.embed.DocumentType
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Document : StoredDocument, ICureDocument<String>, Encryptable {
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

  public val documentLocation: DocumentLocation?

  public val documentType: DocumentType?

  public val documentStatus: DocumentStatus?

  public val externalUri: String?

  public val name: String?

  public val version: String?

  public val storedICureDocumentId: String?

  public val externalUuid: String?

  public val size: Long?

  public val hash: String?

  public val openingContactId: String?

  public val attachmentId: String?

  public val objectStoreReference: String?

  public val mainUti: String?

  public val otherUtis: Set<String>

  public val secondaryAttachments: Map<String, DataAttachment>

  public val deletedAttachments: List<DeletedAttachment>

  public val encryptedAttachment: ByteArray?

  public val decryptedAttachment: ByteArray?

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
	// region Document-Document
	// endregion
}

data class DecryptedDocument(
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
	override val documentLocation: DocumentLocation? = null,
	override val documentType: DocumentType? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val storedICureDocumentId: String? = null,
	override val externalUuid: String? = null,
	override val size: Long? = null,
	override val hash: String? = null,
	override val openingContactId: String? = null,
	override val attachmentId: String? = null,
	override val objectStoreReference: String? = null,
	override val mainUti: String? = null,
	override val otherUtis: Set<String> = emptySet(),
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
	override val encryptedAttachment: ByteArray? = null,
	override val decryptedAttachment: ByteArray? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Document {
	// region Document-DecryptedDocument
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Contact

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedDocument =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

data class EncryptedDocument(
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
	override val documentLocation: DocumentLocation? = null,
	override val documentType: DocumentType? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val storedICureDocumentId: String? = null,
	override val externalUuid: String? = null,
	override val size: Long? = null,
	override val hash: String? = null,
	override val openingContactId: String? = null,
	override val attachmentId: String? = null,
	override val objectStoreReference: String? = null,
	override val mainUti: String? = null,
	override val otherUtis: Set<String> = emptySet(),
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
	override val encryptedAttachment: ByteArray? = null,
	override val decryptedAttachment: ByteArray? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Document {
	// region Document-EncryptedDocument
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Contact

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedDocument =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun Document.copy(
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
	documentLocation: DocumentLocation? = this.documentLocation,
	documentType: DocumentType? = this.documentType,
	documentStatus: DocumentStatus? = this.documentStatus,
	externalUri: String? = this.externalUri,
	name: String? = this.name,
	version: String? = this.version,
	storedICureDocumentId: String? = this.storedICureDocumentId,
	externalUuid: String? = this.externalUuid,
	size: Long? = this.size,
	hash: String? = this.hash,
	openingContactId: String? = this.openingContactId,
	attachmentId: String? = this.attachmentId,
	objectStoreReference: String? = this.objectStoreReference,
	mainUti: String? = this.mainUti,
	otherUtis: Set<String> = this.otherUtis,
	secondaryAttachments: Map<String, DataAttachment> = this.secondaryAttachments,
	deletedAttachments: List<DeletedAttachment> = this.deletedAttachments,
	encryptedAttachment: ByteArray? = this.encryptedAttachment,
	decryptedAttachment: ByteArray? = this.decryptedAttachment,
	secretForeignKeys: Set<String> = this.secretForeignKeys,
	cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
	delegations: Map<String, Set<Delegation>> = this.delegations,
	encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
	encryptedSelf: Base64String? = this.encryptedSelf,
	securityMetadata: SecurityMetadata? = this.securityMetadata,
): Document {
                                      return when(this) {
                                          is DecryptedDocument -> copy(id = id, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, documentLocation = documentLocation, documentType =
          documentType, documentStatus = documentStatus, externalUri = externalUri, name = name,
          version = version, storedICureDocumentId = storedICureDocumentId, externalUuid =
          externalUuid, size = size, hash = hash, openingContactId = openingContactId, attachmentId
          = attachmentId, objectStoreReference = objectStoreReference, mainUti = mainUti, otherUtis
          = otherUtis, secondaryAttachments = secondaryAttachments, deletedAttachments =
          deletedAttachments, encryptedAttachment = encryptedAttachment, decryptedAttachment =
          decryptedAttachment, secretForeignKeys = secretForeignKeys, cryptedForeignKeys =
          cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys,
          encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedDocument -> copy(id = id, rev = rev, created = created, modified = modified,
          author = author, responsible = responsible, medicalLocationId = medicalLocationId, tags =
          tags, codes = codes, endOfLife = endOfLife, deletionDate = deletionDate, documentLocation
          = documentLocation, documentType = documentType, documentStatus = documentStatus,
          externalUri = externalUri, name = name, version = version, storedICureDocumentId =
          storedICureDocumentId, externalUuid = externalUuid, size = size, hash = hash,
          openingContactId = openingContactId, attachmentId = attachmentId, objectStoreReference =
          objectStoreReference, mainUti = mainUti, otherUtis = otherUtis, secondaryAttachments =
          secondaryAttachments, deletedAttachments = deletedAttachments, encryptedAttachment =
          encryptedAttachment, decryptedAttachment = decryptedAttachment, secretForeignKeys =
          secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata)
                                          }

}