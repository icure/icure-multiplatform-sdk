package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class Gender(
  public val code: String,
) : IoSerializable {
  @SerialName("code")
  Code,
  @SerialName("male")
  Male,
  @SerialName("female")
  Female,
  @SerialName("indeterminate")
  Indeterminate,
  @SerialName("changed")
  Changed,
  @SerialName("changedToMale")
  ChangedToMale,
  @SerialName("changedToFemale")
  ChangedToFemale,
  @SerialName("unknown")
  Unknown,
  ;
}
