// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.model.embed.MessageReadStatus
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun messageReadStatus_toJs(obj: MessageReadStatus): MessageReadStatusJs {
	val time = nullToUndefined(
		longToNumber(obj.time)
	)
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
