package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EmailTemplate(
	public val subject: String? = null,
	public val body: String? = null,
	internal val dtoSerialName: String,
) {
	// region EmailTemplate-EmailTemplate

	// endregion
}
