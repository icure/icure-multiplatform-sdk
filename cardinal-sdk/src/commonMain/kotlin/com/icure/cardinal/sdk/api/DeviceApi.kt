package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface DeviceApi {
	suspend fun getDevice(deviceId: String): Device
	suspend fun getDevices(deviceIds: List<String>): List<Device>
	suspend fun createDevice(p: Device): Device
	suspend fun modifyDevice(device: Device): Device
	suspend fun createDevices(devices: List<Device>): List<IdWithRev>
	suspend fun modifyDevices(devices: List<Device>): List<IdWithRev>

	suspend fun filterDevicesBy(
		filter: BaseFilterOptions<Device>
	): PaginatedListIterator<Device>

	suspend fun filterDevicesBySorted(
		filter: BaseSortableFilterOptions<Device>
	): PaginatedListIterator<Device>

	suspend fun matchDevicesBy(filter: BaseFilterOptions<Device>): List<String>
	suspend fun matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): List<String>
	suspend fun deleteDevice(deviceId: String): DocIdentifier
	suspend fun deleteDevices(deviceIds: List<String>): List<DocIdentifier>
	suspend fun getDevicesInGroup(
		groupId: String,
		@DefaultValue("null")
		deviceIds: List<String>? = null,
	): List<Device>

	suspend fun modifyDeviceInGroup(
		groupId: String,
		device: Device,
	): Device

	suspend fun createDeviceInGroup(
		groupId: String,
		device: Device,
	): Device

	suspend fun deleteDevicesInGroup(
		groupId: String,
		deviceIds: String,
	): List<DocIdentifier>
}

