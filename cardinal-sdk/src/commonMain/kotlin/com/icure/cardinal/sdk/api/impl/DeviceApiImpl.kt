package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.mapDeviceFilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class DeviceApiImpl(
	private val rawApi: RawDeviceApi,
	private val config: BasicApiConfiguration,
) : DeviceApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteDevice(entityId: String): DocIdentifier =
		rawApi.deleteDevice(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteDevices(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteDevices(ListOfIds(entityIds)).successBody()

	override suspend fun getDevice(deviceId: String) = rawApi.getDevice(deviceId).successBody()

	override suspend fun getDevices(deviceIds: List<String>) = rawApi.getDevices(ListOfIds(deviceIds)).successBody()

	override suspend fun createDevice(p: Device) = rawApi.createDevice(p).successBody()

	override suspend fun modifyDevice(device: Device) = rawApi.updateDevice(device).successBodyOrThrowRevisionConflict()

	override suspend fun createDevices(devices: List<Device>) = rawApi.createDevices(devices).successBody()

	override suspend fun modifyDevices(devices: List<Device>) = rawApi.updateDevices(devices).successBody()

	override suspend fun filterDevicesBy(filter: BaseFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBy(filter), this::getDevices)

	override suspend fun filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBySorted(filter), this::getDevices)

	override suspend fun matchDevicesBy(filter: BaseFilterOptions<Device>) =
		rawApi.matchDevicesBy(mapDeviceFilterOptions(filter)).successBody()

	override suspend fun matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		matchDevicesBy(filter)

	override suspend fun deleteDeviceById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteDevice(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteDevicesByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteDevicesWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeDeviceById(id: String, rev: String) {
		rawApi.purgeDevice(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun undeleteDeviceById(id: String, rev: String): Device =
		rawApi.undeleteDevice(id, rev).successBodyOrThrowRevisionConflict()

	override suspend fun getDevicesInGroup(groupId: String, deviceIds: List<String>?) =
		rawApi.getDevicesInGroup(groupId, deviceIds?.let { ListOfIds(it) }).successBody()

	override suspend fun modifyDeviceInGroup(groupId: String, device: Device) =
		rawApi.modifyDeviceInGroup(groupId, device).successBody()

	override suspend fun createDeviceInGroup(groupId: String, device: Device) =
		rawApi.createDeviceInGroup(groupId, device).successBody()

	override suspend fun deleteDevicesInGroup(groupId: String, deviceIds: List<IdWithRev>) =
		rawApi.deleteDevicesInGroupWithRev(groupId, ListOfIdsAndRev(deviceIds)).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Device>,
		subscriptionConfig: EntitySubscriptionConfiguration?,
	): EntitySubscription<Device> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = Device.serializer(),
			events = events,
			filter = mapDeviceFilterOptions(filter),
			qualifiedName = Device.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(DeviceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

}
