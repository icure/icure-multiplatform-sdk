package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementByHcPartyFilter_toJs(obj: HealthElementByHcPartyFilter):
		HealthElementByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return HealthElementByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun healthElementByHcPartyFilter_fromJs(obj: HealthElementByHcPartyFilterJs):
		HealthElementByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return HealthElementByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}
