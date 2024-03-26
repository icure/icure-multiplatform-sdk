package com.icure.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UsersStatus() {
  @SerialName("ACTIVE")
  Active,
  @SerialName("DISABLED")
  Disabled,
  @SerialName("REGISTERING")
  Registering,
}
