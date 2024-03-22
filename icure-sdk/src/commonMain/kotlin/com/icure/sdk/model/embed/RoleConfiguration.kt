package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class RoleConfiguration(
  public val source: RoleConfiguration.Companion.ConfigurationSource,
  public val roles: Set<String> = emptySet(),
)
