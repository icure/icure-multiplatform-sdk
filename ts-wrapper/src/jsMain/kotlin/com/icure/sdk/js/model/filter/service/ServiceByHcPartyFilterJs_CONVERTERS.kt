package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyFilter_toJs(obj: ServiceByHcPartyFilter): ServiceByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = nullToUndefined(
		obj.desc
	)
	return ServiceByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun serviceByHcPartyFilter_fromJs(obj: ServiceByHcPartyFilterJs): ServiceByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = undefinedToNull(obj.desc)
	return ServiceByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}
