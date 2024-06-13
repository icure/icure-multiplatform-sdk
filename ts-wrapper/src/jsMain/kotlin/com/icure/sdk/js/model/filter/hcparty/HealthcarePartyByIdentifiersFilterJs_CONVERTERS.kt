package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyByIdentifiersFilter_toJs(obj: HealthcarePartyByIdentifiersFilter):
		HealthcarePartyByIdentifiersFilterJs {
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val desc = obj.desc
	return HealthcarePartyByIdentifiersFilterJs(js("{" +
		"identifiers:identifiers," +
		"desc:desc" +
	"}"))
}

public fun healthcarePartyByIdentifiersFilter_fromJs(obj: HealthcarePartyByIdentifiersFilterJs):
		HealthcarePartyByIdentifiersFilter {
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val desc = obj.desc
	return HealthcarePartyByIdentifiersFilter(
		identifiers = identifiers,
		desc = desc,
	)
}
