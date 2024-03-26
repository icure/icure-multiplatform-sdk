package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.model.specializations.Sha256HexString
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class SecurityMetadata(
  public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation> = emptyMap(),
  public val keysEquivalences: Map<Sha256HexString, Sha256HexString> = emptyMap(),
)
