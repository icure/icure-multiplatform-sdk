package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public sealed interface CareTeamMembership : Encrypted {
  public val startDate: Long?

  public val endDate: Long?

  public val careTeamMemberId: String?

  public val membershipType: MembershipType?

  override val encryptedSelf: String?
}

public data class DecryptedCareTeamMembership(
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val careTeamMemberId: String? = null,
  override val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMembership

public data class EncryptedCareTeamMembership(
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val careTeamMemberId: String? = null,
  override val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMembership

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
