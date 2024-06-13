package com.icure.sdk.js.model.filter.message

import com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun messageByHcPartyTransportGuidFilter_toJs(obj: MessageByHcPartyTransportGuidFilter):
		MessageByHcPartyTransportGuidFilterJs {
	val healthcarePartyId = obj.healthcarePartyId
	val transportGuid = obj.transportGuid
	val desc = obj.desc
	return MessageByHcPartyTransportGuidFilterJs(js("{" +
		"healthcarePartyId:healthcarePartyId," +
		"transportGuid:transportGuid," +
		"desc:desc" +
	"}"))
}

public fun messageByHcPartyTransportGuidFilter_fromJs(obj: MessageByHcPartyTransportGuidFilterJs):
		MessageByHcPartyTransportGuidFilter {
	val healthcarePartyId = obj.healthcarePartyId
	val transportGuid = obj.transportGuid
	val desc = obj.desc
	return MessageByHcPartyTransportGuidFilter(
		healthcarePartyId = healthcarePartyId,
		transportGuid = transportGuid,
		desc = desc,
	)
}
