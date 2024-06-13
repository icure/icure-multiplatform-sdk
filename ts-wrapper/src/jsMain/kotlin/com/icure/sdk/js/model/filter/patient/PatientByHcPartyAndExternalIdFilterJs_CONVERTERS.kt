package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndExternalIdFilter_toJs(obj: PatientByHcPartyAndExternalIdFilter):
		PatientByHcPartyAndExternalIdFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val externalId = nullToUndefined(
		obj.externalId
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return PatientByHcPartyAndExternalIdFilterJs(js("{" +
		"desc:desc," +
		"externalId:externalId," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndExternalIdFilter_fromJs(obj: PatientByHcPartyAndExternalIdFilterJs):
		PatientByHcPartyAndExternalIdFilter {
	val desc = undefinedToNull(obj.desc)
	val externalId = undefinedToNull(obj.externalId)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return PatientByHcPartyAndExternalIdFilter(
		desc = desc,
		externalId = externalId,
		healthcarePartyId = healthcarePartyId,
	)
}
