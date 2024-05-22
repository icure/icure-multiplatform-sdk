package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import kotlin.String

public fun patientByHcPartyAndSsinsFilter_toJs(obj: PatientByHcPartyAndSsinsFilter):
		PatientByHcPartyAndSsinsFilterJs {
	val desc = obj.desc
	val ssins = listToArray(
		obj.ssins,
		{ x1: String ->
			x1
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndSsinsFilterJs(js("{" +
		"desc:desc," +
		"ssins:ssins," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndSsinsFilter_fromJs(obj: PatientByHcPartyAndSsinsFilterJs):
		PatientByHcPartyAndSsinsFilter {
	val desc = obj.desc
	val ssins = arrayToList(
		obj.ssins,
		"obj.ssins",
		{ x1: String ->
			x1
		},
	)
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndSsinsFilter(
		desc = desc,
		ssins = ssins,
		healthcarePartyId = healthcarePartyId,
	)
}
