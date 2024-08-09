package com.icure.sdk.filters

import com.icure.sdk.model.User

object UserFilters {
    /**
     * Filter options to match all users.
     * These options are not sortable.
     */
    fun all(): FilterOptions<User> = All

    /**
     * Filter options that match all users with one of the provided ids.
     * These options are sortable. When sorting using these options the users will have the same order as the input ids.
     * @param ids a list of user ids.
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<User> = ByIds(ids)

    /**
     * Filter options that match all users linked to the provided patient id.
     * These options are not sortable.
     * @param patientId a patient id
     */
    fun byPatientId(patientId: String): FilterOptions<User> = ByPatientId(patientId)

    /**
     * Filter options that match all users that have a word starting with [searchString] in [User.login], [User.name],
     * [User.email] or [User.mobilePhone].
     * These options are not sortable.
     */
    fun byNameEmailOrPhone(searchString: String): FilterOptions<User> = ByNameEmailOrPhone(searchString)

    internal data object All: FilterOptions<User>
    internal class ByIds(val ids: List<String>): SortableFilterOptions<User>
    internal class ByPatientId(val patientId: String): FilterOptions<User>
    internal class ByNameEmailOrPhone(val searchString: String): FilterOptions<User>
}
