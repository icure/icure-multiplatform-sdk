package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FlatRateType() {
  @SerialName("physician")
  Physician,
  @SerialName("physiotherapist")
  Physiotherapist,
  @SerialName("nurse")
  Nurse,
  @SerialName("ptd")
  Ptd,
}
