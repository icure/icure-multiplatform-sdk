package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class InsuranceParameter() {
  @SerialName("status")
  Status,
  @SerialName("tc1")
  Tc1,
  @SerialName("tc2")
  Tc2,
  @SerialName("preferentialstatus")
  Preferentialstatus,
  @SerialName("chronicaldisease")
  Chronicaldisease,
  @SerialName("paymentapproval")
  Paymentapproval,
  @SerialName("mdaInputReference")
  MdaInputReference,
}
