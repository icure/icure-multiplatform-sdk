// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskBasicApi")
public external interface MaintenanceTaskBasicApiJs {
	public fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
			Promise<EncryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(filterChain: FilterChainJs<MaintenanceTaskJs>,
			options: dynamic): Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MaintenanceTaskJs>,
		eventFired: (EncryptedMaintenanceTaskJs) -> Promise<Unit>,
		options: dynamic,
	): Promise<ConnectionJs>
}
