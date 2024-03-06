package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class PersonalStatus() : IoSerializable {
  @SerialName("single")
  Single,
  @SerialName("in_couple")
  InCouple,
  @SerialName("married")
  Married,
  @SerialName("separated")
  Separated,
  @SerialName("divorced")
  Divorced,
  @SerialName("divorcing")
  Divorcing,
  @SerialName("widowed")
  Widowed,
  @SerialName("widower")
  Widower,
  @SerialName("complicated")
  Complicated,
  @SerialName("unknown")
  Unknown,
  @SerialName("contract")
  Contract,
  @SerialName("other")
  Other,
  @SerialName("annulled")
  Annulled,
  @SerialName("polygamous")
  Polygamous,
}
