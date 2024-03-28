package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByNameFilter")
@Serializable
data class HealthcarePartyByNameFilter(
	override val desc: String? = null,
	public val name: String,
	public val descending: Boolean? = null,
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByNameFilter-HealthcarePartyByNameFilter

	// endregion
}
