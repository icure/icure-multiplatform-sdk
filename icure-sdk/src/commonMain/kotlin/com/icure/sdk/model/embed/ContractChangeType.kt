package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ContractChangeType() {
  @SerialName("inscriptionStart")
  InscriptionStart,
  @SerialName("inscriptionEnd")
  InscriptionEnd,
  @SerialName("suspension")
  Suspension,
  @SerialName("coverageChange")
  CoverageChange,
}
