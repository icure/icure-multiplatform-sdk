package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByIdsFilter")
@Serializable
data class CodeByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Code>, Filter.IdsFilter<String, Code> {
	// region CodeByIdsFilter-CodeByIdsFilter

	// endregion
}
