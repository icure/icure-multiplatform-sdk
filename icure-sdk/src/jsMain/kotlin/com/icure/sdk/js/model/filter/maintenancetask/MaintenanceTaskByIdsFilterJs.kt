// auto-generated file
package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("MaintenanceTaskByIdsFilter")
public external class MaintenanceTaskByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MaintenanceTaskJs>, FilterJs_IdsFilterJs<String, MaintenanceTaskJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
