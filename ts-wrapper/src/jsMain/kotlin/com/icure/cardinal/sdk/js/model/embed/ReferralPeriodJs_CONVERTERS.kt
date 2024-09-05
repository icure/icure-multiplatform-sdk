// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.ReferralPeriod
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun referralPeriod_toJs(obj: ReferralPeriod): ReferralPeriodJs {
	val startDate = nullToUndefined(
		instantToNumber(obj.startDate)
	)
	val endDate = nullToUndefined(
		instantToNumber(obj.endDate)
	)
	val comment = nullToUndefined(
		obj.comment
	)
	return ReferralPeriodJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"comment:comment" +
	"}"))
}

public fun referralPeriod_fromJs(obj: ReferralPeriodJs): ReferralPeriod {
	val startDate = numberToInstant(obj.startDate, "obj.startDate")
	val endDate = numberToInstant(obj.endDate, "obj.endDate")
	val comment = undefinedToNull(obj.comment)
	return ReferralPeriod(
		startDate = startDate,
		endDate = endDate,
		comment = comment,
	)
}
