package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public data class Payment(
  public val paymentDate: Long = 0,
  public val paymentType: PaymentType? = null,
  public val paid: Double? = null,
)
