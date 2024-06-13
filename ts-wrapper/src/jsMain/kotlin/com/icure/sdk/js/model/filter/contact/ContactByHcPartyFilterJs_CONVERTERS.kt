package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactByHcPartyFilter_toJs(obj: ContactByHcPartyFilter): ContactByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return ContactByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun contactByHcPartyFilter_fromJs(obj: ContactByHcPartyFilterJs): ContactByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return ContactByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}
