package com.icure.sdk.api

import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.InternalIcureApi

interface DeviceApi {
	suspend fun getDevice(deviceId: String): Device
	suspend fun getDevices(deviceIds: ListOfIds): List<Device>
	suspend fun createDevice(p: Device): Device
	suspend fun updateDevice(device: Device): Device
	suspend fun createDevices(devices: List<Device>): List<IdWithRev>
	suspend fun updateDevices(devices: List<Device>): List<IdWithRev>
	suspend fun filterDevicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Device>,
	): PaginatedList<Device>

	suspend fun matchDevicesBy(filter: AbstractFilter<Device>): List<String>
	suspend fun deleteDevice(deviceId: String): DocIdentifier
	suspend fun deleteDevices(deviceIds: ListOfIds): List<DocIdentifier>
	suspend fun getDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIds? = null,
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

@OptIn(InternalIcureApi::class)
class DeviceApiImpl(
	private val rawApi: RawDeviceApi,
) : DeviceApi {
	override suspend fun getDevice(deviceId: String) = rawApi.getDevice(deviceId).successBody()

	override suspend fun getDevices(deviceIds: ListOfIds) = rawApi.getDevices(deviceIds).successBody()

	override suspend fun createDevice(p: Device) = rawApi.createDevice(p).successBody()

	override suspend fun updateDevice(device: Device) = rawApi.updateDevice(device).successBody()

	override suspend fun createDevices(devices: List<Device>) = rawApi.createDevices(devices).successBody()

	override suspend fun updateDevices(devices: List<Device>) = rawApi.updateDevices(devices).successBody()

	override suspend fun filterDevicesBy(startDocumentId: String?, limit: Int?, filterChain: FilterChain<Device>) =
		rawApi.filterDevicesBy(startDocumentId, limit, filterChain).successBody()

	override suspend fun matchDevicesBy(filter: AbstractFilter<Device>) = rawApi.matchDevicesBy(filter).successBody()

	override suspend fun deleteDevice(deviceId: String) = rawApi.deleteDevice(deviceId).successBody()

	override suspend fun deleteDevices(deviceIds: ListOfIds) = rawApi.deleteDevices(deviceIds).successBody()

	override suspend fun getDevicesInGroup(groupId: String, deviceIds: ListOfIds?) =
		rawApi.getDevicesInGroup(groupId, deviceIds).successBody()

	override suspend fun modifyDeviceInGroup(groupId: String, device: Device) =
		rawApi.modifyDeviceInGroup(groupId, device).successBody()

	override suspend fun createDeviceInGroup(groupId: String, device: Device) =
		rawApi.createDeviceInGroup(groupId, device).successBody()

	override suspend fun deleteDevicesInGroup(groupId: String, deviceIds: String) =
		rawApi.deleteDevicesInGroup(groupId, deviceIds).successBody()

}

