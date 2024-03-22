package com.icure.sdk.model.requests

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class EntityBulkShareResult<T>(
  public val updatedEntity: T? = null,
  public val entityId: String,
  public val entityRev: String? = null,
  public val rejectedRequests:
      Map<String, EntityBulkShareResult.RejectedShareOrMetadataUpdateRequest> = emptyMap(),
)
