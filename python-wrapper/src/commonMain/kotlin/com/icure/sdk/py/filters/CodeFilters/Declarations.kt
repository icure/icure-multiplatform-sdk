// auto-generated file
package com.icure.sdk.py.filters.CodeFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.CodeFilters
import com.icure.sdk.model.Code
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	CodeFilters.all()
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))

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
private class ByQualifiedLinkParams(
	public val linkType: String,
	public val linkedId: String? = null,
)

public fun byQualifiedLink(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByQualifiedLinkParams>(params)
	CodeFilters.byQualifiedLink(
		decodedParams.linkType,
		decodedParams.linkedId,
	)
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))

@Serializable
private class ByRegionTypeCodeVersionParams(
	public val region: String,
	public val type: String? = null,
	public val code: String? = null,
	public val version: String? = null,
)

public fun byRegionTypeCodeVersion(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByRegionTypeCodeVersionParams>(params)
	CodeFilters.byRegionTypeCodeVersion(
		decodedParams.region,
		decodedParams.type,
		decodedParams.code,
		decodedParams.version,
	)
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))

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

@Serializable
private class ByLanguageTypesLabelRegionVersionParams(
	public val language: String,
	public val types: List<String>,
	public val label: String,
	public val region: String? = null,
	public val version: String? = null,
)

public fun byLanguageTypesLabelRegionVersion(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByLanguageTypesLabelRegionVersionParams>(params)
	CodeFilters.byLanguageTypesLabelRegionVersion(
		decodedParams.language,
		decodedParams.types,
		decodedParams.label,
		decodedParams.region,
		decodedParams.version,
	)
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))
