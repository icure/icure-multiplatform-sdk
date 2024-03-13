package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CareTeamMembership(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val careTeamMemberId: String? = null,
  public val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : Encrypted
