// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.DeviceApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.device_fromJs
import com.icure.cardinal.sdk.js.model.device_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.idWithRev_fromJs
import com.icure.cardinal.sdk.js.model.idWithRev_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DeviceApiImplJs(
	private val deviceApi: DeviceApi,
) : DeviceApiJs {
	override fun deleteDeviceUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = deviceApi.deleteDeviceUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDevicesUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = deviceApi.deleteDevicesUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getDevice(deviceId: String): Promise<DeviceJs> = GlobalScope.promise {
		val deviceIdConverted: String = deviceId
		val result = deviceApi.getDevice(
			deviceIdConverted,
		)
		device_toJs(result)
	}

	override fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>> = GlobalScope.promise {
		val deviceIdsConverted: List<String> = arrayToList(
			deviceIds,
			"deviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = deviceApi.getDevices(
			deviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun createDevice(p: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val pConverted: Device = device_fromJs(p)
		val result = deviceApi.createDevice(
			pConverted,
		)
		device_toJs(result)
	}

	override fun modifyDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.modifyDevice(
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun createDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.createDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun modifyDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.modifyDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun filterDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
		val result = deviceApi.filterDevicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun filterDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
		val result = deviceApi.filterDevicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun matchDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
		val result = deviceApi.matchDevicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
		val result = deviceApi.matchDevicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteDeviceById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = deviceApi.deleteDeviceById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDevicesByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = deviceApi.deleteDevicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDeviceById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		deviceApi.purgeDeviceById(
			idConverted,
			revConverted,
		)

	}

	override fun undeleteDeviceById(id: String, rev: String): Promise<DeviceJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = deviceApi.undeleteDeviceById(
			idConverted,
			revConverted,
		)
		device_toJs(result)
	}

	override fun deleteDevice(device: DeviceJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.deleteDevice(
			deviceConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDevices(devices: Array<DeviceJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.deleteDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDevice(device: DeviceJs): Promise<Unit> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		deviceApi.purgeDevice(
			deviceConverted,
		)

	}

	override fun undeleteDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.undeleteDevice(
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun getDevicesInGroup(groupId: String, options: dynamic): Promise<Array<DeviceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val deviceIdsConverted: List<String>? = convertingOptionOrDefaultNullable(
				_options,
				"deviceIds",
				null
			) { deviceIds: Array<String>? ->
				arrayToList(
					deviceIds,
					"deviceIds",
					{ x1: String ->
						x1
					},
				)
			}
			val result = deviceApi.getDevicesInGroup(
				groupIdConverted,
				deviceIdsConverted,
			)
			listToArray(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}
	}

	override fun modifyDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.modifyDeviceInGroup(
			groupIdConverted,
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun createDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.createDeviceInGroup(
			groupIdConverted,
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun deleteDevicesInGroup(groupId: String, deviceIds: Array<IdWithRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceIdsConverted: List<IdWithRev> = arrayToList(
			deviceIds,
			"deviceIds",
			{ x1: IdWithRevJs ->
				idWithRev_fromJs(x1)
			},
		)
		val result = deviceApi.deleteDevicesInGroup(
			groupIdConverted,
			deviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<DeviceJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<DeviceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<Device> = filterOptions_fromJs(filter)
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
			val result = deviceApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}
	}
}
