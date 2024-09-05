// auto-generated file
package com.icure.cardinal.sdk.py.filters.AccessLogFilters

import com.icure.cardinal.sdk.filters.AccessLogFilters
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.serialization.AccessLogSerializer
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsDateForDataOwnerParams>(params)
	AccessLogFilters.byPatientsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(AccessLogSerializer))

@Serializable
private class ByPatientsDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsDateForSelfParams>(params)
	AccessLogFilters.byPatientsDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(AccessLogSerializer))

@Serializable
private class ByPatientSecretIdsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsDateForDataOwnerParams>(params)
	AccessLogFilters.byPatientSecretIdsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(AccessLogSerializer))

@Serializable
private class ByPatientSecretIdsDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsDateForSelfParams>(params)
	AccessLogFilters.byPatientSecretIdsDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(AccessLogSerializer))

@Serializable
private class ByDateParams(
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byDate(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByDateParams>(params)
	AccessLogFilters.byDate(
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(AccessLogSerializer))

@Serializable
private class ByUserTypeDateParams(
	public val userId: String,
	public val accessType: String? = null,
	public val from: Instant? = null,
	public val descending: Boolean = false,
)

public fun byUserTypeDate(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByUserTypeDateParams>(params)
	AccessLogFilters.byUserTypeDate(
		decodedParams.userId,
		decodedParams.accessType,
		decodedParams.from,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(AccessLogSerializer))
