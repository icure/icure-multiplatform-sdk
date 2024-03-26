package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class PostalCode(
  public val code: String? = null,
  public val label: Map<String, String> = emptyMap(),
)
