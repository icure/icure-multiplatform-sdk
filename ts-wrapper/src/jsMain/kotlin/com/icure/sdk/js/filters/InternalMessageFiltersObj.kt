// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.MessageFilters
import com.icure.sdk.js.model.MessageJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalMessageFiltersObj {
	public fun allMessagesForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = MessageFilters.allMessagesForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allMessagesForSelf(): FilterOptionsJs<MessageJs> {
		val result = MessageFilters.allMessagesForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTransportGuidDateForDataOwner(dataOwnerId: String, transportGuid: String):
			BaseSortableFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidDateForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidDate(transportGuid: String): SortableFilterOptionsJs<MessageJs> {
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidDate(
			transportGuidConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}
}
