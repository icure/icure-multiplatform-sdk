// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DeviceApi")
public external interface DeviceApiJs {
	public fun deleteDeviceUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteDevicesUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getDevice(deviceId: String): Promise<DeviceJs?>

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

	public fun deleteDeviceById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeDeviceById(id: String, rev: String): Promise<Unit>

	public fun undeleteDeviceById(id: String, rev: String): Promise<DeviceJs>

	public fun deleteDevice(device: DeviceJs): Promise<DocIdentifierJs>

	public fun deleteDevices(devices: Array<DeviceJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeDevice(device: DeviceJs): Promise<Unit>

	public fun undeleteDevice(device: DeviceJs): Promise<DeviceJs>

	public fun getDevicesInGroup(groupId: String, options: dynamic): Promise<Array<DeviceJs>>

	public fun modifyDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun createDeviceInGroup(groupId: String, device: DeviceJs): Promise<DeviceJs>

	public fun deleteDevicesInGroup(groupId: String, deviceIds: Array<IdWithRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<DeviceJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<DeviceJs>>
}
