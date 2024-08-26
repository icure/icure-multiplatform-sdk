// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskBasicApi")
public external interface MaintenanceTaskBasicApiJs {
	public fun matchMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>>

	public fun filterMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>>

	public fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>>

	public fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
			Promise<EncryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs>

	public fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<EncryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>>
}
