package com.icure.sdk.model

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ListOfIds(
  public val ids: List<String> = emptyList(),
)
