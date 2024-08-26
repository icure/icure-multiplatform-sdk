// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.TimeTableFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.TimeTableJs
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalTimeTableFiltersObj {
	public fun byAgendaId(agendaId: String): BaseFilterOptionsJs<TimeTableJs> {
		val agendaIdConverted: String = agendaId
		val result = TimeTableFilters.byAgendaId(
			agendaIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPeriodAndAgendaId(agendaId: String, options: dynamic):
			BaseSortableFilterOptionsJs<TimeTableJs> {
		val _options = options ?: js("{}")
		val agendaIdConverted: String = agendaId
		val fromConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToLong(from, "from")
		}
		val toConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToLong(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = TimeTableFilters.byPeriodAndAgendaId(
			agendaIdConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
