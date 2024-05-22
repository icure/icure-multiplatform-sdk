package com.icure.sdk.js.model

import com.icure.sdk.model.TopicRole
import kotlin.String

public fun topicRole_toJs(obj: TopicRole): String = obj.name

public fun topicRole_fromJs(obj: String): TopicRole = when (obj) {
	"Participant" -> TopicRole.Participant
	"Admin" -> TopicRole.Admin
	"Owner" -> TopicRole.Owner
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.TopicRole: $obj""")
}
