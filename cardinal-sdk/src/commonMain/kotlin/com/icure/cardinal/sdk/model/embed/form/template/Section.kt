package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Section(
	public val section: String,
	public val fields: List<StructureElement>,
	public val description: String? = null,
	public val keywords: List<String>? = null,
	internal val dtoSerialName: String,
) {
	// region Section-Section

	// endregion
}
