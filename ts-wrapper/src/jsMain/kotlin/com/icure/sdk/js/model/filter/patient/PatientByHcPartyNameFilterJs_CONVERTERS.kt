package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyNameFilter_toJs(obj: PatientByHcPartyNameFilter):
		PatientByHcPartyNameFilterJs {
	val desc = obj.desc
	val name = obj.name
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyNameFilterJs(js("{" +
		"desc:desc," +
		"name:name," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyNameFilter_fromJs(obj: PatientByHcPartyNameFilterJs):
		PatientByHcPartyNameFilter {
	val desc = obj.desc
	val name = obj.name
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyNameFilter(
		desc = desc,
		name = name,
		healthcarePartyId = healthcarePartyId,
	)
}
