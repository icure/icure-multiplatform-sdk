package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SuspensionReason() {
  @SerialName("notInsured")
  NotInsured,
  @SerialName("noReasonGiven")
  NoReasonGiven,
  @SerialName("isHospitalized")
  IsHospitalized,
  @SerialName("outsideOfCountry")
  OutsideOfCountry,
  @SerialName("changeOfMutuality")
  ChangeOfMutuality,
}
