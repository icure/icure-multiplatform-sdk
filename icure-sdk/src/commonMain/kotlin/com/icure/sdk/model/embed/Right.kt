package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Right(
    public val userId: String? = null,
    public val read: Boolean = false,
    public val write: Boolean = false,
    public val administration: Boolean = false,
) {
	// region Right-Right

	// endregion
}
