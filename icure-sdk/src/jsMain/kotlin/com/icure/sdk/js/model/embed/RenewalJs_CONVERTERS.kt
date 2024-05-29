package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.embed.Renewal

public fun renewal_toJs(obj: Renewal): RenewalJs {
	val decimal = intToNumber(obj.decimal)
	val duration = obj.duration?.let { nonNull1 ->
		duration_toJs(nonNull1)
	}
	return RenewalJs(js("{" +
		"decimal:decimal," +
		"duration:duration" +
	"}"))
}

public fun renewal_fromJs(obj: RenewalJs): Renewal {
	val decimal = numberToInt(obj.decimal, "obj.decimal")
	val duration = obj.duration?.let { nonNull1 ->
		duration_fromJs(nonNull1)
	}
	return Renewal(
		decimal = decimal,
		duration = duration,
	)
}