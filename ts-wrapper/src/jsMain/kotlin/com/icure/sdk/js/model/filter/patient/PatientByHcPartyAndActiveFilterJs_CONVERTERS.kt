package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndActiveFilter_toJs(obj: PatientByHcPartyAndActiveFilter):
		PatientByHcPartyAndActiveFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val active = obj.active
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyAndActiveFilterJs(js("{" +
		"desc:desc," +
		"active:active," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndActiveFilter_fromJs(obj: PatientByHcPartyAndActiveFilterJs):
		PatientByHcPartyAndActiveFilter {
	val desc = undefinedToNull(obj.desc)
	val active = obj.active
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyAndActiveFilter(
		desc = desc,
		active = active,
		healthcarePartyId = healthcarePartyId,
	)
}
