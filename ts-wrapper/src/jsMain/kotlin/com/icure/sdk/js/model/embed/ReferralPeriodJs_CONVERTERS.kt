package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.sdk.model.embed.ReferralPeriod
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun referralPeriod_toJs(obj: ReferralPeriod): ReferralPeriodJs {
	val startDate = instantToNumber(obj.startDate) ?: undefined
	val endDate = instantToNumber(obj.endDate) ?: undefined
	val comment = obj.comment ?: undefined
	return ReferralPeriodJs(js("{" +
		"startDate:startDate," +
		"endDate:endDate," +
		"comment:comment" +
	"}"))
}

public fun referralPeriod_fromJs(obj: ReferralPeriodJs): ReferralPeriod {
	val startDate = numberToInstant(obj.startDate, "obj.startDate")
	val endDate = numberToInstant(obj.endDate, "obj.endDate")
	val comment = obj.comment
	return ReferralPeriod(
		startDate = startDate,
		endDate = endDate,
		comment = comment,
	)
}
