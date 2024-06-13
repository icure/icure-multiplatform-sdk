package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyGenderEducationProfession_toJs(obj: PatientByHcPartyGenderEducationProfession):
		PatientByHcPartyGenderEducationProfessionJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val gender = nullToUndefined(
		obj.gender?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val education = nullToUndefined(
		obj.education
	)
	val profession = nullToUndefined(
		obj.profession
	)
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
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val gender = obj.gender?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val education = undefinedToNull(obj.education)
	val profession = undefinedToNull(obj.profession)
	return PatientByHcPartyGenderEducationProfession(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		gender = gender,
		education = education,
		profession = profession,
	)
}
