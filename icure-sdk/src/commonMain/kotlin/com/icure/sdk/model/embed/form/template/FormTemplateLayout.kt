package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class FormTemplateLayout(
  public val form: String,
  public val actions: List<Action> = emptyList(),
  public val sections: List<Section> = emptyList(),
  public val description: String? = null,
  public val keywords: List<String>? = null,
) {
	// region FormTemplateLayout-FormTemplateLayout
	// endregion
}