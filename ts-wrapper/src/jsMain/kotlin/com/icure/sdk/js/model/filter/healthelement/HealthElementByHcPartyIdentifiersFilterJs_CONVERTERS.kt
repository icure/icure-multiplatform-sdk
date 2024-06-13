package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun healthElementByHcPartyIdentifiersFilter_toJs(obj: HealthElementByHcPartyIdentifiersFilter):
		HealthElementByHcPartyIdentifiersFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val hcPartyId = nullToUndefined(
		obj.hcPartyId
	)
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	return HealthElementByHcPartyIdentifiersFilterJs(js("{" +
		"desc:desc," +
		"hcPartyId:hcPartyId," +
		"identifiers:identifiers" +
	"}"))
}

public
		fun healthElementByHcPartyIdentifiersFilter_fromJs(obj: HealthElementByHcPartyIdentifiersFilterJs):
		HealthElementByHcPartyIdentifiersFilter {
	val desc = undefinedToNull(obj.desc)
	val hcPartyId = undefinedToNull(obj.hcPartyId)
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	return HealthElementByHcPartyIdentifiersFilter(
		desc = desc,
		hcPartyId = hcPartyId,
		identifiers = identifiers,
	)
}
