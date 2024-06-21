package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.service.ServiceByContactsAndSubcontactsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByContactsAndSubcontactsFilter_toJs(obj: ServiceByContactsAndSubcontactsFilter):
		ServiceByContactsAndSubcontactsFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val contacts = setToArray(
		obj.contacts,
		{ x1: String ->
			x1
		},
	)
	val subContacts = nullToUndefined(
		setToArray(
			obj.subContacts,
			{ x1: String ->
				x1
			},
		)
	)
	val startValueDate = nullToUndefined(
		longToNumber(obj.startValueDate)
	)
	val endValueDate = nullToUndefined(
		longToNumber(obj.endValueDate)
	)
	return ServiceByContactsAndSubcontactsFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"contacts:contacts," +
		"subContacts:subContacts," +
		"startValueDate:startValueDate," +
		"endValueDate:endValueDate" +
	"}"))
}

public
		fun serviceByContactsAndSubcontactsFilter_fromJs(obj: ServiceByContactsAndSubcontactsFilterJs):
		ServiceByContactsAndSubcontactsFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val contacts = arrayToSet(
		obj.contacts,
		"obj.contacts",
		{ x1: String ->
			x1
		},
	)
	val subContacts = arrayToSet(
		obj.subContacts,
		"obj.subContacts",
		{ x1: String ->
			x1
		},
	)
	val startValueDate = numberToLong(obj.startValueDate, "obj.startValueDate")
	val endValueDate = numberToLong(obj.endValueDate, "obj.endValueDate")
	return ServiceByContactsAndSubcontactsFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		contacts = contacts,
		subContacts = subContacts,
		startValueDate = startValueDate,
		endValueDate = endValueDate,
	)
}