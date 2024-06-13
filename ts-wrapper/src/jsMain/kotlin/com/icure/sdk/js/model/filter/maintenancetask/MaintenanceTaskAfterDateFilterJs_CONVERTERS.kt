package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun maintenanceTaskAfterDateFilter_toJs(obj: MaintenanceTaskAfterDateFilter):
		MaintenanceTaskAfterDateFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val date = longToNumber(obj.date)
	return MaintenanceTaskAfterDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"date:date" +
	"}"))
}

public fun maintenanceTaskAfterDateFilter_fromJs(obj: MaintenanceTaskAfterDateFilterJs):
		MaintenanceTaskAfterDateFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val date = numberToLong(obj.date, "obj.date")
	return MaintenanceTaskAfterDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		date = date,
	)
}
