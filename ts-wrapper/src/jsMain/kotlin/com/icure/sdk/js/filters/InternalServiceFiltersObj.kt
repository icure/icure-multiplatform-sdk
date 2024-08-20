// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.ServiceFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import kotlin.Array
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalServiceFiltersObj {
	public fun allServicesForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = ServiceFilters.allServicesForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allServicesForSelf(): FilterOptionsJs<ServiceJs> {
		val result = ServiceFilters.allServicesForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ServiceFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndValueDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byCodeAndValueDateForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndValueDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val dataOwnerIdConverted: String = dataOwnerId
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byTagAndValueDateForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwner(dataOwnerId: String, patients: Array<PatientJs>):
			SortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ServiceFilters.byPatientsForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwner(dataOwnerId: String, secretIds: Array<String>):
			BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byPatientsSecretIdsForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byHealthElementIdFromSubcontactForDataOwner(dataOwnerId: String,
			healthElementIds: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val healthElementIdsConverted: List<String> = arrayToList(
			healthElementIds,
			"healthElementIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byHealthElementIdFromSubcontactForDataOwner(
			dataOwnerIdConverted,
			healthElementIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<ServiceJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ServiceFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndValueDateForSelf(codeType: String, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byCodeAndValueDateForSelf(
			codeTypeConverted,
			codeCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndValueDateForSelf(tagType: String, options: dynamic):
			SortableFilterOptionsJs<ServiceJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfServiceValueDate",
			null
		) { startOfServiceValueDate: Double? ->
			numberToLong(startOfServiceValueDate, "startOfServiceValueDate")
		}
		val endOfServiceValueDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfServiceValueDate",
			null
		) { endOfServiceValueDate: Double? ->
			numberToLong(endOfServiceValueDate, "endOfServiceValueDate")
		}
		val result = ServiceFilters.byTagAndValueDateForSelf(
			tagTypeConverted,
			tagCodeConverted,
			startOfServiceValueDateConverted,
			endOfServiceValueDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForSelf(patients: Array<PatientJs>): SortableFilterOptionsJs<ServiceJs> {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ServiceFilters.byPatientsForSelf(
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForSelf(secretIds: Array<String>):
			SortableFilterOptionsJs<ServiceJs> {
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byPatientsSecretIdsForSelf(
			secretIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byHealthElementIdFromSubcontactForSelf(healthElementIds: Array<String>):
			SortableFilterOptionsJs<ServiceJs> {
		val healthElementIdsConverted: List<String> = arrayToList(
			healthElementIds,
			"healthElementIds",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byHealthElementIdFromSubcontactForSelf(
			healthElementIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<ServiceJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = ServiceFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
