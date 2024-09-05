// auto-generated file
package com.icure.cardinal.sdk.py.filters.HealthElementFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.serialization.HealthElementSerializer
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
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

@Serializable
private class ByPatientsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsOpeningDateForDataOwnerParams>(params)
	HealthElementFilters.byPatientsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientsOpeningDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsOpeningDateForSelfParams>(params)
	HealthElementFilters.byPatientsOpeningDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientSecretIdsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsOpeningDateForDataOwnerParams>(params)
	HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByPatientSecretIdsOpeningDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsOpeningDateForSelfParams>(params)
	HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByStatusForDataOwnerParams(
	public val dataOwnerId: String,
	public val status: Int,
)

public fun byStatusForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByStatusForDataOwnerParams>(params)
	HealthElementFilters.byStatusForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.status,
	)
}.toPyString(BaseFilterOptions.serializer(HealthElementSerializer))

@Serializable
private class ByStatusForSelfParams(
	public val status: Int,
)

public fun byStatusForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByStatusForSelfParams>(params)
	HealthElementFilters.byStatusForSelf(
		decodedParams.status,
	)
}.toPyString(FilterOptions.serializer(HealthElementSerializer))
