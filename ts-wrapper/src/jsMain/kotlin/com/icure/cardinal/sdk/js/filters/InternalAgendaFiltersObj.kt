// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.AgendaFilters
import com.icure.cardinal.sdk.js.model.AgendaJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalAgendaFiltersObj {
	public fun all(): BaseFilterOptionsJs<AgendaJs> {
		val result = AgendaFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byUser(userId: String): BaseFilterOptionsJs<AgendaJs> {
		val userIdConverted: String = userId
		val result = AgendaFilters.byUser(
			userIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun readableByUser(userId: String): BaseFilterOptionsJs<AgendaJs> {
		val userIdConverted: String = userId
		val result = AgendaFilters.readableByUser(
			userIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
