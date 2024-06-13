package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyHealthElementIdsFilter_toJs(obj: ServiceByHcPartyHealthElementIdsFilter):
		ServiceByHcPartyHealthElementIdsFilterJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
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
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
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
