// auto-generated file
package com.icure.sdk.py.filters.GroupFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.GroupFilters
import com.icure.sdk.model.Group
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	GroupFilters.all()
}.toPyString(BaseFilterOptions.serializer(Group.serializer()))

@Serializable
private class BySuperGroupParams(
	public val superGroupId: String,
)

public fun bySuperGroup(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<BySuperGroupParams>(params)
	GroupFilters.bySuperGroup(
		decodedParams.superGroupId,
	)
}.toPyString(BaseFilterOptions.serializer(Group.serializer()))

@Serializable
private class WithContentParams(
	public val superGroupId: String,
	public val searchString: String,
)

public fun withContent(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithContentParams>(params)
	GroupFilters.withContent(
		decodedParams.superGroupId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Group.serializer()))
