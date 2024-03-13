package com.icure.sdk.model.gui

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LabelPosition() {
  @SerialName("Up")
  Up,
  @SerialName("Down")
  Down,
  @SerialName("Left")
  Left,
  @SerialName("Right")
  Right,
}
