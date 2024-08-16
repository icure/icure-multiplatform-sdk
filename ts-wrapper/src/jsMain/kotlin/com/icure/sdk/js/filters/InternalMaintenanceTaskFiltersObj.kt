// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.MaintenanceTaskFilters
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.model.base.Identifier
import kotlin.Array
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalMaintenanceTaskFiltersObj {
	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<MaintenanceTaskJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = MaintenanceTaskFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<MaintenanceTaskJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = MaintenanceTaskFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<MaintenanceTaskJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = MaintenanceTaskFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTypeForDataOwner(dataOwnerId: String, type: String):
			BaseFilterOptionsJs<MaintenanceTaskJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val typeConverted: String = type
		val result = MaintenanceTaskFilters.byTypeForDataOwner(
			dataOwnerIdConverted,
			typeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byTypeForSelf(type: String): FilterOptionsJs<MaintenanceTaskJs> {
		val typeConverted: String = type
		val result = MaintenanceTaskFilters.byTypeForSelf(
			typeConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun afterDateForDataOwner(dataOwnerId: String, date: Double):
			BaseSortableFilterOptionsJs<MaintenanceTaskJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val dateConverted: Long = numberToLong(date, "date")
		val result = MaintenanceTaskFilters.afterDateForDataOwner(
			dataOwnerIdConverted,
			dateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun afterDateForSelf(date: Double): SortableFilterOptionsJs<MaintenanceTaskJs> {
		val dateConverted: Long = numberToLong(date, "date")
		val result = MaintenanceTaskFilters.afterDateForSelf(
			dateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}
}
