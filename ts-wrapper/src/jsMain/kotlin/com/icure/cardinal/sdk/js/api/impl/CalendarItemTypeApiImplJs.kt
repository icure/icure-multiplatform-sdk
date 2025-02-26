// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.js.api.CalendarItemTypeApiJs
import com.icure.cardinal.sdk.js.model.CalendarItemTypeJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.calendarItemType_fromJs
import com.icure.cardinal.sdk.js.model.calendarItemType_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.listOfIds_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CalendarItemTypeApiImplJs(
	private val calendarItemTypeApi: CalendarItemTypeApi,
) : CalendarItemTypeApiJs {
	override fun getCalendarItemTypes(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<CalendarItemTypeJs>> = GlobalScope.promise {
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = calendarItemTypeApi.getCalendarItemTypes(
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun getCalendarItemTypesIncludingDeleted(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<CalendarItemTypeJs>> = GlobalScope.promise {
		val startKeyConverted: String? = undefinedToNull(startKey)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = calendarItemTypeApi.getCalendarItemTypesIncludingDeleted(
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun createCalendarItemType(calendarItemTypeDto: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val calendarItemTypeDtoConverted: CalendarItemType = calendarItemType_fromJs(calendarItemTypeDto)
		val result = calendarItemTypeApi.createCalendarItemType(
			calendarItemTypeDtoConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIdsJs):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val calendarItemTypeIdsConverted: ListOfIds = listOfIds_fromJs(calendarItemTypeIds)
		val result = calendarItemTypeApi.deleteCalendarItemTypes(
			calendarItemTypeIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getCalendarItemType(calendarItemTypeId: String): Promise<CalendarItemTypeJs> =
			GlobalScope.promise {
		val calendarItemTypeIdConverted: String = calendarItemTypeId
		val result = calendarItemTypeApi.getCalendarItemType(
			calendarItemTypeIdConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val calendarItemTypeDtoConverted: CalendarItemType = calendarItemType_fromJs(calendarItemTypeDto)
		val result = calendarItemTypeApi.modifyCalendarItemType(
			calendarItemTypeDtoConverted,
		)
		calendarItemType_toJs(result)
	}
}
