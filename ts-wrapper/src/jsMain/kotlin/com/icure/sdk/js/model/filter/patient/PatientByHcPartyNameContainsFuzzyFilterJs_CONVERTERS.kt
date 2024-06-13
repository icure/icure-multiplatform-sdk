package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyNameContainsFuzzyFilter_toJs(obj: PatientByHcPartyNameContainsFuzzyFilter):
		PatientByHcPartyNameContainsFuzzyFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val searchString = nullToUndefined(
		obj.searchString
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyNameContainsFuzzyFilterJs(js("{" +
		"desc:desc," +
		"searchString:searchString," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public
		fun patientByHcPartyNameContainsFuzzyFilter_fromJs(obj: PatientByHcPartyNameContainsFuzzyFilterJs):
		PatientByHcPartyNameContainsFuzzyFilter {
	val desc = undefinedToNull(obj.desc)
	val searchString = undefinedToNull(obj.searchString)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyNameContainsFuzzyFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
	)
}
