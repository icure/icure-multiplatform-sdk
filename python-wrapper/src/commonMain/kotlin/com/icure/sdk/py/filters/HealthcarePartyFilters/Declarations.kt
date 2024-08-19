// auto-generated file
package com.icure.sdk.py.filters.HealthcarePartyFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.HealthcarePartyFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	HealthcarePartyFilters.all()
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByIdentifiersParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiers(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersParams>(params)
	HealthcarePartyFilters.byIdentifiers(
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByCodeParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

public fun byCode(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeParams>(params)
	HealthcarePartyFilters.byCode(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByTagParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

public fun byTag(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagParams>(params)
	HealthcarePartyFilters.byTag(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	HealthcarePartyFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(SortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByNameParams(
	public val searchString: String,
	public val descending: Boolean = false,
)

public fun byName(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByNameParams>(params)
	HealthcarePartyFilters.byName(
		decodedParams.searchString,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))
