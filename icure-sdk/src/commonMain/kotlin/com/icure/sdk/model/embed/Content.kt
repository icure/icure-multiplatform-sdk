package com.icure.sdk.model.embed

import java.time.Instant
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Content(
  public val stringValue: String? = null,
  public val numberValue: Double? = null,
  public val booleanValue: Boolean? = null,
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
) : IoSerializable
