// auto-generated file
package com.icure.cardinal.sdk.py.filters.CalendarItemFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.CalendarItemFilters
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsStartTimeForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsStartTimeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsStartTimeForDataOwnerParams>(params)
	CalendarItemFilters.byPatientsStartTimeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPatientsStartTimeForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<GroupScoped<Patient>>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsStartTimeForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsStartTimeForDataOwnerInGroupParams>(params)
	CalendarItemFilters.byPatientsStartTimeForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPatientsStartTimeForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsStartTimeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsStartTimeForSelfParams>(params)
	CalendarItemFilters.byPatientsStartTimeForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPatientSecretIdsStartTimeForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsStartTimeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsStartTimeForDataOwnerParams>(params)
	CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPatientSecretIdsStartTimeForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsStartTimeForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsStartTimeForDataOwnerInGroupParams>(params)
	CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPatientSecretIdsStartTimeForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsStartTimeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsStartTimeForSelfParams>(params)
	CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPeriodAndAgendaParams(
	public val agendaId: String,
	public val from: Long,
	public val to: Long,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPeriodAndAgenda(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPeriodAndAgendaParams>(params)
	CalendarItemFilters.byPeriodAndAgenda(
		decodedParams.agendaId,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPeriodForDataOwnerParams(
	public val dataOwnerId: String,
	public val from: Long,
	public val to: Long,
)

@OptIn(InternalIcureApi::class)
public fun byPeriodForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPeriodForDataOwnerParams>(params)
	CalendarItemFilters.byPeriodForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.from,
		decodedParams.to,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPeriodForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val from: Long,
	public val to: Long,
)

@OptIn(InternalIcureApi::class)
public fun byPeriodForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPeriodForDataOwnerInGroupParams>(params)
	CalendarItemFilters.byPeriodForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.from,
		decodedParams.to,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByPeriodForSelfParams(
	public val from: Long,
	public val to: Long,
)

@OptIn(InternalIcureApi::class)
public fun byPeriodForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPeriodForSelfParams>(params)
	CalendarItemFilters.byPeriodForSelf(
		decodedParams.from,
		decodedParams.to,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class ByRecurrenceIdParams(
	public val recurrenceId: String,
)

@OptIn(InternalIcureApi::class)
public fun byRecurrenceId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByRecurrenceIdParams>(params)
	CalendarItemFilters.byRecurrenceId(
		decodedParams.recurrenceId,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class LifecycleBetweenForDataOwnerParams(
	public val dataOwnerId: String,
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LifecycleBetweenForDataOwnerParams>(params)
	CalendarItemFilters.lifecycleBetweenForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class LifecycleBetweenForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LifecycleBetweenForDataOwnerInGroupParams>(params)
	CalendarItemFilters.lifecycleBetweenForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))

@Serializable
private class LifecycleBetweenForSelfParams(
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LifecycleBetweenForSelfParams>(params)
	CalendarItemFilters.lifecycleBetweenForSelf(
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(CalendarItem::class)))
