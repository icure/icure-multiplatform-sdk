// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("MaintenanceTaskBasicApi")
public external interface MaintenanceTaskBasicApiJs {
	public fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
			Promise<EncryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<MaintenanceTaskJs>,
	): Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>>
}
