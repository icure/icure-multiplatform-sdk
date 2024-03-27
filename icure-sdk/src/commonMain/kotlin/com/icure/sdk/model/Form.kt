package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Form : StoredDocument, ICureDocument<String>, HasEncryptionMetadata,
    Encryptable {
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

  public val openingDate: Long?

  public val status: String?

  public val version: Int?

  public val logicalUuid: String?

  public val descr: String?

  public val uniqueId: String?

  public val formTemplateId: String?

  public val contactId: String?

  public val healthElementId: String?

  public val planOfActionId: String?

  public val parent: String?

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
	// region Form-Form
	// endregion
}


@Serializable
data class DecryptedForm(
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
  override val openingDate: Long? = null,
  override val status: String? = null,
  override val version: Int? = null,
  override val logicalUuid: String? = null,
  override val descr: String? = null,
  override val uniqueId: String? = null,
  override val formTemplateId: String? = null,
  override val contactId: String? = null,
  override val healthElementId: String? = null,
  override val planOfActionId: String? = null,
  override val parent: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Form {
	// region Form-DecryptedForm
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedForm =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}


@Serializable
data class EncryptedForm(
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
  override val openingDate: Long? = null,
  override val status: String? = null,
  override val version: Int? = null,
  override val logicalUuid: String? = null,
  override val descr: String? = null,
  override val uniqueId: String? = null,
  override val formTemplateId: String? = null,
  override val contactId: String? = null,
  override val healthElementId: String? = null,
  override val planOfActionId: String? = null,
  override val parent: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Form {
	// region Form-EncryptedForm
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedForm =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun Form.copy(
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
  openingDate: Long? = this.openingDate,
  status: String? = this.status,
  version: Int? = this.version,
  logicalUuid: String? = this.logicalUuid,
  descr: String? = this.descr,
  uniqueId: String? = this.uniqueId,
  formTemplateId: String? = this.formTemplateId,
  contactId: String? = this.contactId,
  healthElementId: String? = this.healthElementId,
  planOfActionId: String? = this.planOfActionId,
  parent: String? = this.parent,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
): Form {
                                      return when(this) {
                                          is DecryptedForm -> copy(id = id, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, openingDate = openingDate, status = status, version =
          version, logicalUuid = logicalUuid, descr = descr, uniqueId = uniqueId, formTemplateId =
          formTemplateId, contactId = contactId, healthElementId = healthElementId, planOfActionId =
          planOfActionId, parent = parent, secretForeignKeys = secretForeignKeys, cryptedForeignKeys
          = cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys,
          encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedForm -> copy(id = id, rev = rev, created = created, modified = modified, author =
          author, responsible = responsible, medicalLocationId = medicalLocationId, tags = tags,
          codes = codes, endOfLife = endOfLife, deletionDate = deletionDate, openingDate =
          openingDate, status = status, version = version, logicalUuid = logicalUuid, descr = descr,
          uniqueId = uniqueId, formTemplateId = formTemplateId, contactId = contactId,
          healthElementId = healthElementId, planOfActionId = planOfActionId, parent = parent,
          secretForeignKeys = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys,
          delegations = delegations, encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf,
          securityMetadata = securityMetadata)
                                          }

}
