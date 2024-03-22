package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class Content(
	val stringValue: String? = null,
	val numberValue: Double? = null,
	val booleanValue: Boolean? = null,
//	val instantValue: Instant? = null,
	val fuzzyDateValue: Long? = null,
	val binaryValue: ByteArray? = null,
	val documentId: String? = null,
	val measureValue: Measure? = null,
//	val medicationValue: Medication? = null,
	val compoundValue: Set<Service>? = null,
//	val timeSeries: TimeSeries? = null,
	val ratio: List<Measure>? = null,
	val range: List<Measure>? = null
)