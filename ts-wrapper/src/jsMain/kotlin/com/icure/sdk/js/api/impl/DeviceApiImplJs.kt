// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.DeviceApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DeviceJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.device_fromJs
import com.icure.sdk.js.model.device_toJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DeviceApiImplJs(
	private val deviceApi: DeviceApi,
) : DeviceApiJs {
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

	override fun updateDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.updateDevice(
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

	override fun updateDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.updateDevices(
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

	override fun deleteDevice(deviceId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val deviceIdConverted: String = deviceId
		val result = deviceApi.deleteDevice(
			deviceIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteDevices(deviceIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val deviceIdsConverted: List<String> = arrayToList(
			deviceIds,
			"deviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = deviceApi.deleteDevices(
			deviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
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

	override fun deleteDevicesInGroup(groupId: String, deviceIds: String):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceIdsConverted: String = deviceIds
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
}
