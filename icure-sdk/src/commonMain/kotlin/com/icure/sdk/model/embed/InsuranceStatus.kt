package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class InsuranceStatus() {
  @SerialName("titular")
  Titular,
  @SerialName("child")
  Child,
  @SerialName("spouse")
  Spouse,
}
