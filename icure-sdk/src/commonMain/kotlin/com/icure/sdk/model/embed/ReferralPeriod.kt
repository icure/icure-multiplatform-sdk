package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class ReferralPeriod(
  @Serializable(with = icure.sdk.serialization.InstantSerializer::class)
  public val startDate: Instant? = null,
  @Serializable(with = icure.sdk.serialization.InstantSerializer::class)
  public val endDate: Instant? = null,
  public val comment: String? = null,
)
