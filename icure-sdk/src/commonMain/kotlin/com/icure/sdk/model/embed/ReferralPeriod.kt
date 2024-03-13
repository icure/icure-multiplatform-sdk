package com.icure.sdk.model.embed

import java.time.Instant
import kotlin.Comparable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ReferralPeriod(
  public val startDate: Instant? = null,
  public val endDate: Instant? = null,
  public val comment: String? = null,
) : Comparable<ReferralPeriod>
