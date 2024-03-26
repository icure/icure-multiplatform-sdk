package com.icure.sdk.model.base

import com.icure.sdk.model.embed.Measure
import kotlinx.serialization.Serializable

@Serializable
public data class MeasurePair(
  public val first: Measure? = null,
  public val second: Measure? = null,
)
