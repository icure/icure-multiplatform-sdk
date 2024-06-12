package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.MessageReadStatus

public fun messageReadStatus_toJs(obj: MessageReadStatus): MessageReadStatusJs {
	val time = longToNumber(obj.time)
	val read = obj.read
	return MessageReadStatusJs(js("{" +
		"time:time," +
		"read:read" +
	"}"))
}

public fun messageReadStatus_fromJs(obj: MessageReadStatusJs): MessageReadStatus {
	val time = numberToLong(obj.time, "obj.time")
	val read = obj.read
	return MessageReadStatus(
		time = time,
		read = read,
	)
}
