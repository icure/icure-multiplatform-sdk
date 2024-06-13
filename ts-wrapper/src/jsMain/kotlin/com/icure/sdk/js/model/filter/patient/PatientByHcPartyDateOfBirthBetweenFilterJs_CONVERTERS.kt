package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyDateOfBirthBetweenFilter_toJs(obj: PatientByHcPartyDateOfBirthBetweenFilter):
		PatientByHcPartyDateOfBirthBetweenFilterJs {
	val desc = obj.desc ?: undefined
	val minDateOfBirth = intToNumber(obj.minDateOfBirth) ?: undefined
	val maxDateOfBirth = intToNumber(obj.maxDateOfBirth) ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
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
