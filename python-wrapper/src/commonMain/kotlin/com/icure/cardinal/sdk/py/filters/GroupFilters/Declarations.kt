// auto-generated file
package com.icure.cardinal.sdk.py.filters.GroupFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.GroupFilters
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	GroupFilters.all()
}.toPyString(BaseFilterOptions.serializer(Group.serializer()))

@Serializable
private class BySuperGroupParams(
	public val superGroupId: String,
)

@OptIn(InternalIcureApi::class)
public fun bySuperGroup(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySuperGroupParams>(params)
	GroupFilters.bySuperGroup(
		decodedParams.superGroupId,
	)
}.toPyString(BaseFilterOptions.serializer(Group.serializer()))

@Serializable
private class WithContentParams(
	public val superGroupId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun withContent(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithContentParams>(params)
	GroupFilters.withContent(
		decodedParams.superGroupId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Group.serializer()))
