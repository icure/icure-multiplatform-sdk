package com.icure.sdk.filters

import com.icure.sdk.model.Device
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.device.AllDevicesFilter
import com.icure.sdk.model.filter.device.DeviceByHcPartyFilter
import com.icure.sdk.model.filter.device.DeviceByIdsFilter
import com.icure.sdk.utils.requireUniqueElements

object DeviceFilters {
    /**
     * Filter options to match all devices.
     * These options are not sortable.
     */
    fun all(): BaseFilterOptions<Device> = All

    /**
     * Filter options to match all devices where the [Device.responsible] is the provided [responsibleId]
     * @param responsibleId the id of the responsible
     */
    fun byResponsible(responsibleId: String): BaseFilterOptions<Device> = ByResponsible(responsibleId)

    /**
     * Filter options that match all devices with one of the provided ids.
     * These options are sortable. When sorting using these options the devices will have the same order as the input ids.
     * @param ids a list of unique device ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): BaseSortableFilterOptions<Device> = ByIds(ids)

    /**
     * Filter options to match all devices.
     * These options are not sortable.
     */
    internal data object All: BaseFilterOptions<Device>

    internal class ByResponsible(val responsibleId: String): BaseFilterOptions<Device>

    internal class ByIds(
        val ids: List<String>
    ): BaseSortableFilterOptions<Device> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }
}

internal suspend fun mapDeviceFilterOptions(
    filterOptions: FilterOptions<Device>
): AbstractFilter<Device> = mapIfMetaFilterOptions(filterOptions, ::mapDeviceFilterOptions) ?: when (filterOptions) {
    DeviceFilters.All -> AllDevicesFilter()
    is DeviceFilters.ByIds -> DeviceByIdsFilter(ids = filterOptions.ids.toSet())
    is DeviceFilters.ByResponsible -> DeviceByHcPartyFilter(responsibleId = filterOptions.responsibleId)
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Devices")
}