package com.icure.sdk.model.gui

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class LabelPosition() : IoSerializable {
  @SerialName("Up")
  Up,
  @SerialName("Down")
  Down,
  @SerialName("Left")
  Left,
  @SerialName("Right")
  Right,
}
