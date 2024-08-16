// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.filters.FilterOptionsJs
import com.icure.sdk.js.filters.SortableFilterOptionsJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskFlavouredApi")
public external interface MaintenanceTaskFlavouredApiJs<E : MaintenanceTaskJs> {
	public fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		options: dynamic,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(maintenanceTask: E,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(maintenanceTask: E,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<E>

	public fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun modifyMaintenanceTask(entity: E): Promise<E>

	public fun getMaintenanceTask(entityId: String): Promise<E>

	public fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<E>>
}
