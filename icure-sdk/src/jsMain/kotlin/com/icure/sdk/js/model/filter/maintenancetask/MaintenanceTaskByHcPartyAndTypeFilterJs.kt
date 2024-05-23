// auto-generated file
package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("MaintenanceTaskByHcPartyAndTypeFilter")
public external class MaintenanceTaskByHcPartyAndTypeFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MaintenanceTaskJs> {
	override val desc: String?

	public val type: String

	public val healthcarePartyId: String?

	override val ktClass: String
}
