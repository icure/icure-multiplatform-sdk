package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndSsinsFilter_toJs(obj: PatientByHcPartyAndSsinsFilter):
		PatientByHcPartyAndSsinsFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val ssins = nullToUndefined(
		listToArray(
			obj.ssins,
			{ x1: String ->
				x1
			},
		)
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyAndSsinsFilterJs(js("{" +
		"desc:desc," +
		"ssins:ssins," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndSsinsFilter_fromJs(obj: PatientByHcPartyAndSsinsFilterJs):
		PatientByHcPartyAndSsinsFilter {
	val desc = undefinedToNull(obj.desc)
	val ssins = arrayToList(
		obj.ssins,
		"obj.ssins",
		{ x1: String ->
			x1
		},
	)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyAndSsinsFilter(
		desc = desc,
		ssins = ssins,
		healthcarePartyId = healthcarePartyId,
	)
}
