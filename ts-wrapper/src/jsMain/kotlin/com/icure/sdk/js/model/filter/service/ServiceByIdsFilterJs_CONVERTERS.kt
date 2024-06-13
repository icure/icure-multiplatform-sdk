package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.service.ServiceByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByIdsFilter_toJs(obj: ServiceByIdsFilter): ServiceByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc ?: undefined
	return ServiceByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun serviceByIdsFilter_fromJs(obj: ServiceByIdsFilterJs): ServiceByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return ServiceByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
