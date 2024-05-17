package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface CareTeamMembership : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val careTeamMemberId: String?

	public val membershipType: MembershipType?

	public val encryptedSelf: Base64String?
	// region CareTeamMembership-CareTeamMembership

	// endregion
}

@Serializable
data class DecryptedCareTeamMembership(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val careTeamMemberId: String? = null,
	override val membershipType: MembershipType? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership {
	// region CareTeamMembership-DecryptedCareTeamMembership

	// endregion
}

@Serializable
data class EncryptedCareTeamMembership(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val careTeamMemberId: String? = null,
	override val membershipType: MembershipType? = null,
	override val encryptedSelf: Base64String? = null,
) : CareTeamMembership {
	// region CareTeamMembership-EncryptedCareTeamMembership

	// endregion
}
