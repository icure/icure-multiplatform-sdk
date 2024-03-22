package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Laterality() {
  @SerialName("left")
  Left,
  @SerialName("right")
  Right,
}
