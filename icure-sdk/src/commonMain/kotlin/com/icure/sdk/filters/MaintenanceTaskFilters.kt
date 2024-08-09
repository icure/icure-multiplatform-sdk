package com.icure.sdk.filters

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.utils.DefaultValue

object MaintenanceTaskFilters {
    /**
     * Filter options that match all maintenance tasks with one of the provided ids.
     * These options are sortable. When sorting using these options the maintenance tasks will have the same order as the input ids.
     * @param ids a list of maintenance task ids.
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<MaintenanceTask> = ByIds(ids)

    internal class ByIds(
        val identifiers : List<String>
    ): SortableFilterOptions<MaintenanceTask>

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