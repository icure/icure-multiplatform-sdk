package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun maintenanceTaskByHcPartyAndTypeFilter_toJs(obj: MaintenanceTaskByHcPartyAndTypeFilter):
		MaintenanceTaskByHcPartyAndTypeFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val type = obj.type
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	return MaintenanceTaskByHcPartyAndTypeFilterJs(js("{" +
		"desc:desc," +
		"type:type," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public
		fun maintenanceTaskByHcPartyAndTypeFilter_fromJs(obj: MaintenanceTaskByHcPartyAndTypeFilterJs):
		MaintenanceTaskByHcPartyAndTypeFilter {
	val desc = undefinedToNull(obj.desc)
	val type = obj.type
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	return MaintenanceTaskByHcPartyAndTypeFilter(
		desc = desc,
		type = type,
		healthcarePartyId = healthcarePartyId,
	)
}
