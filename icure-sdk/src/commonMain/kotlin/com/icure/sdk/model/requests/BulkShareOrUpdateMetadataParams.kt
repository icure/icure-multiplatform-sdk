package com.icure.sdk.model.requests

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class BulkShareOrUpdateMetadataParams(
  public val requestsByEntityId: Map<String, EntityRequestInformation>,
) {
  @Serializable
  public data class EntityRequestInformation(
    public val requests: Map<String, EntityShareOrMetadataUpdateRequest>,
    public val potentialParentDelegations: Set<SecureDelegationKeyString>,
  )
  // region BulkShareOrUpdateMetadataParams-BulkShareOrUpdateMetadataParams
  // endregion
}
