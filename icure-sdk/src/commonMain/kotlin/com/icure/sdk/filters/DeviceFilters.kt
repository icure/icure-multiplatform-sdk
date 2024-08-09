package com.icure.sdk.filters

import com.icure.sdk.model.Device

object DeviceFilters {
    /**
     * Filter options to match all devices.
     * These options are not sortable.
     */
    fun all(): FilterOptions<Device> = All

    /**
     * Filter options to match all devices where the [Device.responsible] is the provided [responsibleId]
     * @param responsibleId the id of the responsible
     */
    fun byResponsible(responsibleId: String): FilterOptions<Device> = ByResponsible(responsibleId)

    /**
     * Filter options that match all devices with one of the provided ids.
     * These options are sortable. When sorting using these options the devices will have the same order as the input ids.
     * @param ids a list of device ids.
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<Device> = ByIds(ids)

    /**
     * Filter options to match all devices.
     * These options are not sortable.
     */
    internal data object All: FilterOptions<Device>

    internal class ByResponsible(val responsibleId: String): FilterOptions<Device>

    internal class ByIds(
        val ids: List<String>
    ): SortableFilterOptions<Device>
}