package com.icure.sdk.js.model.filter.message

import com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun latestMessageByHcPartyTransportGuidFilter_toJs(obj: LatestMessageByHcPartyTransportGuidFilter):
		LatestMessageByHcPartyTransportGuidFilterJs {
	val healthcarePartyId = obj.healthcarePartyId
	val transportGuid = obj.transportGuid
	val desc = obj.desc
	return LatestMessageByHcPartyTransportGuidFilterJs(js("{" +
		"healthcarePartyId:healthcarePartyId," +
		"transportGuid:transportGuid," +
		"desc:desc" +
	"}"))
}

public
		fun latestMessageByHcPartyTransportGuidFilter_fromJs(obj: LatestMessageByHcPartyTransportGuidFilterJs):
		LatestMessageByHcPartyTransportGuidFilter {
	val healthcarePartyId = obj.healthcarePartyId
	val transportGuid = obj.transportGuid
	val desc = obj.desc
	return LatestMessageByHcPartyTransportGuidFilter(
		healthcarePartyId = healthcarePartyId,
		transportGuid = transportGuid,
		desc = desc,
	)
}
