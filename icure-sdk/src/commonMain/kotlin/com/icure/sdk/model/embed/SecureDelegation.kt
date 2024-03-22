package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class SecureDelegation(
  public val delegator: String? = null,
  public val `delegate`: String? = null,
  public val secretIds: Set<Base64String> = emptySet(),
  public val encryptionKeys: Set<Base64String> = emptySet(),
  public val owningEntityIds: Set<Base64String> = emptySet(),
  public val parentDelegations: Set<SecureDelegationKeyString> = emptySet(),
  public val exchangeDataId: String? = null,
  public val permissions: AccessLevel,
)
