package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyDateOfBirthFilter_toJs(obj: PatientByHcPartyDateOfBirthFilter):
		PatientByHcPartyDateOfBirthFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val dateOfBirth = intToNumber(obj.dateOfBirth)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyDateOfBirthFilterJs(js("{" +
		"desc:desc," +
		"dateOfBirth:dateOfBirth," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyDateOfBirthFilter_fromJs(obj: PatientByHcPartyDateOfBirthFilterJs):
		PatientByHcPartyDateOfBirthFilter {
	val desc = undefinedToNull(obj.desc)
	val dateOfBirth = numberToInt(obj.dateOfBirth, "obj.dateOfBirth")
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyDateOfBirthFilter(
		desc = desc,
		dateOfBirth = dateOfBirth,
		healthcarePartyId = healthcarePartyId,
	)
}
