package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class TimeSeries(
	public val fields: List<String> = emptyList(),
	public val samples: List<List<Double>> = emptyList(),
	public val min: List<Double> = emptyList(),
	public val max: List<Double> = emptyList(),
	public val mean: List<Double> = emptyList(),
	public val median: List<Double> = emptyList(),
	public val variance: List<Double> = emptyList(),
) {
	// region TimeSeries-TimeSeries

	// endregion
}
