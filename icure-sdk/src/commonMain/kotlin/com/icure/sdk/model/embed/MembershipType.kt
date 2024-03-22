package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MembershipType() {
  @SerialName("doctor")
  Doctor,
  @SerialName("mutuality")
  Mutuality,
  @SerialName("patient")
  Patient,
  @SerialName("specialist")
  Specialist,
  @SerialName("other")
  Other,
}
