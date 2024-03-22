package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.ReceiptBlobType
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Receipt : StoredDocument, ICureDocument<String>, Encryptable {
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

  public val attachmentIds: Map<ReceiptBlobType, String>

  public val references: List<String>

  public val documentId: String?

  public val category: String?

  public val subCategory: String?

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
}

public data class DecryptedReceipt(
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
  override val attachmentIds: Map<ReceiptBlobType, String> = emptyMap(),
  override val references: List<String> = emptyList(),
  override val documentId: String? = null,
  override val category: String? = null,
  override val subCategory: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Receipt

public data class EncryptedReceipt(
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
  override val attachmentIds: Map<ReceiptBlobType, String> = emptyMap(),
  override val references: List<String> = emptyList(),
  override val documentId: String? = null,
  override val category: String? = null,
  override val subCategory: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Receipt

public fun Receipt.copy(
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
  attachmentIds: Map<ReceiptBlobType, String> = this.attachmentIds,
  references: List<String> = this.references,
  documentId: String? = this.documentId,
  category: String? = this.category,
  subCategory: String? = this.subCategory,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
): Receipt {
                                      return when(this) {
                                          is DecryptedReceipt -> copy(id = id, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, attachmentIds = attachmentIds, references = references,
          documentId = documentId, category = category, subCategory = subCategory, secretForeignKeys
          = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata)
      is EncryptedReceipt -> copy(id = id, rev = rev, created = created, modified = modified, author
          = author, responsible = responsible, medicalLocationId = medicalLocationId, tags = tags,
          codes = codes, endOfLife = endOfLife, deletionDate = deletionDate, attachmentIds =
          attachmentIds, references = references, documentId = documentId, category = category,
          subCategory = subCategory, secretForeignKeys = secretForeignKeys, cryptedForeignKeys =
          cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys,
          encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
                                          }
}