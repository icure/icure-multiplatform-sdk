package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyDateOfBirthBetweenFilter_toJs(obj: PatientByHcPartyDateOfBirthBetweenFilter):
		PatientByHcPartyDateOfBirthBetweenFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val minDateOfBirth = nullToUndefined(
		intToNumber(obj.minDateOfBirth)
	)
	val maxDateOfBirth = nullToUndefined(
		intToNumber(obj.maxDateOfBirth)
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
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
	val desc = undefinedToNull(obj.desc)
	val minDateOfBirth = numberToInt(obj.minDateOfBirth, "obj.minDateOfBirth")
	val maxDateOfBirth = numberToInt(obj.maxDateOfBirth, "obj.maxDateOfBirth")
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyDateOfBirthBetweenFilter(
		desc = desc,
		minDateOfBirth = minDateOfBirth,
		maxDateOfBirth = maxDateOfBirth,
		healthcarePartyId = healthcarePartyId,
	)
}
