package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PatientHealthCarePartyType() {
	@SerialName("doctor")
	Doctor,

	@SerialName("referral")
	Referral,

	@SerialName("medicalhouse")
	Medicalhouse,

	@SerialName("retirementhome")
	Retirementhome,

	@SerialName("hospital")
	Hospital,

	@SerialName("other")
	Other,

	@SerialName("referringphysician")
	Referringphysician,

	@SerialName("managingorganization")
	Managingorganization,
}
