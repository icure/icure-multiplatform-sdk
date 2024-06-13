package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.ReplicationInfo
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun replicationInfo_toJs(obj: ReplicationInfo): ReplicationInfoJs {
	val active = obj.active
	val running = obj.running
	val pendingFrom = intToNumber(obj.pendingFrom)
	val pendingTo = intToNumber(obj.pendingTo)
	return ReplicationInfoJs(js("{" +
		"active:active," +
		"running:running," +
		"pendingFrom:pendingFrom," +
		"pendingTo:pendingTo" +
	"}"))
}

public fun replicationInfo_fromJs(obj: ReplicationInfoJs): ReplicationInfo {
	val active = obj.active
	val running = obj.running
	val pendingFrom = numberToInt(obj.pendingFrom, "obj.pendingFrom")
	val pendingTo = numberToInt(obj.pendingTo, "obj.pendingTo")
	return ReplicationInfo(
		active = active,
		running = running,
		pendingFrom = pendingFrom,
		pendingTo = pendingTo,
	)
}
