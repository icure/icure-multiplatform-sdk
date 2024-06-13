package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByHcPartyAndAddressFilter_toJs(obj: PatientByHcPartyAndAddressFilter):
		PatientByHcPartyAndAddressFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val searchString = nullToUndefined(
		obj.searchString
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val postalCode = nullToUndefined(
		obj.postalCode
	)
	val houseNumber = nullToUndefined(
		obj.houseNumber
	)
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
	val desc = undefinedToNull(obj.desc)
	val searchString = undefinedToNull(obj.searchString)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val postalCode = undefinedToNull(obj.postalCode)
	val houseNumber = undefinedToNull(obj.houseNumber)
	return PatientByHcPartyAndAddressFilter(
		desc = desc,
		searchString = searchString,
		healthcarePartyId = healthcarePartyId,
		postalCode = postalCode,
		houseNumber = houseNumber,
	)
}
