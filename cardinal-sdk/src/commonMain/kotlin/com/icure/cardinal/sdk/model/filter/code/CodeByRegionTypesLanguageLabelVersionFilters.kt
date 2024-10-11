package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByRegionTypesLanguageLabelVersionFilters")
@Serializable
data class CodeByRegionTypesLanguageLabelVersionFilters(
	public val region: String? = null,
	public val types: List<String>,
	public val language: String,
	public val label: String,
	public val version: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Code> {
	// region CodeByRegionTypesLanguageLabelVersionFilters-CodeByRegionTypesLanguageLabelVersionFilters

	// endregion
}
