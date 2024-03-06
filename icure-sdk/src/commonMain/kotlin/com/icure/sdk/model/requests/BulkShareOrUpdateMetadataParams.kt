package com.icure.sdk.model.requests

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class BulkShareOrUpdateMetadataParams(
  public val requestsByEntityId: Map<String, EntityRequestInformation> = emptyMap(),
)
