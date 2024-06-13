package com.icure.sdk.js.model.filter.topic

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun topicByHcPartyFilter_toJs(obj: TopicByHcPartyFilter): TopicByHcPartyFilterJs {
	val hcpId = obj.hcpId
	val desc = nullToUndefined(
		obj.desc
	)
	return TopicByHcPartyFilterJs(js("{" +
		"hcpId:hcpId," +
		"desc:desc" +
	"}"))
}

public fun topicByHcPartyFilter_fromJs(obj: TopicByHcPartyFilterJs): TopicByHcPartyFilter {
	val hcpId = obj.hcpId
	val desc = undefinedToNull(obj.desc)
	return TopicByHcPartyFilter(
		hcpId = hcpId,
		desc = desc,
	)
}
