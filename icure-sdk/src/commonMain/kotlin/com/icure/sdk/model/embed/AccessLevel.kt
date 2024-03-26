package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AccessLevel() {
  @SerialName("READ")
  Read,
  @SerialName("WRITE")
  Write,
}
