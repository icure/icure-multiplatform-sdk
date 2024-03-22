package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.CareTeamMember
import com.icure.sdk.model.embed.DecryptedCareTeamMember
import com.icure.sdk.model.embed.DecryptedEpisode
import com.icure.sdk.model.embed.DecryptedPlanOfAction
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EncryptedCareTeamMember
import com.icure.sdk.model.embed.EncryptedEpisode
import com.icure.sdk.model.embed.EncryptedPlanOfAction
import com.icure.sdk.model.embed.Episode
import com.icure.sdk.model.embed.Laterality
import com.icure.sdk.model.embed.PlanOfAction
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.Boolean
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
sealed interface HealthElement : StoredDocument, ICureDocument<String>, Encryptable {
  override val id: String

  public val identifiers: List<Identifier>

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

  public val healthElementId: String?

  public val valueDate: Long?

  public val openingDate: Long?

  public val closingDate: Long?

  public val descr: String?

  public val note: String?

  public val notes: List<Annotation>

  public val relevant: Boolean

  public val idOpeningContact: String?

  public val idClosingContact: String?

  public val idService: String?

  public val status: Int

  public val laterality: Laterality?

  public val plansOfAction: List<PlanOfAction>

  public val episodes: List<Episode>

  public val careTeam: List<CareTeamMember>

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?
	// region HealthElement-HealthElement
	// endregion
}

data class DecryptedHealthElement(
	override val id: String,
	override val identifiers: List<Identifier> = emptyList(),
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
	override val healthElementId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val notes: List<Annotation> = emptyList(),
	override val relevant: Boolean,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val idService: String? = null,
	override val status: Int = 0,
	override val laterality: Laterality? = null,
	override val plansOfAction: List<DecryptedPlanOfAction> = emptyList(),
	override val episodes: List<DecryptedEpisode> = emptyList(),
	override val careTeam: List<DecryptedCareTeamMember> = emptyList(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : HealthElement {
	// region HealthElement-DecryptedHealthElement
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Contact

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedHealthElement =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

data class EncryptedHealthElement(
	override val id: String,
	override val identifiers: List<Identifier> = emptyList(),
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
	override val healthElementId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val notes: List<Annotation> = emptyList(),
	override val relevant: Boolean,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val idService: String? = null,
	override val status: Int = 0,
	override val laterality: Laterality? = null,
	override val plansOfAction: List<EncryptedPlanOfAction> = emptyList(),
	override val episodes: List<EncryptedEpisode> = emptyList(),
	override val careTeam: List<EncryptedCareTeamMember> = emptyList(),
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : HealthElement {
	// region HealthElement-EncryptedHealthElement
	override val type: EntityWithDelegationTypeName
		get() = EntityWithDelegationTypeName.Contact

	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedHealthElement =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun HealthElement.copy(
	id: String = this.id,
	identifiers: List<Identifier> = this.identifiers,
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
	healthElementId: String? = this.healthElementId,
	valueDate: Long? = this.valueDate,
	openingDate: Long? = this.openingDate,
	closingDate: Long? = this.closingDate,
	descr: String? = this.descr,
	note: String? = this.note,
	notes: List<Annotation> = this.notes,
	relevant: Boolean = this.relevant,
	idOpeningContact: String? = this.idOpeningContact,
	idClosingContact: String? = this.idClosingContact,
	idService: String? = this.idService,
	status: Int = this.status,
	laterality: Laterality? = this.laterality,
	plansOfAction: List<PlanOfAction> = this.plansOfAction,
	episodes: List<Episode> = this.episodes,
	careTeam: List<CareTeamMember> = this.careTeam,
	secretForeignKeys: Set<String> = this.secretForeignKeys,
	cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
	delegations: Map<String, Set<Delegation>> = this.delegations,
	encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
	encryptedSelf: Base64String? = this.encryptedSelf,
	securityMetadata: SecurityMetadata? = this.securityMetadata,
): HealthElement {
                                      return when(this) {
                                          is DecryptedHealthElement -> copy(id = id, identifiers =
          identifiers, rev = rev, created = created, modified = modified, author = author,
          responsible = responsible, medicalLocationId = medicalLocationId, tags = tags, codes =
          codes, endOfLife = endOfLife, deletionDate = deletionDate, healthElementId =
          healthElementId, valueDate = valueDate, openingDate = openingDate, closingDate =
          closingDate, descr = descr, note = note, notes = notes, relevant = relevant,
          idOpeningContact = idOpeningContact, idClosingContact = idClosingContact, idService =
          idService, status = status, laterality = laterality, plansOfAction = plansOfAction,
          episodes = episodes, careTeam = careTeam, secretForeignKeys = secretForeignKeys,
          cryptedForeignKeys = cryptedForeignKeys, delegations = delegations, encryptionKeys =
          encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata = securityMetadata)
      is EncryptedHealthElement -> copy(id = id, identifiers = identifiers, rev = rev, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          deletionDate = deletionDate, healthElementId = healthElementId, valueDate = valueDate,
          openingDate = openingDate, closingDate = closingDate, descr = descr, note = note, notes =
          notes, relevant = relevant, idOpeningContact = idOpeningContact, idClosingContact =
          idClosingContact, idService = idService, status = status, laterality = laterality,
          plansOfAction = plansOfAction, episodes = episodes, careTeam = careTeam, secretForeignKeys
          = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata)
                                          }

}