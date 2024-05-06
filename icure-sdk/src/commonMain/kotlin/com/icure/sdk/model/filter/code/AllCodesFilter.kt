package com.icure.sdk.model.filter.code

import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.Code

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllCodesFilter")
@Serializable
data class AllCodesFilter(
	override val desc: String? = null,
) : AbstractFilter<O>, Filter.AllFilter<O> {
	// region AllCodesFilter-AllCodesFilter

	// endregion
}
