package com.icure.sdk.js.model.filter.device

import com.icure.sdk.model.filter.device.DeviceByHcPartyFilter

public fun deviceByHcPartyFilter_toJs(obj: DeviceByHcPartyFilter): DeviceByHcPartyFilterJs {
	val desc = obj.desc
	val responsibleId = obj.responsibleId
	return DeviceByHcPartyFilterJs(js("{" +
		"desc:desc," +
		"responsibleId:responsibleId" +
	"}"))
}

public fun deviceByHcPartyFilter_fromJs(obj: DeviceByHcPartyFilterJs): DeviceByHcPartyFilter {
	val desc = obj.desc
	val responsibleId = obj.responsibleId
	return DeviceByHcPartyFilter(
		desc = desc,
		responsibleId = responsibleId,
	)
}
