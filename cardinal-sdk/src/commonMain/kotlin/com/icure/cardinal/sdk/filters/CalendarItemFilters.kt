package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerPatientStartTimeFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerUpdatedAfter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndDataOwnerIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByRecurrenceIdFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object CalendarItemFilters {

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsStartTimeForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientsStartTimeForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { EntityWithTypeInfo(it.toEncryptionMetadataStub(), EntityWithEncryptionMetadataTypeName.Patient) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsStartTimeForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientsStartTimeForSelf(
		patients = patients.map { EntityWithTypeInfo(it.toEncryptionMetadataStub(), EntityWithEncryptionMetadataTypeName.Patient) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPatientSecretIdsStartTimeForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<CalendarItem> = ByPatientSecretIdsStartTimeForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPatientSecretIdsStartTimeForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientSecretIdsStartTimeForSelf(secretIds, from, to, descending)

	/**
	 * Options for calendar items filtering which match all the calendar items where [CalendarItem.agendaId] is equal to [agendaId] and
	 * the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * These options are sortable. When sorting using these options, the calendar items will be sorted by [CalendarItem.startTime] in
	 * ascending or descending order according to the value of the [descending] parameter.
	 *
	 * @param agendaId the value of [CalendarItem.agendaId] to search.
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 * @param descending whether to sort the results in ascending or descending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPeriodAndAgenda(
		agendaId: String,
		from: Long,
		to: Long,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<CalendarItem> = ByPeriodAndAgenda(agendaId, from, to, descending)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * @param dataOwnerId a data owner id.
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	fun byPeriodForDataOwner(
		dataOwnerId: String,
		from: Long,
		to: Long
	): BaseFilterOptions<CalendarItem> = ByPeriodForDataOwner(dataOwnerId, from, to)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	fun byPeriodForSelf(
		from: Long,
		to: Long
	): FilterOptions<CalendarItem> = ByPeriodForSelf(from, to)

	/**
	 * Options for calendar item filtering which match all calendar items where [CalendarItem.recurrenceId] is equal to [recurrenceId].
	 *
	 * @param recurrenceId the recurrence id to filter.
	 */
	fun byRecurrenceId(
		recurrenceId: String,
	): FilterOptions<CalendarItem> = ByRecurrenceId(recurrenceId)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
	 * [updatedAfter].
	 *
	 * @param dataOwnerId a data owner id.
	 * @param updatedAfter the reference timestamp
	 */
	fun updatedAfterForDataOwner(
		dataOwnerId: String,
		updatedAfter: Long
	): BaseFilterOptions<CalendarItem> = UpdatedAfterForDataOwner(dataOwnerId, updatedAfter)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
	 * [updatedAfter].
	 *
	 * @param updatedAfter the reference timestamp
	 */
	fun updatedAfterForSelf(
		updatedAfter: Long
	): FilterOptions<CalendarItem> = UpdatedAfterForSelf(updatedAfter)

	@Serializable
	@InternalIcureApi
	internal class ByPatientsStartTimeForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithTypeInfo<EntityWithEncryptionMetadataStub>>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsStartTimeForSelf(
		val patients: List<EntityWithTypeInfo<EntityWithEncryptionMetadataStub>>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPatientSecretIdsStartTimeForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): BaseSortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPatientSecretIdsStartTimeForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodAndAgenda(
		val agendaId: String,
		val from: Long,
		val to: Long,
		val descending: Boolean
	): BaseSortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodForDataOwner(
		val dataOwnerId: String,
		val from: Long,
		val to: Long
	): BaseFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodForSelf(
		val from: Long,
		val to: Long
	): FilterOptions<CalendarItem>

	@Serializable
	internal class UpdatedAfterForDataOwner(
		val dataOwnerId: String,
		val updatedAfter: Long
	): BaseFilterOptions<CalendarItem>

	@Serializable
	internal class UpdatedAfterForSelf(
		val updatedAfter: Long
	): FilterOptions<CalendarItem>

	@Serializable
	internal class ByRecurrenceId(
		val recurrenceId: String
	): FilterOptions<CalendarItem>
}

@InternalIcureApi
internal suspend fun mapCalendarItemFilterOptions(
	filterOptions: FilterOptions<CalendarItem>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<CalendarItem> = mapIfMetaFilterOptions(filterOptions) {
	mapCalendarItemFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is CalendarItemFilters.ByPatientsStartTimeForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientIds = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it, null)
			}.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPatientsStartTimeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientIds = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it, null)
			}.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPatientSecretIdsStartTimeForDataOwner -> CalendarItemByDataOwnerPatientStartTimeFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientIds = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is CalendarItemFilters.ByPatientSecretIdsStartTimeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientIds = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPeriodAndAgenda -> CalendarItemByPeriodAndAgendaIdFilter(
		agendaId = filterOptions.agendaId,
		startTime = filterOptions.from,
		endTime = filterOptions.to,
		descending = filterOptions.descending
	)
	is CalendarItemFilters.ByPeriodForDataOwner -> CalendarItemByPeriodAndDataOwnerIdFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		startTime = filterOptions.from,
		endTime = filterOptions.to
	)
	is CalendarItemFilters.ByPeriodForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		CalendarItemByPeriodAndDataOwnerIdFilter(
			dataOwnerId = selfDataOwnerId,
			startTime = filterOptions.from,
			endTime = filterOptions.to
		)
	}
	is CalendarItemFilters.UpdatedAfterForDataOwner -> CalendarItemByDataOwnerUpdatedAfter(
		dataOwnerId = filterOptions.dataOwnerId,
		updatedAfter = filterOptions.updatedAfter
	)
	is CalendarItemFilters.UpdatedAfterForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		CalendarItemByDataOwnerUpdatedAfter(
			dataOwnerId = selfDataOwnerId,
			updatedAfter = filterOptions.updatedAfter
		)
	}
	is CalendarItemFilters.ByRecurrenceId -> CalendarItemByRecurrenceIdFilter(recurrenceId = filterOptions.recurrenceId)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Calendar Items")
}
