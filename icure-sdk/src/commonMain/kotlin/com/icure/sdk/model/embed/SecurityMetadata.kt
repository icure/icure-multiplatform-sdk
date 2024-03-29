package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.model.specializations.Sha256HexString
import kotlinx.serialization.Serializable
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class SecurityMetadata(
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
	public val keysEquivalences: Map<Sha256HexString, Sha256HexString> = emptyMap(),
) {
	// region SecurityMetadata-SecurityMetadata

	// endregion
}
