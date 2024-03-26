package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class CareTeamMemberType() {
  @SerialName("physician")
  Physician,
  @SerialName("specialist")
  Specialist,
  @SerialName("other")
  Other,
}
