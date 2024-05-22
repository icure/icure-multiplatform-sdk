// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApi
import com.icure.sdk.js.api.flavoured.MaintenanceTaskBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class MaintenanceTaskBasicApiImplJs private constructor(
	private val maintenanceTaskBasicApi: MaintenanceTaskBasicApi,
) : MaintenanceTaskBasicApiJs {
	override fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(maintenanceTaskBasicApi.deleteMaintenanceTask(entityId))}


	override fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			maintenanceTaskBasicApi.deleteMaintenanceTasks(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
			Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskBasicApi.modifyMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


	override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskBasicApi.getMaintenanceTask(entityId))}


	override fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<MaintenanceTaskJs>,
	): Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		paginatedList_toJs(
			maintenanceTaskBasicApi.filterMaintenanceTasksBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
			    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
			  },
			)),
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)}

}
