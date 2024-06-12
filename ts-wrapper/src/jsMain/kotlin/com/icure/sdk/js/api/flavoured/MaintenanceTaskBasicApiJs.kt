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
import kotlin.Double
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
			options: MaintenanceTaskBasicApi_filterMaintenanceTasksBy_Options?):
			Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MaintenanceTaskJs>,
		eventFired: (EncryptedMaintenanceTaskJs) -> Promise<Unit>,
		options: MaintenanceTaskBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface MaintenanceTaskBasicApi_filterMaintenanceTasksBy_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface MaintenanceTaskBasicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
