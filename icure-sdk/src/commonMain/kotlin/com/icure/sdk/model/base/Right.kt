package com.icure.sdk.model.base

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Right(
  public val names: Set<String> = emptySet(),
  public val roles: Set<String> = emptySet(),
)
