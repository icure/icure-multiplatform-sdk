package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
data class Section(
  public val section: String,
  public val fields: List<StructureElement> = emptyList(),
  public val description: String? = null,
  public val keywords: List<String>? = null,
) {
	// region Section-Section
	// endregion
}