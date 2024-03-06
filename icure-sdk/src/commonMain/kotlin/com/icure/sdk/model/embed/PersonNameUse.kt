package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class PersonNameUse() : IoSerializable {
  @SerialName("usual")
  Usual,
  @SerialName("official")
  Official,
  @SerialName("temp")
  Temp,
  @SerialName("nickname")
  Nickname,
  @SerialName("anonymous")
  Anonymous,
  @SerialName("maiden")
  Maiden,
  @SerialName("old")
  Old,
  @SerialName("other")
  Other,
}
