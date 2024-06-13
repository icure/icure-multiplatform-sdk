package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndSsinFilter_toJs(obj: PatientByHcPartyAndSsinFilter):
		PatientByHcPartyAndSsinFilterJs {
	val desc = obj.desc ?: undefined
	val ssin = obj.ssin
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	return PatientByHcPartyAndSsinFilterJs(js("{" +
		"desc:desc," +
		"ssin:ssin," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndSsinFilter_fromJs(obj: PatientByHcPartyAndSsinFilterJs):
		PatientByHcPartyAndSsinFilter {
	val desc = obj.desc
	val ssin = obj.ssin
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndSsinFilter(
		desc = desc,
		ssin = ssin,
		healthcarePartyId = healthcarePartyId,
	)
}
