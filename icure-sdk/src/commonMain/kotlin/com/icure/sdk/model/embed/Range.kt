package com.icure.sdk.model.embed

import kotlin.Double
import kotlinx.serialization.Serializable

@Serializable
public data class Range(
  public val low: Double? = null,
  public val high: Double? = null,
)
