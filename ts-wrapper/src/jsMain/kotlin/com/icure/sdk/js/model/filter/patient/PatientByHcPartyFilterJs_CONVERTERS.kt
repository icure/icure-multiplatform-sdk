package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyFilter_toJs(obj: PatientByHcPartyFilter): PatientByHcPartyFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyFilter_fromJs(obj: PatientByHcPartyFilterJs): PatientByHcPartyFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
	)
}
