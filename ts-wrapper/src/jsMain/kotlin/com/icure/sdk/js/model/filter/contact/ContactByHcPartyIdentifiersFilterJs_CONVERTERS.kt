package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactByHcPartyIdentifiersFilter_toJs(obj: ContactByHcPartyIdentifiersFilter):
		ContactByHcPartyIdentifiersFilterJs {
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val desc = nullToUndefined(
		obj.desc
	)
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	return ContactByHcPartyIdentifiersFilterJs(js("{" +
		"healthcarePartyId:healthcarePartyId," +
		"desc:desc," +
		"identifiers:identifiers" +
	"}"))
}

public fun contactByHcPartyIdentifiersFilter_fromJs(obj: ContactByHcPartyIdentifiersFilterJs):
		ContactByHcPartyIdentifiersFilter {
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val desc = undefinedToNull(obj.desc)
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	return ContactByHcPartyIdentifiersFilter(
		healthcarePartyId = healthcarePartyId,
		desc = desc,
		identifiers = identifiers,
	)
}
