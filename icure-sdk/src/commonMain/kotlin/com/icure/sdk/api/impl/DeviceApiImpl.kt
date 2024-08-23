package com.icure.sdk.api.impl

import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.mapDeviceFilterOptions
import com.icure.sdk.model.Device
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.pagination.IdsPageIterator

@InternalIcureApi
internal class DeviceApiImpl(
	private val rawApi: RawDeviceApi,
) : DeviceApi {
	override suspend fun getDevice(deviceId: String) = rawApi.getDevice(deviceId).successBody()

	override suspend fun getDevices(deviceIds: List<String>) = rawApi.getDevices(ListOfIds(deviceIds)).successBody()

	override suspend fun createDevice(p: Device) = rawApi.createDevice(p).successBody()

	override suspend fun updateDevice(device: Device) = rawApi.updateDevice(device).successBody()

	override suspend fun createDevices(devices: List<Device>) = rawApi.createDevices(devices).successBody()

	override suspend fun updateDevices(devices: List<Device>) = rawApi.updateDevices(devices).successBody()

	override suspend fun filterDevicesBy(filter: BaseFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBy(filter), this::getDevices)

	override suspend fun filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBySorted(filter), this::getDevices)

	override suspend fun matchDevicesBy(filter: BaseFilterOptions<Device>) =
		rawApi.matchDevicesBy(mapDeviceFilterOptions(filter)).successBody()

	override suspend fun matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		matchDevicesBy(filter)

	override suspend fun deleteDevice(deviceId: String) = rawApi.deleteDevice(deviceId).successBody()

	override suspend fun deleteDevices(deviceIds: List<String>) = rawApi.deleteDevices(
		ListOfIds(deviceIds)
	).successBody()

	override suspend fun getDevicesInGroup(groupId: String, deviceIds: List<String>?) =
		rawApi.getDevicesInGroup(groupId, deviceIds?.let { ListOfIds(it) }).successBody()

	override suspend fun modifyDeviceInGroup(groupId: String, device: Device) =
		rawApi.modifyDeviceInGroup(groupId, device).successBody()

	override suspend fun createDeviceInGroup(groupId: String, device: Device) =
		rawApi.createDeviceInGroup(groupId, device).successBody()

	override suspend fun deleteDevicesInGroup(groupId: String, deviceIds: String) =
		rawApi.deleteDevicesInGroup(groupId, deviceIds).successBody()

}