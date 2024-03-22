package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RoleConfiguration(
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
  // region RoleConfiguration-RoleConfiguration
  // endregion
}