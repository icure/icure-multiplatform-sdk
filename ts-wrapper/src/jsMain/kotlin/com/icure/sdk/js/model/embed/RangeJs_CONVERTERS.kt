// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.Range
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun range_toJs(obj: Range): RangeJs {
	val low = nullToUndefined(
		obj.low
	)
	val high = nullToUndefined(
		obj.high
	)
	return RangeJs(js("{" +
		"low:low," +
		"high:high" +
	"}"))
}

public fun range_fromJs(obj: RangeJs): Range {
	val low = undefinedToNull(obj.low)
	val high = undefinedToNull(obj.high)
	return Range(
		low = low,
		high = high,
	)
}
