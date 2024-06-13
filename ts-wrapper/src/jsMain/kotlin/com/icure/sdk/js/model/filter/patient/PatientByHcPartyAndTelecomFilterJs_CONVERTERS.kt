package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndTelecomFilter_toJs(obj: PatientByHcPartyAndTelecomFilter):
		PatientByHcPartyAndTelecomFilterJs {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndTelecomFilterJs(js("{" +
		"desc:desc," +
		"searchString:searchString," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndTelecomFilter_fromJs(obj: PatientByHcPartyAndTelecomFilterJs):
		PatientByHcPartyAndTelecomFilter {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndTelecomFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
	)
}
