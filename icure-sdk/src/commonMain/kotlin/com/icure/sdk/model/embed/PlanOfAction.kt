package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.specializations.Base64String
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface PlanOfAction : Encryptable, ICureDocument<String>, Named {
  override val id: String

  override val created: Long?

  override val modified: Long?

  override val author: String?

  override val responsible: String?

  override val medicalLocationId: String?

  override val tags: Set<CodeStub>

  override val codes: Set<CodeStub>

  override val endOfLife: Long?

  public val prescriberId: String?

  public val valueDate: Long?

  public val openingDate: Long?

  public val closingDate: Long?

  public val deadlineDate: Long?

  override val name: String?

  public val descr: String?

  public val note: String?

  public val idOpeningContact: String?

  public val idClosingContact: String?

  public val status: Int

  public val documentIds: Set<String>

  public val numberOfCares: Int?

  public val careTeamMemberships: List<CareTeamMembership?>

  public val relevant: Boolean

  override val encryptedSelf: Base64String?
	// region PlanOfAction-PlanOfAction
	// endregion
}


@Serializable
data class DecryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val prescriberId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val deadlineDate: Long? = null,
	override val name: String? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val status: Int = 0,
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	override val careTeamMemberships: List<DecryptedCareTeamMembership?> = emptyList(),
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
) : PlanOfAction {
	// region PlanOfAction-DecryptedPlanOfAction
	// endregion
}


@Serializable
data class EncryptedPlanOfAction(
	override val id: String,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val tags: Set<CodeStub> = emptySet(),
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val prescriberId: String? = null,
	override val valueDate: Long? = null,
	override val openingDate: Long? = null,
	override val closingDate: Long? = null,
	override val deadlineDate: Long? = null,
	override val name: String? = null,
	override val descr: String? = null,
	override val note: String? = null,
	override val idOpeningContact: String? = null,
	override val idClosingContact: String? = null,
	override val status: Int = 0,
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	override val careTeamMemberships: List<EncryptedCareTeamMembership?> = emptyList(),
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
) : PlanOfAction {
	// region PlanOfAction-EncryptedPlanOfAction
	// endregion
}

public fun PlanOfAction.copy(
  id: String = this.id,
  created: Long? = this.created,
  modified: Long? = this.modified,
  author: String? = this.author,
  responsible: String? = this.responsible,
  medicalLocationId: String? = this.medicalLocationId,
  tags: Set<CodeStub> = this.tags,
  codes: Set<CodeStub> = this.codes,
  endOfLife: Long? = this.endOfLife,
  prescriberId: String? = this.prescriberId,
  valueDate: Long? = this.valueDate,
  openingDate: Long? = this.openingDate,
  closingDate: Long? = this.closingDate,
  deadlineDate: Long? = this.deadlineDate,
  name: String? = this.name,
  descr: String? = this.descr,
  note: String? = this.note,
  idOpeningContact: String? = this.idOpeningContact,
  idClosingContact: String? = this.idClosingContact,
  status: Int = this.status,
  documentIds: Set<String> = this.documentIds,
  numberOfCares: Int? = this.numberOfCares,
  careTeamMemberships: List<CareTeamMembership?> = this.careTeamMemberships,
  relevant: Boolean = this.relevant,
  encryptedSelf: Base64String? = this.encryptedSelf,
): PlanOfAction {
                                      return when(this) {
                                          is DecryptedPlanOfAction -> copy(id = id, created =
          created, modified = modified, author = author, responsible = responsible,
          medicalLocationId = medicalLocationId, tags = tags, codes = codes, endOfLife = endOfLife,
          prescriberId = prescriberId, valueDate = valueDate, openingDate = openingDate, closingDate
          = closingDate, deadlineDate = deadlineDate, name = name, descr = descr, note = note,
          idOpeningContact = idOpeningContact, idClosingContact = idClosingContact, status = status,
          documentIds = documentIds, numberOfCares = numberOfCares, careTeamMemberships =
          careTeamMemberships, relevant = relevant, encryptedSelf = encryptedSelf)
      is EncryptedPlanOfAction -> copy(id = id, created = created, modified = modified, author =
          author, responsible = responsible, medicalLocationId = medicalLocationId, tags = tags,
          codes = codes, endOfLife = endOfLife, prescriberId = prescriberId, valueDate = valueDate,
          openingDate = openingDate, closingDate = closingDate, deadlineDate = deadlineDate, name =
          name, descr = descr, note = note, idOpeningContact = idOpeningContact, idClosingContact =
          idClosingContact, status = status, documentIds = documentIds, numberOfCares =
          numberOfCares, careTeamMemberships = careTeamMemberships, relevant = relevant,
          encryptedSelf = encryptedSelf)
                                          }

}
