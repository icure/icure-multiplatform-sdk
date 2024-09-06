// auto-generated file
package com.icure.cardinal.sdk.py.filters.CodeFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.CodeFilters
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
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

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	CodeFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Code.serializer()))

@Serializable
private class ByQualifiedLinkParams(
	public val linkType: String,
	public val linkedId: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byQualifiedLink(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByQualifiedLinkParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun byRegionTypeCodeVersion(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByRegionTypeCodeVersionParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun byLanguageTypeLabelRegion(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByLanguageTypeLabelRegionParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun byLanguageTypesLabelRegionVersion(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByLanguageTypesLabelRegionVersionParams>(params)
	CodeFilters.byLanguageTypesLabelRegionVersion(
		decodedParams.language,
		decodedParams.types,
		decodedParams.label,
		decodedParams.region,
		decodedParams.version,
	)
}.toPyString(BaseFilterOptions.serializer(Code.serializer()))
