package com.icure.sdk.model.requests

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class EntityBulkShareResult<T>(
  public val updatedEntity: T? = null,
  public val entityId: String,
  public val entityRev: String? = null,
  public val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap(),
) {
  @Serializable
  public data class RejectedShareOrMetadataUpdateRequest(
    public val code: Int,
    public val shouldRetry: Boolean,
    public val reason: String,
  )
}
