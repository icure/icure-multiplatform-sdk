package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyFilter_toJs(obj: PatientByHcPartyFilter): PatientByHcPartyFilterJs {
	val desc = obj.desc ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	return PatientByHcPartyFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyFilter_fromJs(obj: PatientByHcPartyFilterJs): PatientByHcPartyFilter {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
	)
}
