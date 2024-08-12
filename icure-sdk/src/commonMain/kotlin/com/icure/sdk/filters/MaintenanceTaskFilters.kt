package com.icure.sdk.filters

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.requireUniqueElements

object MaintenanceTaskFilters {
    /**
     * Filter options that match all maintenance tasks with one of the provided ids.
     * These options are sortable. When sorting using these options the maintenance tasks will have the same order as the input ids.
     * @param ids a list of unique maintenance task ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<MaintenanceTask> = ByIds(ids)

    internal class ByIds(
        val ids : List<String>
    ): SortableFilterOptions<MaintenanceTask> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for maintenance task filtering
     */
    fun byIdentifiers(
        identifiers: List<Identifier>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<MaintenanceTask> =
        ByIdentifiers(identifiers, dataOwnerId)

    internal class ByIdentifiers(
        val identifiers : List<Identifier>,
        val dataOwnerId: String?
    ): SortableFilterOptions<MaintenanceTask>

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared with a specific data owner
     * that have the provided type.
     *
     * @param type a maintenance task type
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byType(
        type: String,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): FilterOptions<MaintenanceTask> =
        ByType(type, dataOwnerId)

    internal class ByType(
        val type: String,
        val dataOwnerId: String?
    ): FilterOptions<MaintenanceTask>

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared with a specific data owner
     * that have a [MaintenanceTask.created] after the provided date.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
     * [MaintenanceTask.created].
     *
     * @param date a unix timestamp
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun afterDate(
        date: Long,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<MaintenanceTask> =
        AfterDate(date, dataOwnerId)

    internal class AfterDate(
        val date: Long,
        val dataOwnerId: String?
    ): SortableFilterOptions<MaintenanceTask>
}

internal suspend fun mapMaintenanceTaskFilterOptions(
    filterOptions: FilterOptions<MaintenanceTask>,
    selfDataOwnerId: String
): AbstractFilter<MaintenanceTask> = mapIfMetaFilterOptions(filterOptions) {
    mapMaintenanceTaskFilterOptions(it, selfDataOwnerId)
} ?: when (filterOptions) {
    is MaintenanceTaskFilters.ByType -> MaintenanceTaskByHcPartyAndTypeFilter(
        type = filterOptions.type,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is MaintenanceTaskFilters.AfterDate -> MaintenanceTaskAfterDateFilter(
        date = filterOptions.date,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is MaintenanceTaskFilters.ByIdentifiers -> MaintenanceTaskByHcPartyAndIdentifiersFilter(
        identifiers = filterOptions.identifiers,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is MaintenanceTaskFilters.ByIds -> MaintenanceTaskByIdsFilter(ids = filterOptions.ids.toSet())
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering MaintenanceTasks")
}