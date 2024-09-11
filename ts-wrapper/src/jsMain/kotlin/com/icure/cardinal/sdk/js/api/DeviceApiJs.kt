// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DeviceApi")
public external interface DeviceApiJs {
	public fun getDevice(deviceId: String): Promise<DeviceJs>

	public fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>>

	public fun createDevice(p: DeviceJs): Promise<DeviceJs>

	public fun modifyDevice(device: DeviceJs): Promise<DeviceJs>

	public fun createDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>>

	public fun modifyDevices(devices: Array<DeviceJs>): Promise<Array<IdWithRevJs>>

	public fun filterDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>>

	public fun filterDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>>

	public fun matchDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>): Promise<Array<String>>

	public fun matchDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<Array<String>>

	public fun deleteDevice(deviceId: String): Promise<DocIdentifierJs>

	public fun deleteDevices(deviceIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getDevicesInGroup(groupId: String, options: dynamic): Promise<Array<DeviceJs>>

	public fun modifyDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun createDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun deleteDevicesInGroup(groupId: String, deviceIds: String):
			Promise<Array<DocIdentifierJs>>
}
