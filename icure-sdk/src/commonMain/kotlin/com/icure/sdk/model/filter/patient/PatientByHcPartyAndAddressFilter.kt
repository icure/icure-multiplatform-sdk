package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.Patient

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndAddressFilter")
@Serializable
data class PatientByHcPartyAndAddressFilter(
	override val desc: String? = null,
	public val searchString: String? = null,
	public val healthcarePartyId: String? = null,
	public val postalCode: String? = null,
	public val houseNumber: String? = null,
) : AbstractFilter<O> {
	// region PatientByHcPartyAndAddressFilter-PatientByHcPartyAndAddressFilter

	// endregion
}
