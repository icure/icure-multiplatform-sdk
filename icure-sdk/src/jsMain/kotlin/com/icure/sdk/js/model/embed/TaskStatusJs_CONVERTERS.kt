package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.TaskStatus
import kotlin.String

public fun taskStatus_toJs(obj: TaskStatus): String = obj.name

public fun taskStatus_fromJs(obj: String): TaskStatus = when (obj) {
	"Pending" -> TaskStatus.Pending
	"Ongoing" -> TaskStatus.Ongoing
	"Cancelled" -> TaskStatus.Cancelled
	"Completed" -> TaskStatus.Completed
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.TaskStatus: $obj""")
}
