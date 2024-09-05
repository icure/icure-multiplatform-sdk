package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Suspension(
	public val beginMoment: Long? = null,
	public val endMoment: Long? = null,
	public val suspensionReason: String? = null,
	public val lifecycle: String? = null,
) {
	// region Suspension-Suspension

	// endregion
}
