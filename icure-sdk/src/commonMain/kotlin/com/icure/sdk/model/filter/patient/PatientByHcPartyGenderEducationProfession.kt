package com.icure.sdk.model.filter.patient

import com.icure.sdk.model.Patient
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyGenderEducationProfession")
@Serializable
data class PatientByHcPartyGenderEducationProfession(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val gender: Gender? = null,
	public val education: String? = null,
	public val profession: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyGenderEducationProfession-PatientByHcPartyGenderEducationProfession

	// endregion
}
