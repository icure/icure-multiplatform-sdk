// auto-generated file
package com.icure.cardinal.sdk.py.filters.HealthcarePartyFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.HealthcarePartyFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
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

@Serializable
private class ByNationalIdentifierParams(
	public val searchString: String,
	public val descending: Boolean = false,
)

public fun byNationalIdentifier(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByNationalIdentifierParams>(params)
	HealthcarePartyFilters.byNationalIdentifier(
		decodedParams.searchString,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByParentIdParams(
	public val parentId: String,
)

public fun byParentId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByParentIdParams>(params)
	HealthcarePartyFilters.byParentId(
		decodedParams.parentId,
	)
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))

@Serializable
private class ByTypeSpecialtyPostCodeParams(
	public val specialty: String,
	public val specCode: String,
	public val startPostCode: String,
	public val endPostCode: String,
)

public fun byTypeSpecialtyPostCode(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTypeSpecialtyPostCodeParams>(params)
	HealthcarePartyFilters.byTypeSpecialtyPostCode(
		decodedParams.specialty,
		decodedParams.specCode,
		decodedParams.startPostCode,
		decodedParams.endPostCode,
	)
}.toPyString(BaseFilterOptions.serializer(HealthcareParty.serializer()))
