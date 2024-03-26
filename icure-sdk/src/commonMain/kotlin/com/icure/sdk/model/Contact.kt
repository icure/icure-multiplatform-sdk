package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DecryptedSubContact
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.EncryptedSubContact
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.embed.SubContact
import com.icure.sdk.model.specializations.Base64String
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Contact : StoredDocument, ICureDocument<String>, HasEncryptionMetadata,
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

  public val identifier: List<Identifier>

  override val endOfLife: Long?

  override val deletionDate: Long?

  public val groupId: String?

  public val openingDate: Long?

  public val closingDate: Long?

  public val descr: String?

  public val location: String?

  public val externalId: String?

  public val encounterType: CodeStub?

  public val subContacts: Set<SubContact>

  public val services: Set<Service>

  public val healthcarePartyId: String?

  public val modifiedContactId: String?

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?

  public val notes: List<Annotation>
}

@SerialName
public data class DecryptedContact(
  override val id: String,
  override val rev: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val identifier: List<Identifier> = emptyList(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val groupId: String? = null,
  override val openingDate: Long? = null,
  override val closingDate: Long? = null,
  override val descr: String? = null,
  override val location: String? = null,
  override val externalId: String? = null,
  override val encounterType: CodeStub? = null,
  override val subContacts: Set<DecryptedSubContact> = emptySet(),
  override val services: Set<DecryptedService> = emptySet(),
  override val healthcarePartyId: String? = null,
  override val modifiedContactId: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val notes: List<Annotation> = emptyList(),
) : Contact

@SerialName
public data class EncryptedContact(
  override val id: String,
  override val rev: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val identifier: List<Identifier> = emptyList(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val groupId: String? = null,
  override val openingDate: Long? = null,
  override val closingDate: Long? = null,
  override val descr: String? = null,
  override val location: String? = null,
  override val externalId: String? = null,
  override val encounterType: CodeStub? = null,
  override val subContacts: Set<EncryptedSubContact> = emptySet(),
  override val services: Set<EncryptedService> = emptySet(),
  override val healthcarePartyId: String? = null,
  override val modifiedContactId: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val notes: List<Annotation> = emptyList(),
) : Contact

public fun Contact.copy(
  id: String = this.id,
  rev: String? = this.rev,
  created: Long? = this.created,
  modified: Long? = this.modified,
  author: String? = this.author,
  responsible: String? = this.responsible,
  medicalLocationId: String? = this.medicalLocationId,
  tags: Set<CodeStub> = this.tags,
  codes: Set<CodeStub> = this.codes,
  identifier: List<Identifier> = this.identifier,
  endOfLife: Long? = this.endOfLife,
  deletionDate: Long? = this.deletionDate,
  groupId: String? = this.groupId,
  openingDate: Long? = this.openingDate,
  closingDate: Long? = this.closingDate,
  descr: String? = this.descr,
  location: String? = this.location,
  externalId: String? = this.externalId,
  encounterType: CodeStub? = this.encounterType,
  subContacts: Set<SubContact> = this.subContacts,
  services: Set<Service> = this.services,
  healthcarePartyId: String? = this.healthcarePartyId,
  modifiedContactId: String? = this.modifiedContactId,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
  notes: List<Annotation> = this.notes,
): Contact {
                                      return when(this) {
                                          is DecryptedContact -> copy(id = id, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, identifier =
          identifier, endOfLife = endOfLife, deletionDate = deletionDate, groupId = groupId,
          openingDate = openingDate, closingDate = closingDate, descr = descr, location = location,
          externalId = externalId, encounterType = encounterType, subContacts = subContacts,
          services = services, healthcarePartyId = healthcarePartyId, modifiedContactId =
          modifiedContactId, secretForeignKeys = secretForeignKeys, cryptedForeignKeys =
          cryptedForeignKeys, delegations = delegations, encryptionKeys = encryptionKeys,
          encryptedSelf = encryptedSelf, securityMetadata = securityMetadata, notes = notes)
      is EncryptedContact -> copy(id = id, rev = rev, created = created, modified = modified, author
          = author, responsible = responsible, medicalLocationId = medicalLocationId, tags = tags,
          codes = codes, identifier = identifier, endOfLife = endOfLife, deletionDate =
          deletionDate, groupId = groupId, openingDate = openingDate, closingDate = closingDate,
          descr = descr, location = location, externalId = externalId, encounterType =
          encounterType, subContacts = subContacts, services = services, healthcarePartyId =
          healthcarePartyId, modifiedContactId = modifiedContactId, secretForeignKeys =
          secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata, notes = notes)
                                          }
}
