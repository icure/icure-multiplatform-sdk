// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CalendarItemBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.CalendarItemBasicApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.calendarItem_fromJs
import com.icure.cardinal.sdk.js.model.calendarItem_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CalendarItemBasicApiImplJs(
	private val calendarItemBasicApi: CalendarItemBasicApi,
) : CalendarItemBasicApiJs {
	override fun matchCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.matchCalendarItemsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<CalendarItem> =
				baseSortableFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.matchCalendarItemsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<CalendarItem> = baseFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.filterCalendarItemsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<CalendarItem> =
				baseSortableFilterOptions_fromJs(filter)
		val result = calendarItemBasicApi.filterCalendarItemsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemBasicApi.deleteCalendarItemUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItemsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = calendarItemBasicApi.deleteCalendarItemById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItemsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItemById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		calendarItemBasicApi.purgeCalendarItemById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemBasicApi.deleteCalendarItem(
			calendarItemConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<CalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: CalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemBasicApi.deleteCalendarItems(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		calendarItemBasicApi.purgeCalendarItem(
			calendarItemConverted,
		)

	}

	override fun undeleteCalendarItemById(id: String, rev: String): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = calendarItemBasicApi.undeleteCalendarItemById(
			idConverted,
			revConverted,
		)
		calendarItem_toJs(result)
	}

	override fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemBasicApi.undeleteCalendarItem(
			calendarItemConverted,
		)
		calendarItem_toJs(result)
	}

	override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemBasicApi.modifyCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemBasicApi.getCalendarItem(
			entityIdConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemBasicApi.getCalendarItems(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val hcPartyIdConverted: String = hcPartyId
		val result = calendarItemBasicApi.getCalendarItemsByPeriodAndHcPartyId(
			startDateConverted,
			endDateConverted,
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = calendarItemBasicApi.getCalendarsByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val recurrenceIdConverted: String = recurrenceId
		val startKeyConverted: String? = undefinedToNull(startKey)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int = numberToInt(limit, "limit")
		val result = calendarItemBasicApi.findCalendarItemsByRecurrenceId(
			recurrenceIdConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<CalendarItemJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedCalendarItemJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = calendarItemBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}
}
