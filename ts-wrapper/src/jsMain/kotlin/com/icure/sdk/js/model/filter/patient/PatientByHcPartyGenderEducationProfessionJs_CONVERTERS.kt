package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyGenderEducationProfession_toJs(obj: PatientByHcPartyGenderEducationProfession):
		PatientByHcPartyGenderEducationProfessionJs {
	val desc = obj.desc ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	val gender = obj.gender?.let { nonNull1 ->
		nonNull1.name
	} ?: undefined
	val education = obj.education ?: undefined
	val profession = obj.profession ?: undefined
	return PatientByHcPartyGenderEducationProfessionJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"gender:gender," +
		"education:education," +
		"profession:profession" +
	"}"))
}

public
		fun patientByHcPartyGenderEducationProfession_fromJs(obj: PatientByHcPartyGenderEducationProfessionJs):
		PatientByHcPartyGenderEducationProfession {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val gender = obj.gender?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val education = obj.education
	val profession = obj.profession
	return PatientByHcPartyGenderEducationProfession(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		gender = gender,
		education = education,
		profession = profession,
	)
}
