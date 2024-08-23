package com.icure.sdk.api

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.pagination.PaginatedListIterator

interface DeviceApi {
	suspend fun getDevice(deviceId: String): Device
	suspend fun getDevices(deviceIds: List<String>): List<Device>
	suspend fun createDevice(p: Device): Device
	suspend fun updateDevice(device: Device): Device
	suspend fun createDevices(devices: List<Device>): List<IdWithRev>
	suspend fun updateDevices(devices: List<Device>): List<IdWithRev>

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

