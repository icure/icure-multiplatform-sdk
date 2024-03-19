package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
data class Group(
  public val group: String,
  public val fields: List<StructureElement>? = null,
) : StructureElement {
	// region Group-Group
	// endregion
}