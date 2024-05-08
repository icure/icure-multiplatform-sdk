package com.icure.sdk.api.raw

import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDeviceApi {
	// region common endpoints

	suspend fun getDevice(deviceId: String): HttpResponse<Device>

	suspend fun getDevices(deviceIds: ListOfIds): HttpResponse<List<Device>>

	suspend fun createDevice(p: Device): HttpResponse<Device>

	suspend fun updateDevice(deviceDto: Device): HttpResponse<Device>

	suspend fun createDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>>

	suspend fun updateDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>>

	suspend fun filterDevicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Device>,
	): HttpResponse<PaginatedList<Device>>

	suspend fun getDeviceAesExchangeKeysForDelegate(
		deviceId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>

	suspend fun matchDevicesBy(filter: AbstractFilter<Device>): HttpResponse<List<String>>

	suspend fun deleteDevice(deviceId: String): HttpResponse<DocIdentifier>

	suspend fun deleteDevices(deviceIds: ListOfIds): HttpResponse<List<DocIdentifier>>
	// endregion

	// region cloud endpoints

	suspend fun getDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIds? = null,
	): HttpResponse<List<Device>>

	suspend fun modifyDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device>

	suspend fun createDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device>

	suspend fun deleteDevicesInGroup(
		groupId: String,
		deviceIds: String,
	): HttpResponse<List<DocIdentifier>>
	// endregion
}
