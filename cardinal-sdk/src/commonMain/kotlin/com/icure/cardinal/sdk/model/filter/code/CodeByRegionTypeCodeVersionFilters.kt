package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByRegionTypeCodeVersionFilters")
@Serializable
data class CodeByRegionTypeCodeVersionFilters(
	public val region: String,
	public val type: String?,
	public val code: String?,
	public val version: String?,
	override val desc: String?,
	internal val dtoSerialName: String,
) : AbstractFilter<Code> {
	// region CodeByRegionTypeCodeVersionFilters-CodeByRegionTypeCodeVersionFilters

	// endregion
}
