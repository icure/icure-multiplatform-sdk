package com.icure.sdk.model.requests

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class EntitySharedMetadataUpdateRequest(
  public val metadataAccessControlHash: String,
  public val secretIds: Map<String, EntitySharedMetadataUpdateRequest.EntryUpdateType> = emptyMap(),
  public val encryptionKeys: Map<String, EntitySharedMetadataUpdateRequest.EntryUpdateType> =
      emptyMap(),
  public val owningEntityIds: Map<String, EntitySharedMetadataUpdateRequest.EntryUpdateType> =
      emptyMap(),
)
