// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.DeviceApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.DeviceApi_filterDevicesBy_Options
import com.icure.sdk.js.api.DeviceApi_getDevicesInGroup_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.DeviceJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.device_fromJs
import com.icure.sdk.js.model.device_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import kotlin.Array
import kotlin.Int
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

	override fun filterDevicesBy(filterChain: FilterChainJs<DeviceJs>,
			options: DeviceApi_filterDevicesBy_Options?): Promise<PaginatedListJs<DeviceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<Device> = filterChain_fromJs(
				filterChain,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			val result = deviceApi.filterDevicesBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}
	}

	override fun matchDevicesBy(filter: AbstractFilterJs<DeviceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Device> = abstractFilter_fromJs(
			filter,
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
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

	override fun getDevicesInGroup(groupId: String, options: DeviceApi_getDevicesInGroup_Options?):
			Promise<Array<DeviceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val deviceIdsConverted: List<String>? = convertingOptionOrDefault(
				_options.deviceIds,
				null
			) { deviceIds ->
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
