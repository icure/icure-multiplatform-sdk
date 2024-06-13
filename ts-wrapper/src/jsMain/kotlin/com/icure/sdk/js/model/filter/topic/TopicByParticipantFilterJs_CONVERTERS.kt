package com.icure.sdk.js.model.filter.topic

import com.icure.sdk.model.filter.topic.TopicByParticipantFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun topicByParticipantFilter_toJs(obj: TopicByParticipantFilter):
		TopicByParticipantFilterJs {
	val participantId = obj.participantId
	val desc = obj.desc ?: undefined
	return TopicByParticipantFilterJs(js("{" +
		"participantId:participantId," +
		"desc:desc" +
	"}"))
}

public fun topicByParticipantFilter_fromJs(obj: TopicByParticipantFilterJs):
		TopicByParticipantFilter {
	val participantId = obj.participantId
	val desc = obj.desc
	return TopicByParticipantFilter(
		participantId = participantId,
		desc = desc,
	)
}
