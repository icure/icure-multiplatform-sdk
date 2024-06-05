package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter

public fun patientByHcPartyAndExternalIdFilter_toJs(obj: PatientByHcPartyAndExternalIdFilter):
		PatientByHcPartyAndExternalIdFilterJs {
	val desc = obj.desc
	val externalId = obj.externalId
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndExternalIdFilterJs(js("{" +
		"desc:desc," +
		"externalId:externalId," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public fun patientByHcPartyAndExternalIdFilter_fromJs(obj: PatientByHcPartyAndExternalIdFilterJs):
		PatientByHcPartyAndExternalIdFilter {
	val desc = obj.desc
	val externalId = obj.externalId
	val healthcarePartyId = obj.healthcarePartyId
	return PatientByHcPartyAndExternalIdFilter(
		desc = desc,
		externalId = externalId,
		healthcarePartyId = healthcarePartyId,
	)
}
