package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter

public fun maintenanceTaskByHcPartyAndTypeFilter_toJs(obj: MaintenanceTaskByHcPartyAndTypeFilter):
		MaintenanceTaskByHcPartyAndTypeFilterJs {
	val desc = obj.desc
	val type = obj.type
	val healthcarePartyId = obj.healthcarePartyId
	return MaintenanceTaskByHcPartyAndTypeFilterJs(js("{" +
		"desc:desc," +
		"type:type," +
		"healthcarePartyId:healthcarePartyId" +
	"}"))
}

public
		fun maintenanceTaskByHcPartyAndTypeFilter_fromJs(obj: MaintenanceTaskByHcPartyAndTypeFilterJs):
		MaintenanceTaskByHcPartyAndTypeFilter {
	val desc = obj.desc
	val type = obj.type
	val healthcarePartyId = obj.healthcarePartyId
	return MaintenanceTaskByHcPartyAndTypeFilter(
		desc = desc,
		type = type,
		healthcarePartyId = healthcarePartyId,
	)
}
