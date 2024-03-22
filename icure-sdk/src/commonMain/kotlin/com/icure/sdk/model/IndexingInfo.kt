package com.icure.sdk.model

import kotlin.Int
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class IndexingInfo(
  public val statuses: Map<String, Int>? = null,
)
