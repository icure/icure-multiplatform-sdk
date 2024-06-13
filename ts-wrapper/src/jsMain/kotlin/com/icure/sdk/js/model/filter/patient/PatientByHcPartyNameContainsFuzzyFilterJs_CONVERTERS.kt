package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun patientByHcPartyNameContainsFuzzyFilter_toJs(obj: PatientByHcPartyNameContainsFuzzyFilter):
		PatientByHcPartyNameContainsFuzzyFilterJs {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyNameContainsFuzzyFilterJs(js("{" +
		"desc:desc," +
		"searchString:searchString," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public
		fun patientByHcPartyNameContainsFuzzyFilter_fromJs(obj: PatientByHcPartyNameContainsFuzzyFilterJs):
		PatientByHcPartyNameContainsFuzzyFilter {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyNameContainsFuzzyFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
	)
}
