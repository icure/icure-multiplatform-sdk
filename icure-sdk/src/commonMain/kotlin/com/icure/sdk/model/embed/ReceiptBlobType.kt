package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ReceiptBlobType() {
  @SerialName("xades")
  Xades,
  @SerialName("kmehrRequest")
  KmehrRequest,
  @SerialName("kmehrResponse")
  KmehrResponse,
  @SerialName("soapRequest")
  SoapRequest,
  @SerialName("soapResponse")
  SoapResponse,
  @SerialName("soapConversation")
  SoapConversation,
  @SerialName("tack")
  Tack,
}
