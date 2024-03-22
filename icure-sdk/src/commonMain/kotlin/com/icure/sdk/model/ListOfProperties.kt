package com.icure.sdk.model

import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class ListOfProperties(
  public val properties: Set<PropertyStub> = emptySet(),
)
