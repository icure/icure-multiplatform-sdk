package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import com.icure.cardinal.sdk.model.specializations.Sha256HexString
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class SecurityMetadata(
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
	internal val dtoSerialName: String,
) {
	// region SecurityMetadata-SecurityMetadata

	// endregion
}
