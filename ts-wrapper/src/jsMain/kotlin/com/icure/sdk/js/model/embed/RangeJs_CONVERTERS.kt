package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.Range
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun range_toJs(obj: Range): RangeJs {
	val low = obj.low ?: undefined
	val high = obj.high ?: undefined
	return RangeJs(js("{" +
		"low:low," +
		"high:high" +
	"}"))
}

public fun range_fromJs(obj: RangeJs): Range {
	val low = obj.low
	val high = obj.high
	return Range(
		low = low,
		high = high,
	)
}
