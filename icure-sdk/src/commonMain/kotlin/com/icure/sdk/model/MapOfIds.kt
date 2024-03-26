package com.icure.sdk.model

import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class MapOfIds(
  public val mapOfIds: Map<String, List<String>> = emptyMap(),
)
