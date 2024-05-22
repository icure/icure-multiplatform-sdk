package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.embed.gender_fromJs
import com.icure.sdk.js.model.embed.gender_toJs
import com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession

public
		fun patientByHcPartyGenderEducationProfession_toJs(obj: PatientByHcPartyGenderEducationProfession):
		PatientByHcPartyGenderEducationProfessionJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val gender = obj.gender?.let { nonNull1 ->
		gender_toJs(nonNull1)
	}
	val education = obj.education
	val profession = obj.profession
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
		gender_fromJs(nonNull1)
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
