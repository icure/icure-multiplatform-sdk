package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun maintenanceTaskByIdsFilter_toJs(obj: MaintenanceTaskByIdsFilter):
		MaintenanceTaskByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = nullToUndefined(
		obj.desc
	)
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
	val desc = undefinedToNull(obj.desc)
	return MaintenanceTaskByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
