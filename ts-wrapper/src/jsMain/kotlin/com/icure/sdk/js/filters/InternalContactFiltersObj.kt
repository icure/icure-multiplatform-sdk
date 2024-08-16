// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.ContactFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
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
public object InternalContactFiltersObj {
	public fun allContactsForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = ContactFilters.allContactsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allContactsForSelf(): FilterOptionsJs<ContactJs> {
		val result = ContactFilters.allContactsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			SortableFilterOptionsJs<ContactJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ContactFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = ContactFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndOpeningDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
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
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byCodeAndOpeningDateForDataOwner(
			dataOwnerIdConverted,
			codeTypeConverted,
			codeCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byCodeAndOpeningDateForSelf(codeType: String, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val codeTypeConverted: String = codeType
		val codeCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"codeCode",
			null
		) { codeCode: String? ->
			undefinedToNull(codeCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byCodeAndOpeningDateForSelf(
			codeTypeConverted,
			codeCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndOpeningDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		options: dynamic,
	): BaseSortableFilterOptionsJs<ContactJs> {
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
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byTagAndOpeningDateForDataOwner(
			dataOwnerIdConverted,
			tagTypeConverted,
			tagCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byTagAndOpeningDateForSelf(tagType: String, options: dynamic):
			SortableFilterOptionsJs<ContactJs> {
		val _options = options ?: js("{}")
		val tagTypeConverted: String = tagType
		val tagCodeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"tagCode",
			null
		) { tagCode: String? ->
			undefinedToNull(tagCode)
		}
		val startOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"startOfContactOpeningDate",
			null
		) { startOfContactOpeningDate: Double? ->
			numberToLong(startOfContactOpeningDate, "startOfContactOpeningDate")
		}
		val endOfContactOpeningDateConverted: Long? = convertingOptionOrDefaultNullable(
			_options,
			"endOfContactOpeningDate",
			null
		) { endOfContactOpeningDate: Double? ->
			numberToLong(endOfContactOpeningDate, "endOfContactOpeningDate")
		}
		val result = ContactFilters.byTagAndOpeningDateForSelf(
			tagTypeConverted,
			tagCodeConverted,
			startOfContactOpeningDateConverted,
			endOfContactOpeningDateConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForDataOwner(dataOwnerId: String, patients: Array<PatientJs>):
			SortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ContactFilters.byPatientsForDataOwner(
			dataOwnerIdConverted,
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsForSelf(patients: Array<PatientJs>): SortableFilterOptionsJs<ContactJs> {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = ContactFilters.byPatientsForSelf(
			patientsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForDataOwner(dataOwnerId: String, secretIds: Array<String>):
			BaseSortableFilterOptionsJs<ContactJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byPatientsSecretIdsForDataOwner(
			dataOwnerIdConverted,
			secretIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientsSecretIdsForSelf(secretIds: Array<String>):
			SortableFilterOptionsJs<ContactJs> {
		val secretIdsConverted: List<String> = arrayToList(
			secretIds,
			"secretIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byPatientsSecretIdsForSelf(
			secretIdsConverted,
		)
		return SortableFilterOptionsJsImpl(result)
	}

	public fun byServiceIds(serviceIds: Array<String>): BaseSortableFilterOptionsJs<ContactJs> {
		val serviceIdsConverted: List<String> = arrayToList(
			serviceIds,
			"serviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = ContactFilters.byServiceIds(
			serviceIdsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
