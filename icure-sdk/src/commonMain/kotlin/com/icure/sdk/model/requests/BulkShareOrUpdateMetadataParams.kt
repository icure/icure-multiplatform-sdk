package com.icure.sdk.model.requests

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class BulkShareOrUpdateMetadataParams(
  public val requestsByEntityId: Map<String, EntityRequestInformation> = emptyMap(),
) {
  @Serializable
  public data class EntityRequestInformation(
    public val requests: Map<String, EntityShareOrMetadataUpdateRequest> = emptyMap(),
    public val potentialParentDelegations: Set<SecureDelegationKeyString> = emptySet(),
  )
}
