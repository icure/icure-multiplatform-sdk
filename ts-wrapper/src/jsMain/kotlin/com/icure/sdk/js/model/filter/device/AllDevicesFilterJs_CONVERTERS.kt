package com.icure.sdk.js.model.filter.device

import com.icure.sdk.model.filter.device.AllDevicesFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allDevicesFilter_toJs(obj: AllDevicesFilter): AllDevicesFilterJs {
	val desc = obj.desc ?: undefined
	return AllDevicesFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allDevicesFilter_fromJs(obj: AllDevicesFilterJs): AllDevicesFilter {
	val desc = obj.desc
	return AllDevicesFilter(
		desc = desc,
	)
}
