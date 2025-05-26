package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Right(
	@DefaultValue("emptySet()")
	public val names: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
) {
	public val dtoSerialName: String
	// region Right-Right

	// endregion
}
