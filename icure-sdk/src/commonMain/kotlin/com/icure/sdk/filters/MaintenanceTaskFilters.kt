package com.icure.sdk.filters

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
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
    ): BaseSortableFilterOptions<MaintenanceTask> = ByIds(ids)

    internal class ByIds(
        val ids : List<String>
    ): BaseSortableFilterOptions<MaintenanceTask> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param dataOwnerId a data owner id
     * @param identifiers a list of identifiers
     * @return options for maintenance task filtering
     */
    fun byIdentifiersForDataOwner(
        dataOwnerId: String,
        identifiers: List<Identifier>
    ): BaseSortableFilterOptions<MaintenanceTask> =
        ByIdentifiersForDataOwner(identifiers, dataOwnerId)

    internal class ByIdentifiersForDataOwner(
        val identifiers : List<Identifier>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<MaintenanceTask>

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @return options for maintenance task filtering
     */
    fun byIdentifiersForSelf(
        identifiers: List<Identifier>,
    ): SortableFilterOptions<MaintenanceTask> =
        ByIdentifiersForSelf(identifiers)

    internal class ByIdentifiersForSelf(
        val identifiers : List<Identifier>
    ): SortableFilterOptions<MaintenanceTask>

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
     * that have the provided type.
     *
     * @param type a maintenance task type
     * @param dataOwnerId a data owner id
     */
    fun byTypeForDataOwner(
        dataOwnerId: String,
        type: String
    ): BaseFilterOptions<MaintenanceTask> =
        ByTypeForDataOwner(type, dataOwnerId)

    internal class ByTypeForDataOwner(
        val type: String,
        val dataOwnerId: String
    ): BaseFilterOptions<MaintenanceTask>


    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
     * that have the provided type.
     *
     * @param type a maintenance task type
     */
    fun byTypeForSelf(
        type: String,
    ): FilterOptions<MaintenanceTask> =
        ByTypeForSelf(type)

    internal class ByTypeForSelf(
        val type: String,
    ): FilterOptions<MaintenanceTask>

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
     * that have a [MaintenanceTask.created] after the provided date.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
     * [MaintenanceTask.created].
     *
     * @param dataOwnerId a data owner id
     * @param date a unix timestamp
     */
    fun afterDateForDataOwner(
        dataOwnerId: String,
        date: Long
    ): BaseSortableFilterOptions<MaintenanceTask> =
        AfterDateForDataOwner(date, dataOwnerId)

    internal class AfterDateForDataOwner(
        val date: Long,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<MaintenanceTask>


    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
     * that have a [MaintenanceTask.created] after the provided date.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
     * [MaintenanceTask.created].
     *
     * @param date a unix timestamp
     */
    fun afterDateForSelf(
        date: Long,
    ): SortableFilterOptions<MaintenanceTask> =
        AfterDateForSelf(date)

    internal class AfterDateForSelf(
        val date: Long,
    ): SortableFilterOptions<MaintenanceTask>
}

internal suspend fun mapMaintenanceTaskFilterOptions(
    filterOptions: FilterOptions<MaintenanceTask>,
    selfDataOwnerId: String
): AbstractFilter<MaintenanceTask> = mapIfMetaFilterOptions(filterOptions) {
    mapMaintenanceTaskFilterOptions(it, selfDataOwnerId)
} ?: when (filterOptions) {
    is MaintenanceTaskFilters.ByTypeForDataOwner -> MaintenanceTaskByHcPartyAndTypeFilter(
        type = filterOptions.type,
        healthcarePartyId = filterOptions.dataOwnerId
    )
    is MaintenanceTaskFilters.AfterDateForDataOwner -> MaintenanceTaskAfterDateFilter(
        date = filterOptions.date,
        healthcarePartyId = filterOptions.dataOwnerId
    )
    is MaintenanceTaskFilters.ByIdentifiersForDataOwner -> MaintenanceTaskByHcPartyAndIdentifiersFilter(
        identifiers = filterOptions.identifiers,
        healthcarePartyId = filterOptions.dataOwnerId
    )
    is MaintenanceTaskFilters.ByTypeForSelf -> MaintenanceTaskByHcPartyAndTypeFilter(
        type = filterOptions.type,
        healthcarePartyId = selfDataOwnerId
    )
    is MaintenanceTaskFilters.AfterDateForSelf -> MaintenanceTaskAfterDateFilter(
        date = filterOptions.date,
        healthcarePartyId = selfDataOwnerId
    )
    is MaintenanceTaskFilters.ByIdentifiersForSelf -> MaintenanceTaskByHcPartyAndIdentifiersFilter(
        identifiers = filterOptions.identifiers,
        healthcarePartyId = selfDataOwnerId
    )
    is MaintenanceTaskFilters.ByIds -> MaintenanceTaskByIdsFilter(ids = filterOptions.ids.toSet())
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering MaintenanceTasks")
}