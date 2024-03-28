package com.icure.sdk.model.base

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Right(
	public val names: Set<String> = emptySet(),
	public val roles: Set<String> = emptySet(),
) {
	// region Right-Right

	// endregion
}
