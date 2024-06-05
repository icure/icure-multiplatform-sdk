package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import kotlin.String

public fun maintenanceTaskByIdsFilter_toJs(obj: MaintenanceTaskByIdsFilter):
		MaintenanceTaskByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return MaintenanceTaskByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun maintenanceTaskByIdsFilter_fromJs(obj: MaintenanceTaskByIdsFilterJs):
		MaintenanceTaskByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return MaintenanceTaskByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
