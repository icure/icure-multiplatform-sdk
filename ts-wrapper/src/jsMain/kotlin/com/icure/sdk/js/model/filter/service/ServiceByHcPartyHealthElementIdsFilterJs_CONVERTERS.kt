package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyHealthElementIdsFilter_toJs(obj: ServiceByHcPartyHealthElementIdsFilter):
		ServiceByHcPartyHealthElementIdsFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val healthElementIds = listToArray(
		obj.healthElementIds,
		{ x1: String ->
			x1
		},
	)
	return ServiceByHcPartyHealthElementIdsFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"healthElementIds:healthElementIds" +
	"}"))
}

public
		fun serviceByHcPartyHealthElementIdsFilter_fromJs(obj: ServiceByHcPartyHealthElementIdsFilterJs):
		ServiceByHcPartyHealthElementIdsFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val healthElementIds = arrayToList(
		obj.healthElementIds,
		"obj.healthElementIds",
		{ x1: String ->
			x1
		},
	)
	return ServiceByHcPartyHealthElementIdsFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		healthElementIds = healthElementIds,
	)
}
