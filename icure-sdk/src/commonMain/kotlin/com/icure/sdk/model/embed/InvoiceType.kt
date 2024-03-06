package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class InvoiceType() {
  @SerialName("patient")
  Patient,
  @SerialName("mutualfund")
  Mutualfund,
  @SerialName("payingagency")
  Payingagency,
  @SerialName("insurance")
  Insurance,
  @SerialName("efact")
  Efact,
  @SerialName("other")
  Other,
}
