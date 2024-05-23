// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.DeviceJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("DeviceApi")
public external interface DeviceApiJs {
	public fun getDevice(deviceId: String): Promise<DeviceJs>

	public fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>>

	public fun createDevice(p: DeviceJs): Promise<DeviceJs>

	public fun updateDevice(device: DeviceJs): Promise<DeviceJs>

	public fun createDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>>

	public fun updateDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>>

	public fun filterDevicesBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<DeviceJs>,
	): Promise<PaginatedListJs<DeviceJs>>

	public fun matchDevicesBy(filter: AbstractFilterJs<DeviceJs>): Promise<Array<String>>

	public fun deleteDevice(deviceId: String): Promise<DocIdentifierJs>

	public fun deleteDevices(deviceIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getDevicesInGroup(groupId: String, deviceIds: Array<String>?): Promise<Array<DeviceJs>>

	public fun modifyDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun createDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun deleteDevicesInGroup(groupId: String, deviceIds: String):
			Promise<Array<DocIdentifierJs>>
}
