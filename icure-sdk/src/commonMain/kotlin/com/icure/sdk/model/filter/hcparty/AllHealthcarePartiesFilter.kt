package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.HealthcareParty

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllHealthcarePartiesFilter")
@Serializable
data class AllHealthcarePartiesFilter(
	override val desc: String? = null,
) : AbstractFilter<O>, Filter.AllFilter<O> {
	// region AllHealthcarePartiesFilter-AllHealthcarePartiesFilter

	// endregion
}
