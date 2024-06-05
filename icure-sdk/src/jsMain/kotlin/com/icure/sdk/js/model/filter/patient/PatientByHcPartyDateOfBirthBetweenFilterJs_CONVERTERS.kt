package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter

public
		fun patientByHcPartyDateOfBirthBetweenFilter_toJs(obj: PatientByHcPartyDateOfBirthBetweenFilter):
		PatientByHcPartyDateOfBirthBetweenFilterJs {
	val desc = obj.desc
	val minDateOfBirth = intToNumber(obj.minDateOfBirth)
	val maxDateOfBirth = intToNumber(obj.maxDateOfBirth)
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyDateOfBirthBetweenFilterJs(js("{" +
		"desc:desc," +
		"minDateOfBirth:minDateOfBirth," +
		"maxDateOfBirth:maxDateOfBirth," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public
		fun patientByHcPartyDateOfBirthBetweenFilter_fromJs(obj: PatientByHcPartyDateOfBirthBetweenFilterJs):
		PatientByHcPartyDateOfBirthBetweenFilter {
	val desc = obj.desc
	val minDateOfBirth = numberToInt(obj.minDateOfBirth, "obj.minDateOfBirth")
	val maxDateOfBirth = numberToInt(obj.maxDateOfBirth, "obj.maxDateOfBirth")
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyDateOfBirthBetweenFilter(
		desc = desc,
		minDateOfBirth = minDateOfBirth,
		maxDateOfBirth = maxDateOfBirth,
		healthcarePartyId = healthcarePartyId,
	)
}
