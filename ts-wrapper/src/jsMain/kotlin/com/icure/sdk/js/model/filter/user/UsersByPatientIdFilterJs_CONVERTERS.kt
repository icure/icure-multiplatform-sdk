package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.user.UsersByPatientIdFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun usersByPatientIdFilter_toJs(obj: UsersByPatientIdFilter): UsersByPatientIdFilterJs {
	val patientId = obj.patientId
	val desc = nullToUndefined(
		obj.desc
	)
	return UsersByPatientIdFilterJs(js("{" +
		"patientId:patientId," +
		"desc:desc" +
	"}"))
}

public fun usersByPatientIdFilter_fromJs(obj: UsersByPatientIdFilterJs): UsersByPatientIdFilter {
	val patientId = obj.patientId
	val desc = undefinedToNull(obj.desc)
	return UsersByPatientIdFilter(
		patientId = patientId,
		desc = desc,
	)
}
