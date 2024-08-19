// auto-generated file
package com.icure.sdk.py.filters.CodeFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.CodeFilters
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.model.Code
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	CodeFilters.all()
}.toPyString(FilterOptions.serializer(Code.serializer()))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	CodeFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Code.serializer()))

@Serializable
private class ByLanguageTypeLabelRegionParams(
	public val language: String,
	public val type: String,
	public val label: String? = null,
	public val region: String? = null,
)

public fun byLanguageTypeLabelRegion(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByLanguageTypeLabelRegionParams>(params)
	CodeFilters.byLanguageTypeLabelRegion(
		decodedParams.language,
		decodedParams.type,
		decodedParams.label,
		decodedParams.region,
	)
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))
