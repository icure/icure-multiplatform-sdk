package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MhcSignatureType() {
  @SerialName("holderEid")
  HolderEid,
  @SerialName("holderPaper")
  HolderPaper,
  @SerialName("legalrepresentativeEid")
  LegalrepresentativeEid,
  @SerialName("legalrepresentativePaper")
  LegalrepresentativePaper,
}
