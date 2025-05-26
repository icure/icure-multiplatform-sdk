package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndSsinsFilter")
@Serializable
data class PatientByHcPartyAndSsinsFilter(
	override val desc: String? = null,
	public val ssins: List<String>? = null,
	public val healthcarePartyId: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndSsinsFilter-PatientByHcPartyAndSsinsFilter

	// endregion
}
