package com.icure.sdk.model.requests

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntitySharedMetadataUpdateRequest(
  public val metadataAccessControlHash: String,
  public val secretIds: Map<String, EntryUpdateType> = emptyMap(),
  public val encryptionKeys: Map<String, EntryUpdateType> = emptyMap(),
  public val owningEntityIds: Map<String, EntryUpdateType> = emptyMap(),
) {
	// region EntitySharedMetadataUpdateRequest-EntitySharedMetadataUpdateRequest
	// endregion
}