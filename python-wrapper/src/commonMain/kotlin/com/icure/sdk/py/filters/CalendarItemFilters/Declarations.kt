// auto-generated file
package com.icure.sdk.py.filters.CalendarItemFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.CalendarItemFilters
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.CalendarItemSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsStartTimeForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsStartTimeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsStartTimeForDataOwnerParams>(params)
	CalendarItemFilters.byPatientsStartTimeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPatientsStartTimeForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientsStartTimeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsStartTimeForSelfParams>(params)
	CalendarItemFilters.byPatientsStartTimeForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPatientSecretIdsStartTimeForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsStartTimeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsStartTimeForDataOwnerParams>(params)
	CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPatientSecretIdsStartTimeForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsStartTimeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsStartTimeForSelfParams>(params)
	CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPeriodAndAgendaParams(
	public val agendaId: String,
	public val from: Long,
	public val to: Long,
	public val descending: Boolean = false,
)

public fun byPeriodAndAgenda(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPeriodAndAgendaParams>(params)
	CalendarItemFilters.byPeriodAndAgenda(
		decodedParams.agendaId,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPeriodForDataOwnerParams(
	public val dataOwnerId: String,
	public val from: Long,
	public val to: Long,
)

public fun byPeriodForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPeriodForDataOwnerParams>(params)
	CalendarItemFilters.byPeriodForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.from,
		decodedParams.to,
	)
}.toPyString(BaseFilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByPeriodForSelfParams(
	public val from: Long,
	public val to: Long,
)

public fun byPeriodForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPeriodForSelfParams>(params)
	CalendarItemFilters.byPeriodForSelf(
		decodedParams.from,
		decodedParams.to,
	)
}.toPyString(FilterOptions.serializer(CalendarItemSerializer))

@Serializable
private class ByRecurrenceIdParams(
	public val recurrenceId: String,
)

public fun byRecurrenceId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByRecurrenceIdParams>(params)
	CalendarItemFilters.byRecurrenceId(
		decodedParams.recurrenceId,
	)
}.toPyString(FilterOptions.serializer(CalendarItemSerializer))
