// auto-generated file
package com.icure.cardinal.sdk.py.filters.FormFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.FormFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.serialization.FormSerializer
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class ByParentIdForDataOwnerParams(
	public val dataOwnerId: String,
	public val parentId: String,
)

public fun byParentIdForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByParentIdForDataOwnerParams>(params)
	FormFilters.byParentIdForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.parentId,
	)
}.toPyString(BaseFilterOptions.serializer(FormSerializer))

@Serializable
private class ByParentIdForSelfParams(
	public val dataOwnerId: String,
	public val parentId: String,
)

public fun byParentIdForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByParentIdForSelfParams>(params)
	FormFilters.byParentIdForSelf(
		decodedParams.dataOwnerId,
		decodedParams.parentId,
	)
}.toPyString(FilterOptions.serializer(FormSerializer))

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
	FormFilters.byPatientsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(FormSerializer))

@Serializable
private class ByPatientsOpeningDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsOpeningDateForSelfParams>(params)
	FormFilters.byPatientsOpeningDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(FormSerializer))

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
	FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(FormSerializer))

@Serializable
private class ByPatientSecretIdsOpeningDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsOpeningDateForSelfParams>(params)
	FormFilters.byPatientSecretIdsOpeningDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(FormSerializer))

@Serializable
private class ByLogicalUuidParams(
	public val logicalUuid: String,
	public val descending: Boolean = false,
)

public fun byLogicalUuid(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByLogicalUuidParams>(params)
	FormFilters.byLogicalUuid(
		decodedParams.logicalUuid,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(FormSerializer))

@Serializable
private class ByUniqueIdParams(
	public val uniqueId: String,
	public val descending: Boolean = false,
)

public fun byUniqueId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByUniqueIdParams>(params)
	FormFilters.byUniqueId(
		decodedParams.uniqueId,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(FormSerializer))
