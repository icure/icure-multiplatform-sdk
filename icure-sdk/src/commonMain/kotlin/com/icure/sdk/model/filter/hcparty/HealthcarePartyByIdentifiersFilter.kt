package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.sdk.model.HealthcareParty

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByIdentifiersFilter")
@Serializable
data class HealthcarePartyByIdentifiersFilter(
	public val identifiers: List<Identifier> = emptyList(),
	override val desc: String? = null,
) : AbstractFilter<O> {
	// region HealthcarePartyByIdentifiersFilter-HealthcarePartyByIdentifiersFilter

	// endregion
}
