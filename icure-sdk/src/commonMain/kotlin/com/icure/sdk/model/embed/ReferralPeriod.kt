package com.icure.sdk.model.embed

import java.time.Instant
import kotlin.Comparable
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class ReferralPeriod(
  public val startDate: Instant? = null,
  public val endDate: Instant? = null,
  public val comment: String? = null,
) : IoSerializable, Comparable<ReferralPeriod>
