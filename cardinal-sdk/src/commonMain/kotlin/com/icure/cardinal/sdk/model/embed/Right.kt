package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Right(
	public val userId: String? = null,
	@DefaultValue("false")
	public val read: Boolean = false,
	@DefaultValue("false")
	public val write: Boolean = false,
	@DefaultValue("false")
	public val administration: Boolean = false,
	internal val dtoSerialName: String,
) {
	// region Right-Right

	// endregion
}
