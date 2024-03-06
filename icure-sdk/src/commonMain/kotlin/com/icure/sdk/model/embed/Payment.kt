package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.Long
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Payment(
  public val paymentDate: Long = 0,
  public val paymentType: PaymentType? = null,
  public val paid: Double? = null,
) : IoSerializable
