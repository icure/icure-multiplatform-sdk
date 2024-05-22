package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PatientHealthCarePartyType
import kotlin.String

public fun patientHealthCarePartyType_toJs(obj: PatientHealthCarePartyType): String = obj.name

public fun patientHealthCarePartyType_fromJs(obj: String): PatientHealthCarePartyType = when (obj) {
	"Doctor" -> PatientHealthCarePartyType.Doctor
	"Referral" -> PatientHealthCarePartyType.Referral
	"Medicalhouse" -> PatientHealthCarePartyType.Medicalhouse
	"Retirementhome" -> PatientHealthCarePartyType.Retirementhome
	"Hospital" -> PatientHealthCarePartyType.Hospital
	"Other" -> PatientHealthCarePartyType.Other
	"Referringphysician" -> PatientHealthCarePartyType.Referringphysician
	"Managingorganization" -> PatientHealthCarePartyType.Managingorganization
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PatientHealthCarePartyType: $obj""")
}
