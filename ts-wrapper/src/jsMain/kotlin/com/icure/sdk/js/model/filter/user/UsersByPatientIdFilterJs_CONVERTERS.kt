package com.icure.sdk.js.model.filter.user

import com.icure.sdk.model.filter.user.UsersByPatientIdFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun usersByPatientIdFilter_toJs(obj: UsersByPatientIdFilter): UsersByPatientIdFilterJs {
	val patientId = obj.patientId
	val desc = obj.desc ?: undefined
	return UsersByPatientIdFilterJs(js("{" +
		"patientId:patientId," +
		"desc:desc" +
	"}"))
}

public fun usersByPatientIdFilter_fromJs(obj: UsersByPatientIdFilterJs): UsersByPatientIdFilter {
	val patientId = obj.patientId
	val desc = obj.desc
	return UsersByPatientIdFilter(
		patientId = patientId,
		desc = desc,
	)
}
