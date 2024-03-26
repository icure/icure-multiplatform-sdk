package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HealthcarePartyStatus() {
  @SerialName("trainee")
  Trainee,
  @SerialName("withconvention")
  Withconvention,
  @SerialName("accreditated")
  Accreditated,
}
