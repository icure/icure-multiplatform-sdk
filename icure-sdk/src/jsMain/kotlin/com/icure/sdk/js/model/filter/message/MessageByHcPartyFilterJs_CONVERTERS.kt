package com.icure.sdk.js.model.filter.message

import com.icure.sdk.model.filter.message.MessageByHcPartyFilter

public fun messageByHcPartyFilter_toJs(obj: MessageByHcPartyFilter): MessageByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return MessageByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun messageByHcPartyFilter_fromJs(obj: MessageByHcPartyFilterJs): MessageByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = obj.desc
	return MessageByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}