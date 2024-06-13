package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndTelecomFilter_toJs(obj: PatientByHcPartyAndTelecomFilter):
		PatientByHcPartyAndTelecomFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val searchString = nullToUndefined(
		obj.searchString
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyAndTelecomFilterJs(js("{" +
		"desc:desc," +
		"searchString:searchString," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndTelecomFilter_fromJs(obj: PatientByHcPartyAndTelecomFilterJs):
		PatientByHcPartyAndTelecomFilter {
	val desc = undefinedToNull(obj.desc)
	val searchString = undefinedToNull(obj.searchString)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyAndTelecomFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
	)
}
