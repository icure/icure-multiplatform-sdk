package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class CareTeamMembership(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val careTeamMemberId: String? = null,
  public val membershipType: MembershipType? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable
