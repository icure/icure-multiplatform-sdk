// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.DeviceApi
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
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
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
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
public class DeviceApiImplJs private constructor(
	private val deviceApi: DeviceApi,
) : DeviceApiJs {
	override fun getDevice(deviceId: String): Promise<DeviceJs> = GlobalScope.promise {
		device_toJs(deviceApi.getDevice(deviceId))}


	override fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>> = GlobalScope.promise {
		listToArray(
			deviceApi.getDevices(arrayToList(
				deviceIds,
				"deviceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: Device ->
				device_toJs(x1)
			},
		)}


	override fun createDevice(p: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		device_toJs(deviceApi.createDevice(com.icure.sdk.js.model.device_fromJs(p)))}


	override fun updateDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		device_toJs(deviceApi.updateDevice(com.icure.sdk.js.model.device_fromJs(device)))}


	override fun createDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			deviceApi.createDevices(arrayToList(
				devices,
				"devices",
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun updateDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			deviceApi.updateDevices(arrayToList(
				devices,
				"devices",
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun filterDevicesBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<DeviceJs>,
	): Promise<PaginatedListJs<DeviceJs>> = GlobalScope.promise {
		paginatedList_toJs(
			deviceApi.filterDevicesBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.DeviceJs ->
			    com.icure.sdk.js.model.device_fromJs(x1)
			  },
			)),
			{ x1: Device ->
				device_toJs(x1)
			},
		)}


	override fun matchDevicesBy(filter: AbstractFilterJs<DeviceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			deviceApi.matchDevicesBy(abstractFilter_fromJs(
				filter,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteDevice(deviceId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(deviceApi.deleteDevice(deviceId))}


	override fun deleteDevices(deviceIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			deviceApi.deleteDevices(arrayToList(
				deviceIds,
				"deviceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getDevicesInGroup(groupId: String, deviceIds: Array<String>?):
			Promise<Array<DeviceJs>> = GlobalScope.promise {
		listToArray(
			deviceApi.getDevicesInGroup(groupId, arrayToList(
				deviceIds,
				"deviceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: Device ->
				device_toJs(x1)
			},
		)}


	override fun modifyDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs> =
			GlobalScope.promise {
		device_toJs(deviceApi.modifyDeviceInGroup(groupId, com.icure.sdk.js.model.device_fromJs(device)))}


	override fun createDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs> =
			GlobalScope.promise {
		device_toJs(deviceApi.createDeviceInGroup(groupId, com.icure.sdk.js.model.device_fromJs(device)))}


	override fun deleteDevicesInGroup(groupId: String, deviceIds: String):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			deviceApi.deleteDevicesInGroup(groupId, deviceIds),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}

}
