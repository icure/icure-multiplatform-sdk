package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.Duration

public fun duration_toJs(obj: Duration): DurationJs {
	val value = obj.value
	val unit = obj.unit?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	return DurationJs(js("{" +
		"value:value," +
		"unit:unit" +
	"}"))
}

public fun duration_fromJs(obj: DurationJs): Duration {
	val value = obj.value
	val unit = obj.unit?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return Duration(
		value = value,
		unit = unit,
	)
}
