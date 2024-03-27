package com.icure.sdk.model.embed

import com.icure.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Content(
    public val stringValue: String? = null,
    public val numberValue: Double? = null,
    public val booleanValue: Boolean? = null,
    @Serializable(with = InstantSerializer::class)
    public val instantValue: Instant? = null,
    public val fuzzyDateValue: Long? = null,
    public val binaryValue: ByteArray? = null,
    public val documentId: String? = null,
    public val measureValue: Measure? = null,
    public val medicationValue: Medication? = null,
    public val timeSeries: TimeSeries? = null,
    public val compoundValue: List<Service>? = null,
    public val ratio: List<Measure>? = null,
    public val range: List<Measure>? = null,
)
