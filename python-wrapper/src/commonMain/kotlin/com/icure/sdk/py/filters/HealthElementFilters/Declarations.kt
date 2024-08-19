// auto-generated file
package com.icure.sdk.py.filters.HealthElementFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.HealthElementFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.py.serialization.HealthElementSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class AllHealthElementsForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allHealthElementsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllHealthElementsForDataOwnerParams>(params)
	HealthElementFilters.allHealthElementsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(HealthElementSerializer))

public fun allHealthElementsForSelf(): String = kotlin.runCatching {
	HealthElementFilters.allHealthElementsForSelf()
}.toPyString(FilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	HealthElementFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForSelfParams>(params)
	HealthElementFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByCodeForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
)

public fun byCodeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeForDataOwnerParams>(params)
	HealthElementFilters.byCodeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByCodeForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

public fun byCodeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeForSelfParams>(params)
	HealthElementFilters.byCodeForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByTagForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
)

public fun byTagForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagForDataOwnerParams>(params)
	HealthElementFilters.byTagForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByTagForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

public fun byTagForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagForSelfParams>(params)
	HealthElementFilters.byTagForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForDataOwnerParams>(params)
	HealthElementFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForSelfParams>(params)
	HealthElementFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	HealthElementFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	HealthElementFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	HealthElementFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))
