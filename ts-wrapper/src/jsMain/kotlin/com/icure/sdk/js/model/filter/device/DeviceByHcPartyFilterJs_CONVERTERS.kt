package com.icure.sdk.js.model.filter.device

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.device.DeviceByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun deviceByHcPartyFilter_toJs(obj: DeviceByHcPartyFilter): DeviceByHcPartyFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val responsibleId = nullToUndefined(
		obj.responsibleId
	)
	return DeviceByHcPartyFilterJs(js("{" +
		"desc:desc," +
		"responsibleId:responsibleId" +
	"}"))
}

public fun deviceByHcPartyFilter_fromJs(obj: DeviceByHcPartyFilterJs): DeviceByHcPartyFilter {
	val desc = undefinedToNull(obj.desc)
	val responsibleId = undefinedToNull(obj.responsibleId)
	return DeviceByHcPartyFilter(
		desc = desc,
		responsibleId = responsibleId,
	)
}
