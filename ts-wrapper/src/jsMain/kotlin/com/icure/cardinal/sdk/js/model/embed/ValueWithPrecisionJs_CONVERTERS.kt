// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.embed.ValueWithPrecision
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun valueWithPrecision_toJs(obj: ValueWithPrecision): ValueWithPrecisionJs {
	val value = intToNumber(obj.value)
	val precision = intToNumber(obj.precision)
	return ValueWithPrecisionJs(js("{" +
		"value:value," +
		"precision:precision" +
	"}"))
}

public fun valueWithPrecision_fromJs(obj: ValueWithPrecisionJs): ValueWithPrecision {
	val value = numberToInt(obj.value, "obj.value")
	val precision = numberToInt(obj.precision, "obj.precision")
	return ValueWithPrecision(
		value = value,
		precision = precision,
	)
}
