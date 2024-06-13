package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.Suspension
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun suspension_toJs(obj: Suspension): SuspensionJs {
	val beginMoment = longToNumber(obj.beginMoment)
	val endMoment = longToNumber(obj.endMoment)
	val suspensionReason = obj.suspensionReason
	val lifecycle = obj.lifecycle
	return SuspensionJs(js("{" +
		"beginMoment:beginMoment," +
		"endMoment:endMoment," +
		"suspensionReason:suspensionReason," +
		"lifecycle:lifecycle" +
	"}"))
}

public fun suspension_fromJs(obj: SuspensionJs): Suspension {
	val beginMoment = numberToLong(obj.beginMoment, "obj.beginMoment")
	val endMoment = numberToLong(obj.endMoment, "obj.endMoment")
	val suspensionReason = obj.suspensionReason
	val lifecycle = obj.lifecycle
	return Suspension(
		beginMoment = beginMoment,
		endMoment = endMoment,
		suspensionReason = suspensionReason,
		lifecycle = lifecycle,
	)
}
