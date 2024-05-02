package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByRegionTypeLabelLanguageFilter")
@Serializable
data class CodeByRegionTypeLabelLanguageFilter(
	override val desc: String? = null,
	public val region: String? = null,
	public val type: String,
	public val language: String,
	public val label: String? = null,
) : AbstractFilter<Code> {
	// region CodeByRegionTypeLabelLanguageFilter-CodeByRegionTypeLabelLanguageFilter

	// endregion
}
