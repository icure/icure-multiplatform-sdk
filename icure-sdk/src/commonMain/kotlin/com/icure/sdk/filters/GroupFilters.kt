package com.icure.sdk.filters

import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Group
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.group.AllGroupsFilter
import com.icure.sdk.model.filter.group.GroupBySuperGroupFilter
import com.icure.sdk.model.filter.group.GroupWithContentFilter
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object GroupFilters {
	/**
	 * Filter options to match all agendas.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<Group> = All

	/**
	 * Options for group filtering that returns all the groups where [Group.superGroup] is equal to [superGroupId].
	 *
	 * @param superGroupId the id of the super group.
	 */
	fun bySuperGroup(
		superGroupId: String,
	): BaseFilterOptions<Group> = BySuperGroup(superGroupId)

	/**
	 * Options for group filtering that returns all the groups where [Group.superGroup] is equal to [superGroupId] and one or more of the
	 * following is true:
	 * - [Group.id] starts with the provided [searchString].
	 * - [Group.name] starts with the provided [searchString].
	 * - In [Group.properties] there is at least one property where the identifier in the property type starts with [searchString] or where
	 *   property string value starts with [searchString].
	 * If a group matches for more than one option, only the first will be considered.
	 *
	 * These options are sortable. When sorting using these options the groups will be sorted lexicographically by the aforementioned
	 * properties.
	 *
	 * @param superGroupId the id of the super group.
	 * @param searchString the query to search in the group id, name, or properties.
	 */
	fun withContent(
		superGroupId: String,
		searchString: String
	): BaseSortableFilterOptions<Group> = WithContent(superGroupId, searchString)

	@Serializable
	internal data object All: BaseFilterOptions<Group>

	@Serializable
	internal data class BySuperGroup(
		val superGroupId: String
	): BaseFilterOptions<Group>

	@Serializable
	internal data class WithContent(
		val superGroupId: String,
		val searchString: String
	): BaseSortableFilterOptions<Group>
}

@InternalIcureApi
internal suspend fun mapGroupFilterOptions(
	filterOptions: FilterOptions<Group>
): AbstractFilter<Group> = mapIfMetaFilterOptions(filterOptions) {
	mapGroupFilterOptions(it)
} ?: when (filterOptions) {
	is GroupFilters.All -> AllGroupsFilter()
	is GroupFilters.BySuperGroup -> GroupBySuperGroupFilter(superGroupId = filterOptions.superGroupId)
	is GroupFilters.WithContent -> GroupWithContentFilter(superGroupId = filterOptions.superGroupId, searchString = filterOptions.searchString)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Groups")
}
