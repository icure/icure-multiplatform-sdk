package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.Sha256HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

@Serializable
public data class SecurityMetadata(
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
	@DefaultValue("emptyMap()")
	public val keysEquivalences: Map<Sha256HexString, Sha256HexString> = emptyMap(),
)
