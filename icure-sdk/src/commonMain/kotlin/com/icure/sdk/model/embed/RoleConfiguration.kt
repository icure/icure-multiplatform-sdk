package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RoleConfiguration(
  public val source: Source,
  public val roles: Set<String> = emptySet(),
) {
  @Serializable
  public enum class Source() {
    @SerialName("CONFIGURATION")
    Configuration,
    @SerialName("INHERITED")
    Inherited,
    @SerialName("DEFAULT")
    Default,
  }
}
