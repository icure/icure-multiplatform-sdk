package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyDateOfBirthFilter")
@Serializable
data class PatientByHcPartyDateOfBirthFilter(
	override val desc: String? = null,
	public val dateOfBirth: Int,
	public val healthcarePartyId: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyDateOfBirthFilter-PatientByHcPartyDateOfBirthFilter

	// endregion
}
