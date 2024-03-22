package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.collections.Map
import kotlinx.serialization.Serializable
import org.taktik.icure.entities.utils.Sha256HexString

@Serializable
public data class SecurityMetadata(
  public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation> = emptyMap(),
  public val keysEquivalences: Map<Sha256HexString, Sha256HexString> = emptyMap(),
)
