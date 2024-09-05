package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ComplementFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	override val superSet: AbstractFilter<O>,
	override val subSet: AbstractFilter<O>,
) : AbstractFilter<O>, Filter.ComplementFilter<O> {
	// region ComplementFilter-ComplementFilter

	// endregion
}
