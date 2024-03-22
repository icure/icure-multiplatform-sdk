package com.icure.sdk.model.filter.predicate

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Operator(
  public val code: String,
) {
  @SerialName("EQUAL")
  Equal("=="),
  @SerialName("NOTEQUAL")
  Notequal("!="),
  @SerialName("GREATERTHAN")
  Greaterthan(">"),
  @SerialName("SMALLERTHAN")
  Smallerthan("<"),
  @SerialName("GREATERTHANOREQUAL")
  Greaterthanorequal(">="),
  @SerialName("SMALLERTHANOREQUAL")
  Smallerthanorequal("<="),
  @SerialName("LIKE")
  Like("%="),
  @SerialName("ILIKE")
  Ilike("%%="),
  ;
}
