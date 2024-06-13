package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyIdentifiersFilter_toJs(obj: ServiceByHcPartyIdentifiersFilter):
		ServiceByHcPartyIdentifiersFilterJs {
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val desc = obj.desc ?: undefined
	return ServiceByHcPartyIdentifiersFilterJs(js("{" +
		"healthcarePartyId:healthcarePartyId," +
		"identifiers:identifiers," +
		"desc:desc" +
	"}"))
}

public fun serviceByHcPartyIdentifiersFilter_fromJs(obj: ServiceByHcPartyIdentifiersFilterJs):
		ServiceByHcPartyIdentifiersFilter {
	val healthcarePartyId = obj.healthcarePartyId
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val desc = obj.desc
	return ServiceByHcPartyIdentifiersFilter(
		healthcarePartyId = healthcarePartyId,
		identifiers = identifiers,
		desc = desc,
	)
}
