// auto-generated file
package com.icure.sdk.py.filters.ClassificationFilters

import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.ClassificationFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.ClassificationSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsCreatedForDataOwnerParams>(params)
	ClassificationFilters.byPatientsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(ClassificationSerializer))

@Serializable
private class ByPatientsCreatedForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsCreatedForSelfParams>(params)
	ClassificationFilters.byPatientsCreatedForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(ClassificationSerializer))

@Serializable
private class ByPatientSecretIdsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsCreatedForDataOwnerParams>(params)
	ClassificationFilters.byPatientSecretIdsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ClassificationSerializer))

@Serializable
private class ByPatientSecretIdsCreatedForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsCreatedForSelfParams>(params)
	ClassificationFilters.byPatientSecretIdsCreatedForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(ClassificationSerializer))
