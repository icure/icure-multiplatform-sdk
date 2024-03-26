package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface CareTeamMembership : Encryptable {
  public val startDate: Long?

  public val endDate: Long?

  public val careTeamMemberId: String?

  public val membershipType: MembershipType?

  override val encryptedSelf: String?
	// region CareTeamMembership-CareTeamMembership
	// endregion
}

data class DecryptedCareTeamMembership(
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val careTeamMemberId: String? = null,
  override val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMembership {
	// region CareTeamMembership-DecryptedCareTeamMembership
	// endregion
}

data class EncryptedCareTeamMembership(
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val careTeamMemberId: String? = null,
  override val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMembership {
	// region CareTeamMembership-EncryptedCareTeamMembership
	// endregion
}

public fun CareTeamMembership.copy(
  startDate: Long? = this.startDate,
  endDate: Long? = this.endDate,
  careTeamMemberId: String? = this.careTeamMemberId,
  membershipType: MembershipType? = this.membershipType,
  encryptedSelf: String? = this.encryptedSelf,
): CareTeamMembership {
                                      return when(this) {
                                          is DecryptedCareTeamMembership -> copy(startDate =
          startDate, endDate = endDate, careTeamMemberId = careTeamMemberId, membershipType =
          membershipType, encryptedSelf = encryptedSelf)
      is EncryptedCareTeamMembership -> copy(startDate = startDate, endDate = endDate,
          careTeamMemberId = careTeamMemberId, membershipType = membershipType, encryptedSelf =
          encryptedSelf)
                                          }

}