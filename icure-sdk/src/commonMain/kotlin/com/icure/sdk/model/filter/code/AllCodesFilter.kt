package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllCodesFilter")
@Serializable
data class AllCodesFilter(
  override val desc: String? = null,
) : AbstractFilter<Code>, Filter.AllFilter<Code> {
	// region AllCodesFilter-AllCodesFilter
	// endregion
}