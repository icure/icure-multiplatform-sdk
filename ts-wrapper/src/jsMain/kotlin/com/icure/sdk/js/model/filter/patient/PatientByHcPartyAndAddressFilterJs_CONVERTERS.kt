package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndAddressFilter_toJs(obj: PatientByHcPartyAndAddressFilter):
		PatientByHcPartyAndAddressFilterJs {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	val postalCode = obj.postalCode
	val houseNumber = obj.houseNumber
	return PatientByHcPartyAndAddressFilterJs(js("{" +
		"desc:desc," +
		"searchString:searchString," +
		"healthcarePartyId:healthcarePartyId," +
		"postalCode:postalCode," +
		"houseNumber:houseNumber" +
	"}"))
}

public fun patientByHcPartyAndAddressFilter_fromJs(obj: PatientByHcPartyAndAddressFilterJs):
		PatientByHcPartyAndAddressFilter {
	val desc = obj.desc
	val searchString = obj.searchString
	val healthcarePartyId = obj.healthcarePartyId
	val postalCode = obj.postalCode
	val houseNumber = obj.houseNumber
	return PatientByHcPartyAndAddressFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
		postalCode = postalCode,
		houseNumber = houseNumber,
	)
}
