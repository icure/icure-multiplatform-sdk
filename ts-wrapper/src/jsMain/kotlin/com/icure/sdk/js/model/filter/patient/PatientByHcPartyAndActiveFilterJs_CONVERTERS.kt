package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndActiveFilter_toJs(obj: PatientByHcPartyAndActiveFilter):
		PatientByHcPartyAndActiveFilterJs {
	val desc = obj.desc
	val active = obj.active
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndActiveFilterJs(js("{" +
		"desc:desc," +
		"active:active," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndActiveFilter_fromJs(obj: PatientByHcPartyAndActiveFilterJs):
		PatientByHcPartyAndActiveFilter {
	val desc = obj.desc
	val active = obj.active
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndActiveFilter(
		desc = desc,
		active = active,
		healthcarePartyId = healthcarePartyId,
	)
}
