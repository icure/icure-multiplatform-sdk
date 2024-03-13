package com.icure.sdk.model

import kotlin.Number
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class IndexingInfo(
  public val statuses: Map<String, Number>? = null,
)
