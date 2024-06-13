package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyNameFilter_toJs(obj: PatientByHcPartyNameFilter):
		PatientByHcPartyNameFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val name = nullToUndefined(
		obj.name
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyNameFilterJs(js("{" +
		"desc:desc," +
		"name:name," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyNameFilter_fromJs(obj: PatientByHcPartyNameFilterJs):
		PatientByHcPartyNameFilter {
	val desc = undefinedToNull(obj.desc)
	val name = undefinedToNull(obj.name)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyNameFilter(
		desc = desc,
		name = name,
		healthcarePartyId = healthcarePartyId,
	)
}
