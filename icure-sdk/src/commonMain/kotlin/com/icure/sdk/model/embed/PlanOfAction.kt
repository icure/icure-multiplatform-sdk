package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface PlanOfAction : Encryptable, ICureDocument<String>, Named {
	public val id: String

	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val tags: Set<CodeStub>

	public val codes: Set<CodeStub>

	public val endOfLife: Long?

	public val prescriberId: String?

	public val valueDate: Long?

	public val openingDate: Long?

	public val closingDate: Long?

	public val deadlineDate: Long?

	public val name: String?

	public val descr: String?

	public val note: String?

	public val idOpeningContact: String?

	public val idClosingContact: String?

	public val status: Int

	public val documentIds: Set<String>

	public val numberOfCares: Int?

	public val careTeamMemberships: List<CareTeamMembership?>

	public val relevant: Boolean

	public val encryptedSelf: Base64String?
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
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
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
	@DefaultValue("0")
	override val status: Int = 0,
	@DefaultValue("emptySet()")
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	@DefaultValue("emptyList()")
	override val careTeamMemberships: List<DecryptedCareTeamMembership?> = emptyList(),
	@DefaultValue("true")
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
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
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
	@DefaultValue("0")
	override val status: Int = 0,
	@DefaultValue("emptySet()")
	override val documentIds: Set<String> = emptySet(),
	override val numberOfCares: Int? = null,
	@DefaultValue("emptyList()")
	override val careTeamMemberships: List<EncryptedCareTeamMembership?> = emptyList(),
	@DefaultValue("true")
	override val relevant: Boolean = true,
	override val encryptedSelf: Base64String? = null,
) : PlanOfAction {
	// region PlanOfAction-EncryptedPlanOfAction

	// endregion
}
