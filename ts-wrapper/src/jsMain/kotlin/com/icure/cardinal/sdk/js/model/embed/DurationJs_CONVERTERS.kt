// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.embed.Duration
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun duration_toJs(obj: Duration): DurationJs {
	val value = nullToUndefined(
		obj.value
	)
	val unit = nullToUndefined(
		obj.unit?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	return DurationJs(js("{" +
		"value:value," +
		"unit:unit" +
	"}"))
}

public fun duration_fromJs(obj: DurationJs): Duration {
	val value = undefinedToNull(obj.value)
	val unit = obj.unit?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return Duration(
		value = value,
		unit = unit,
	)
}
