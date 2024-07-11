// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
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

	public fun modifyMaintenanceTask(entity: E): Promise<E>

	public fun getMaintenanceTask(entityId: String): Promise<E>

	public fun filterMaintenanceTasksBy(filterChain: FilterChainJs<MaintenanceTaskJs>,
			options: dynamic): Promise<PaginatedListJs<E>>
}
