package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class TimeSeries(
  public val fields: List<String> = emptyList(),
  public val samples: List<List<Double>> = emptyList(),
  public val min: List<Double> = emptyList(),
  public val max: List<Double> = emptyList(),
  public val mean: List<Double> = emptyList(),
  public val median: List<Double> = emptyList(),
  public val variance: List<Double> = emptyList(),
)
