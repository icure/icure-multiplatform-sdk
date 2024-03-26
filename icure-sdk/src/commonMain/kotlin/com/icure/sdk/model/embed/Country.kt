package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class Country(
  public val code: String? = null,
  public val name: Map<String, String>? = null,
)
