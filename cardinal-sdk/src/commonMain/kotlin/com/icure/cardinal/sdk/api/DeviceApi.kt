package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlin.js.JsName

interface DeviceApi: Subscribable<Device, Device, FilterOptions<Device>> {
	@Deprecated("Deletion without rev is unsafe")
	@JsName("deleteDeviceUnsafe")
	suspend fun deleteDevice(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	@JsName("deleteDevicesUnsafe")
	suspend fun deleteDevices(entityIds: List<String>): List<DocIdentifier>
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

	/**
	 * Deletes a device. If you don't have write access to the device the method will fail.
	 * @param entityId id of the device.
	 * @param rev the latest known rev of the device to delete
	 * @return the id and revision of the deleted device.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteDeviceById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many devices. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the devices to delete.
	 * @return the id and revision of the deleted devices. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteDevicesByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a device.
	 * @param id id of the device to purge
	 * @param rev latest revision of the device
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeDeviceById(id: String, rev: String)

	/**
	 * Restores a device that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteDeviceById(id: String, rev: String): Device

	/**
	 * Deletes a device. If you don't have write access to the device the method will fail.
	 * @param device the device to delete
	 * @return the id and revision of the deleted device.
	 * @throws RevisionConflictException if the provided device doesn't match the latest known revision
	 */
	suspend fun deleteDevice(device: Device): DocIdentifier =
		deleteDeviceById(device.id, requireNotNull(device.rev) { "Can't delete a device that has no rev" })

	/**
	 * Deletes many devices. Ignores device for which you don't have write access or that don't match the latest revision.
	 * @param devices the devices to delete
	 * @return the id and revision of the deleted devices. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteDevices(devices: List<Device>): List<DocIdentifier> =
		deleteDevicesByIds(devices.map { device ->
			IdWithMandatoryRev(device.id, requireNotNull(device.rev) { "Can't delete a device that has no rev" })
		})

	/**
	 * Permanently deletes a device.
	 * @param device the device to purge.
	 * @throws RevisionConflictException if the provided device doesn't match the latest known revision
	 */
	suspend fun purgeDevice(device: Device) {
		purgeDeviceById(device.id, requireNotNull(device.rev) { "Can't delete a device that has no rev" })
	}
	/**
	 * Restores a device that was marked as deleted.
	 * @param device the device to undelete
	 * @return the restored device.
	 * @throws RevisionConflictException if the provided device doesn't match the latest known revision
	 */
	suspend fun undeleteDevice(device: Device): Device =
		undeleteDeviceById(device.id, requireNotNull(device.rev) { "Can't delete a device that has no rev" })


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
		deviceIds: List<IdWithRev>,
	): List<DocIdentifier>
}

