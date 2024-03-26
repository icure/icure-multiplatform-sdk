package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseSynchronization(
  public val source: String? = null,
  public val target: String? = null,
  public val filter: String? = null,
  public val localTarget: Target? = null,
) {
  @Serializable
  public enum class Target() {
    @SerialName("base")
    Base,
    @SerialName("healthdata")
    Healthdata,
    @SerialName("patient")
    Patient,
  }
}
