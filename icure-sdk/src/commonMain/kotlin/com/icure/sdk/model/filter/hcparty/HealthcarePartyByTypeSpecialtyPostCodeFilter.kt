package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByTypeSpecialtyPostCodeFilter")
@Serializable
data class HealthcarePartyByTypeSpecialtyPostCodeFilter(
	public val specialty: String,
	public val specCode: String,
	public val startPostCode: String,
	public val endPostCode: String,
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByTypeSpecialtyPostCodeFilter-HealthcarePartyByTypeSpecialtyPostCodeFilter
	// endregion
}
