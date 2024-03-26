package com.icure.sdk.model.requests

import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class EntitySharedMetadataUpdateRequest(
  public val metadataAccessControlHash: SecureDelegationKeyString,
  public val secretIds: Map<Base64String, EntryUpdateType> = emptyMap(),
  public val encryptionKeys: Map<Base64String, EntryUpdateType> = emptyMap(),
  public val owningEntityIds: Map<Base64String, EntryUpdateType> = emptyMap(),
)
