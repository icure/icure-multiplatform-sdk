// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.CalendarItemFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CalendarItemJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.model.Patient
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalCalendarItemFiltersObj {
	public fun byPatientsStartTimeForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
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
		val result = CalendarItemFilters.byPatientsStartTimeForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsStartTimeForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
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
		val result = CalendarItemFilters.byPatientsStartTimeForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsStartTimeForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
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
		val result = CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsStartTimeForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
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
		val result = CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPeriodAndAgenda(
		agendaId: String,
		from: Double,
		to: Double,
		options: dynamic,
	): BaseSortableFilterOptionsJs<CalendarItemJs> {
		val _options = options ?: js("{}")
		val agendaIdConverted: String = agendaId
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = CalendarItemFilters.byPeriodAndAgenda(
			agendaIdConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPeriodForDataOwner(
		dataOwnerId: String,
		from: Double,
		to: Double,
	): BaseFilterOptionsJs<CalendarItemJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = CalendarItemFilters.byPeriodForDataOwner(
			dataOwnerIdConverted,
			fromConverted,
			toConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPeriodForSelf(from: Double, to: Double): FilterOptionsJs<CalendarItemJs> {
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = CalendarItemFilters.byPeriodForSelf(
			fromConverted,
			toConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byRecurrenceId(recurrenceId: String): FilterOptionsJs<CalendarItemJs> {
		val recurrenceIdConverted: String = recurrenceId
		val result = CalendarItemFilters.byRecurrenceId(
			recurrenceIdConverted,
		)
		return FilterOptionsJsImpl(result)
	}
}
