package com.icure.sdk.js.model.filter.topic

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.topic.TopicByParticipantFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun topicByParticipantFilter_toJs(obj: TopicByParticipantFilter):
		TopicByParticipantFilterJs {
	val participantId = obj.participantId
	val desc = nullToUndefined(
		obj.desc
	)
	return TopicByParticipantFilterJs(js("{" +
		"participantId:participantId," +
		"desc:desc" +
	"}"))
}

public fun topicByParticipantFilter_fromJs(obj: TopicByParticipantFilterJs):
		TopicByParticipantFilter {
	val participantId = obj.participantId
	val desc = undefinedToNull(obj.desc)
	return TopicByParticipantFilter(
		participantId = participantId,
		desc = desc,
	)
}
