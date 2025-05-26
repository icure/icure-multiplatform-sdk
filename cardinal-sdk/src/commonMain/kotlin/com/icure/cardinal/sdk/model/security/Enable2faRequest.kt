package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Enable2faRequest(
	public val secret: String,
	public val otpLength: Int,
	internal val dtoSerialName: String,
) {
	// region Enable2faRequest-Enable2faRequest

	// endregion
}
