package com.icure.sdk.model.embed

import com.icure.sdk.serialization.InstantSerializer
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class ReferralPeriod(
  @Serializable(with = InstantSerializer::class)
  public val startDate: Instant? = null,
  @Serializable(with = InstantSerializer::class)
  public val endDate: Instant? = null,
  public val comment: String? = null,
)
