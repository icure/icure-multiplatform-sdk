package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.LinkQualification
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Service : Encryptable, ICureDocument<String> {
  override val id: String

  public val transactionId: String?

  public val identifier: List<Identifier>

  public val contactId: String?

  public val subContactIds: Set<String>?

  public val plansOfActionIds: Set<String>?

  public val healthElementsIds: Set<String>?

  public val formIds: Set<String>?

  public val secretForeignKeys: Set<String>?

  public val cryptedForeignKeys: Map<String, Set<Delegation>>

  public val delegations: Map<String, Set<Delegation>>

  public val encryptionKeys: Map<String, Set<Delegation>>

  public val label: String?

  public val index: Long?

  public val content: Map<String, Content>

  public val encryptedContent: String?

  public val textIndexes: Map<String, String>

  public val valueDate: Long?

  public val openingDate: Long?

  public val closingDate: Long?

  public val formId: String?

  override val created: Long?

  override val modified: Long?

  override val endOfLife: Long?

  override val author: String?

  override val responsible: String?

  override val medicalLocationId: String?

  public val comment: String?

  public val status: Int?

  public val invoicingCodes: Set<String>

  public val notes: List<Annotation>

  public val qualifiedLinks: Map<LinkQualification, Map<String, String>>

  override val codes: Set<CodeStub>

  override val tags: Set<CodeStub>

  override val encryptedSelf: String?

  public val securityMetadata: SecurityMetadata?
}

@SerialName
public data class DecryptedService(
  override val id: String,
  override val transactionId: String? = null,
  override val identifier: List<Identifier> = emptyList(),
  override val contactId: String? = null,
  override val subContactIds: Set<String>? = null,
  override val plansOfActionIds: Set<String>? = null,
  override val healthElementsIds: Set<String>? = null,
  override val formIds: Set<String>? = null,
  override val secretForeignKeys: Set<String>? = null,
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val label: String? = null,
  override val index: Long? = null,
  override val content: Map<String, Content> = emptyMap(),
  override val encryptedContent: String? = null,
  override val textIndexes: Map<String, String> = emptyMap(),
  override val valueDate: Long? = null,
  override val openingDate: Long? = null,
  override val closingDate: Long? = null,
  override val formId: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val endOfLife: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val comment: String? = null,
  override val status: Int? = null,
  override val invoicingCodes: Set<String> = emptySet(),
  override val notes: List<Annotation> = emptyList(),
  override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
  override val codes: Set<CodeStub> = emptySet(),
  override val tags: Set<CodeStub> = emptySet(),
  override val encryptedSelf: String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Service

@SerialName
public data class EncryptedService(
  override val id: String,
  override val transactionId: String? = null,
  override val identifier: List<Identifier> = emptyList(),
  override val contactId: String? = null,
  override val subContactIds: Set<String>? = null,
  override val plansOfActionIds: Set<String>? = null,
  override val healthElementsIds: Set<String>? = null,
  override val formIds: Set<String>? = null,
  override val secretForeignKeys: Set<String>? = null,
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val label: String? = null,
  override val index: Long? = null,
  override val content: Map<String, Content> = emptyMap(),
  override val encryptedContent: String? = null,
  override val textIndexes: Map<String, String> = emptyMap(),
  override val valueDate: Long? = null,
  override val openingDate: Long? = null,
  override val closingDate: Long? = null,
  override val formId: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val endOfLife: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val comment: String? = null,
  override val status: Int? = null,
  override val invoicingCodes: Set<String> = emptySet(),
  override val notes: List<Annotation> = emptyList(),
  override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
  override val codes: Set<CodeStub> = emptySet(),
  override val tags: Set<CodeStub> = emptySet(),
  override val encryptedSelf: String? = null,
  override val securityMetadata: SecurityMetadata? = null,
) : Service

public fun Service.copy(
  id: String = this.id,
  transactionId: String? = this.transactionId,
  identifier: List<Identifier> = this.identifier,
  contactId: String? = this.contactId,
  subContactIds: Set<String>? = this.subContactIds,
  plansOfActionIds: Set<String>? = this.plansOfActionIds,
  healthElementsIds: Set<String>? = this.healthElementsIds,
  formIds: Set<String>? = this.formIds,
  secretForeignKeys: Set<String>? = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  label: String? = this.label,
  index: Long? = this.index,
  content: Map<String, Content> = this.content,
  encryptedContent: String? = this.encryptedContent,
  textIndexes: Map<String, String> = this.textIndexes,
  valueDate: Long? = this.valueDate,
  openingDate: Long? = this.openingDate,
  closingDate: Long? = this.closingDate,
  formId: String? = this.formId,
  created: Long? = this.created,
  modified: Long? = this.modified,
  endOfLife: Long? = this.endOfLife,
  author: String? = this.author,
  responsible: String? = this.responsible,
  medicalLocationId: String? = this.medicalLocationId,
  comment: String? = this.comment,
  status: Int? = this.status,
  invoicingCodes: Set<String> = this.invoicingCodes,
  notes: List<Annotation> = this.notes,
  qualifiedLinks: Map<LinkQualification, Map<String, String>> = this.qualifiedLinks,
  codes: Set<CodeStub> = this.codes,
  tags: Set<CodeStub> = this.tags,
  encryptedSelf: String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
): Service {
                                      return when(this) {
                                          is DecryptedService -> copy(id = id, transactionId =
          transactionId, identifier = identifier, contactId = contactId, subContactIds =
          subContactIds, plansOfActionIds = plansOfActionIds, healthElementsIds = healthElementsIds,
          formIds = formIds, secretForeignKeys = secretForeignKeys, cryptedForeignKeys =
          cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys, label =
          label, index = index, content = content, encryptedContent = encryptedContent, textIndexes
          = textIndexes, valueDate = valueDate, openingDate = openingDate, closingDate =
          closingDate, formId = formId, created = created, modified = modified, endOfLife =
          endOfLife, author = author, responsible = responsible, medicalLocationId =
          medicalLocationId, comment = comment, status = status, invoicingCodes = invoicingCodes,
          notes = notes, qualifiedLinks = qualifiedLinks, codes = codes, tags = tags, encryptedSelf
          = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedService -> copy(id = id, transactionId = transactionId, identifier = identifier,
          contactId = contactId, subContactIds = subContactIds, plansOfActionIds = plansOfActionIds,
          healthElementsIds = healthElementsIds, formIds = formIds, secretForeignKeys =
          secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, label = label, index = index, content = content,
          encryptedContent = encryptedContent, textIndexes = textIndexes, valueDate = valueDate,
          openingDate = openingDate, closingDate = closingDate, formId = formId, created = created,
          modified = modified, endOfLife = endOfLife, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, comment = comment, status = status, invoicingCodes
          = invoicingCodes, notes = notes, qualifiedLinks = qualifiedLinks, codes = codes, tags =
          tags, encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
                                          }
}
