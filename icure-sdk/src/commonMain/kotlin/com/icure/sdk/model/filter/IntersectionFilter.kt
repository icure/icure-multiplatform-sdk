package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlinx.serialization.Contextual
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("IntersectionFilter")
@Serializable
data class IntersectionFilter<O : Identifiable<String>>(
	override val desc: String? = null,
  @DefaultValue("emptyList()")
	override val filters: List<@Contextual AbstractFilter<O>> = emptyList(),
	) : AbstractFilter<O>, Filter.IntersectionFilter<O> {
	// region IntersectionFilter-IntersectionFilter

	// endregion
}
