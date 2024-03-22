package com.icure.sdk.model

import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public data class AggregatedMetrics(
  public val activeEntitiesCount: Long? = null,
)
