package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("IntersectionFilter")
@Serializable
data class IntersectionFilter<O : Identifiable<String>>(
  override val desc: String? = null,
  override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.IntersectionFilter<O> {
	// region IntersectionFilter-IntersectionFilter
	// endregion
}