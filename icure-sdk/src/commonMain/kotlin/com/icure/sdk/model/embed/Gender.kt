package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Gender(
  public val code: String,
) {
  @SerialName("male")
  Male("M"),
  @SerialName("female")
  Female("F"),
  @SerialName("indeterminate")
  Indeterminate("I"),
  @SerialName("changed")
  Changed("C"),
  @SerialName("changedToMale")
  ChangedToMale("Y"),
  @SerialName("changedToFemale")
  ChangedToFemale("X"),
  @SerialName("unknown")
  Unknown("U"),
  ;
}
