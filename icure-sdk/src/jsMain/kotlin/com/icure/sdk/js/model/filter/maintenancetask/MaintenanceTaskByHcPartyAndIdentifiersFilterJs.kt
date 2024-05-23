// auto-generated file
package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("MaintenanceTaskByHcPartyAndIdentifiersFilter")
public external class MaintenanceTaskByHcPartyAndIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MaintenanceTaskJs> {
	public val healthcarePartyId: String?

	public val identifiers: Array<IdentifierJs>

	override val desc: String?

	override val ktClass: String
}
