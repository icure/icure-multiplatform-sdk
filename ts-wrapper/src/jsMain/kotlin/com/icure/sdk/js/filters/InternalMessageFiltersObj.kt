// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.MessageFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.model.Patient
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.JsExport
import kotlinx.datetime.Instant

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

	public fun byTransportGuidForDataOwner(dataOwnerId: String, transportGuid: String):
			BaseSortableFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidForSelf(transportGuid: String): SortableFilterOptionsJs<MessageJs> {
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.byTransportGuidForSelf(
			transportGuidConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun fromAddressForDataOwner(dataOwnerId: String, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val addressConverted: String = address
		val result = MessageFilters.fromAddressForDataOwner(
			dataOwnerIdConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun fromAddressForSelf(address: String): FilterOptionsJs<MessageJs> {
		val addressConverted: String = address
		val result = MessageFilters.fromAddressForSelf(
			addressConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byPatientsSentDateForDataOwner(
		dataOwnerId: String,
		patients: Array<PatientJs>,
		options: dynamic,
	): SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byPatientsSentDateForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSentDateForSelf(patients: Array<PatientJs>, options: dynamic):
			SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byPatientsSentDateForSelf(
			patientsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsSentDateForDataOwner(
		dataOwnerId: String,
		secretIds: Array<String>,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byPatientSecretIdsSentDateForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientSecretIdsSentDateForSelf(secretIds: Array<String>, options: dynamic):
			SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val fromConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"from",
			null
		) { from: Double? ->
			numberToInstant(from, "from")
		}
		val toConverted: Instant? = convertingOptionOrDefaultNullable(
			_options,
			"to",
			null
		) { to: Double? ->
			numberToInstant(to, "to")
		}
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byPatientSecretIdsSentDateForSelf(
			secretIdsConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun toAddressForDataOwner(dataOwnerId: String, address: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val addressConverted: String = address
		val result = MessageFilters.toAddressForDataOwner(
			dataOwnerIdConverted,
			addressConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun toAddressForSelf(address: String): FilterOptionsJs<MessageJs> {
		val addressConverted: String = address
		val result = MessageFilters.toAddressForSelf(
			addressConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byTransportGuidSentDateForDataOwner(
		dataOwnerId: String,
		transportGuid: String,
		from: Double,
		to: Double,
		options: dynamic,
	): BaseSortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val fromConverted: Instant = numberToInstant(from, "from")
		val toConverted: Instant = numberToInstant(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byTransportGuidSentDateForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTransportGuidSentDateForSelf(
		transportGuid: String,
		from: Double,
		to: Double,
		options: dynamic,
	): SortableFilterOptionsJs<MessageJs> {
		val _options = options ?: js("{}")
		val transportGuidConverted: String = transportGuid
		val fromConverted: Instant = numberToInstant(from, "from")
		val toConverted: Instant = numberToInstant(to, "to")
		val descendingConverted: Boolean = convertingOptionOrDefaultNonNull(
			_options,
			"descending",
			false
		) { descending: Boolean ->
			descending
		}
		val result = MessageFilters.byTransportGuidSentDateForSelf(
			transportGuidConverted,
			fromConverted,
			toConverted,
			descendingConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun latestByTransportGuidForDataOwner(dataOwnerId: String, transportGuid: String):
			BaseFilterOptionsJs<MessageJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.latestByTransportGuidForDataOwner(
			dataOwnerIdConverted,
			transportGuidConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun latestByTransportGuidForSelf(transportGuid: String): FilterOptionsJs<MessageJs> {
		val transportGuidConverted: String = transportGuid
		val result = MessageFilters.latestByTransportGuidForSelf(
			transportGuidConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byInvoiceIds(invoiceIds: Array<String>): BaseFilterOptionsJs<MessageJs> {
		val invoiceIdsConverted: Set<String> = arrayToSet(
			invoiceIds,
			"invoiceIds",
			{ x1: String ->
				x1
			},
		)
		val result = MessageFilters.byInvoiceIds(
			invoiceIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byParentIds(parentIds: Array<String>): BaseFilterOptionsJs<MessageJs> {
		val parentIdsConverted: List<String> = arrayToList(
			parentIds,
			"parentIds",
			{ x1: String ->
				x1
			},
		)
		val result = MessageFilters.byParentIds(
			parentIdsConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
