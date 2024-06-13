package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementByIdsFilter_toJs(obj: HealthElementByIdsFilter):
		HealthElementByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc ?: undefined
	return HealthElementByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun healthElementByIdsFilter_fromJs(obj: HealthElementByIdsFilterJs):
		HealthElementByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return HealthElementByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
