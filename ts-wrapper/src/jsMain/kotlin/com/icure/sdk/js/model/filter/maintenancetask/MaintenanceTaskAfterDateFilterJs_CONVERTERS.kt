package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter

public fun maintenanceTaskAfterDateFilter_toJs(obj: MaintenanceTaskAfterDateFilter):
		MaintenanceTaskAfterDateFilterJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val date = longToNumber(obj.date)
	return MaintenanceTaskAfterDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"date:date" +
	"}"))
}

public fun maintenanceTaskAfterDateFilter_fromJs(obj: MaintenanceTaskAfterDateFilterJs):
		MaintenanceTaskAfterDateFilter {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val date = numberToLong(obj.date, "obj.date")
	return MaintenanceTaskAfterDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		date = date,
	)
}
