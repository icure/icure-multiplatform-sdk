package com.icure.sdk.js.model.filter.service

import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter

public fun serviceByHcPartyFilter_toJs(obj: ServiceByHcPartyFilter): ServiceByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return ServiceByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun serviceByHcPartyFilter_fromJs(obj: ServiceByHcPartyFilterJs): ServiceByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return ServiceByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}
