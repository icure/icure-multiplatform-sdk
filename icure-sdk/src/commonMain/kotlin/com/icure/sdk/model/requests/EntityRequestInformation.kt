package com.icure.sdk.model.requests

import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class EntityRequestInformation(
  public val requests: Map<String, EntityShareOrMetadataUpdateRequest> = emptyMap(),
  public val potentialParentDelegations: Set<String> = emptySet(),
)
