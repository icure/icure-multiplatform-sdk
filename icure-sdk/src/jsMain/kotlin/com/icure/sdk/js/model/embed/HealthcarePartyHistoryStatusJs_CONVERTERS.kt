package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.HealthcarePartyHistoryStatus

public fun healthcarePartyHistoryStatus_toJs(obj: HealthcarePartyHistoryStatus):
		HealthcarePartyHistoryStatusJs {
	val status = healthcarePartyStatus_toJs(obj.status)
	val specialisationCode = obj.specialisationCode
	val startDate = longToNumber(obj.startDate)
	val active = obj.active
	return HealthcarePartyHistoryStatusJs(js("{" +
		"status:status," +
		"specialisationCode:specialisationCode," +
		"startDate:startDate," +
		"active:active" +
	"}"))
}

public fun healthcarePartyHistoryStatus_fromJs(obj: HealthcarePartyHistoryStatusJs):
		HealthcarePartyHistoryStatus {
	val status = healthcarePartyStatus_fromJs(obj.status)
	val specialisationCode = obj.specialisationCode
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val active = obj.active
	return HealthcarePartyHistoryStatus(
		status = status,
		specialisationCode = specialisationCode,
		startDate = startDate,
		active = active,
	)
}
