// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.MaintenanceTaskBasicApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.MaintenanceTaskBasicApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.maintenanceTask_fromJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class MaintenanceTaskBasicApiImplJs(
	private val maintenanceTaskBasicApi: MaintenanceTaskBasicApi,
) : MaintenanceTaskBasicApiJs {
	override fun matchMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.matchMaintenanceTasksBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MaintenanceTask> =
				baseSortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.matchMaintenanceTasksBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterMaintenanceTasksBy(filter: BaseFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.filterMaintenanceTasksBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override
			fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MaintenanceTask> =
				baseSortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskBasicApi.filterMaintenanceTasksBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskBasicApi.deleteMaintenanceTask(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskBasicApi.deleteMaintenanceTasks(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
			Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskBasicApi.modifyMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskBasicApi.getMaintenanceTask(
			entityIdConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskBasicApi.getMaintenanceTasks(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<MaintenanceTask> = baseFilterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = maintenanceTaskBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}
}
