// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.embed.Renewal
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun renewal_toJs(obj: Renewal): RenewalJs {
	val decimal = nullToUndefined(
		intToNumber(obj.decimal)
	)
	val duration = nullToUndefined(
		obj.duration?.let { nonNull1 ->
			duration_toJs(nonNull1)
		}
	)
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
