package com.icure.sdk.js.model.filter.device

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.device.DeviceByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun deviceByIdsFilter_toJs(obj: DeviceByIdsFilter): DeviceByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc ?: undefined
	return DeviceByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun deviceByIdsFilter_fromJs(obj: DeviceByIdsFilterJs): DeviceByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return DeviceByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
