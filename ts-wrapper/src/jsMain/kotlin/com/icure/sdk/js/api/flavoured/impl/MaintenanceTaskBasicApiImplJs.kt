// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.MaintenanceTaskBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.maintenanceTask_fromJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class MaintenanceTaskBasicApiImplJs(
	private val maintenanceTaskBasicApi: MaintenanceTaskBasicApi,
) : MaintenanceTaskBasicApiJs {
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

	override fun filterMaintenanceTasksBy(filterChain: FilterChainJs<MaintenanceTaskJs>,
			options: dynamic): Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<MaintenanceTask> = filterChain_fromJs(
				filterChain,
				{ x1: MaintenanceTaskJs ->
					maintenanceTask_fromJs(x1)
				},
			)
			val result = maintenanceTaskBasicApi.filterMaintenanceTasksBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MaintenanceTaskJs>,
		eventFired: (EncryptedMaintenanceTaskJs) -> Promise<Unit>,
		options: dynamic,
	): Promise<ConnectionJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: AbstractFilter<MaintenanceTask> = abstractFilter_fromJs(
				filter,
				{ x1: MaintenanceTaskJs ->
					maintenanceTask_fromJs(x1)
				},
			)
			val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefaultNonNull(
				_options,
				"onConnected",
				{}
			) { onConnected: () -> Promise<Unit> ->
				{  ->
					onConnected().await()
				}
			}
			val channelCapacityConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"channelCapacity",
				kotlinx.coroutines.channels.Channel.BUFFERED
			) { channelCapacity: Double ->
				numberToInt(channelCapacity, "channelCapacity")
			}
			val retryDelayConverted: Duration = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelay",
				2.seconds
			) { retryDelay: Double ->
				numberToDuration(retryDelay, "retryDelay")
			}
			val retryDelayExponentFactorConverted: Double = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelayExponentFactor",
				2.0
			) { retryDelayExponentFactor: Double ->
				retryDelayExponentFactor
			}
			val maxRetriesConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"maxRetries",
				5
			) { maxRetries: Double ->
				numberToInt(maxRetries, "maxRetries")
			}
			val eventFiredConverted: suspend (EncryptedMaintenanceTask) -> Unit = { arg0 ->
				eventFired(
					maintenanceTask_toJs(arg0),
				).await()
			}
			val result = maintenanceTaskBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				onConnectedConverted,
				channelCapacityConverted,
				retryDelayConverted,
				retryDelayExponentFactorConverted,
				maxRetriesConverted,
				eventFiredConverted,
			)
			connection_toJs(result)
		}
	}
}
