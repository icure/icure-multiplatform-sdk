// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.MedicalLocationApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.MedicalLocationApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.MedicalLocationJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.listOfIds_fromJs
import com.icure.sdk.js.model.medicalLocation_fromJs
import com.icure.sdk.js.model.medicalLocation_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class MedicalLocationApiImplJs(
	private val medicalLocationApi: MedicalLocationApi,
) : MedicalLocationApiJs {
	override fun createMedicalLocation(medicalLocationDto: MedicalLocationJs):
			Promise<MedicalLocationJs> = GlobalScope.promise {
		val medicalLocationDtoConverted: MedicalLocation = medicalLocation_fromJs(medicalLocationDto)
		val result = medicalLocationApi.createMedicalLocation(
			medicalLocationDtoConverted,
		)
		medicalLocation_toJs(result)
	}

	override fun deleteMedicalLocations(locationIds: ListOfIdsJs): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val locationIdsConverted: ListOfIds = listOfIds_fromJs(locationIds)
		val result = medicalLocationApi.deleteMedicalLocations(
			locationIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getMedicalLocation(locationId: String): Promise<MedicalLocationJs> =
			GlobalScope.promise {
		val locationIdConverted: String = locationId
		val result = medicalLocationApi.getMedicalLocation(
			locationIdConverted,
		)
		medicalLocation_toJs(result)
	}

	override fun getAllMedicalLocations(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<MedicalLocationJs>> = GlobalScope.promise {
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = medicalLocationApi.getAllMedicalLocations(
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: MedicalLocation ->
				medicalLocation_toJs(x1)
			},
		)
	}

	override fun modifyMedicalLocation(medicalLocationDto: MedicalLocationJs):
			Promise<MedicalLocationJs> = GlobalScope.promise {
		val medicalLocationDtoConverted: MedicalLocation = medicalLocation_fromJs(medicalLocationDto)
		val result = medicalLocationApi.modifyMedicalLocation(
			medicalLocationDtoConverted,
		)
		medicalLocation_toJs(result)
	}

	override fun getMedicalLocations(medicalLocationIds: Array<String>):
			Promise<Array<MedicalLocationJs>> = GlobalScope.promise {
		val medicalLocationIdsConverted: List<String> = arrayToList(
			medicalLocationIds,
			"medicalLocationIds",
			{ x1: String ->
				x1
			},
		)
		val result = medicalLocationApi.getMedicalLocations(
			medicalLocationIdsConverted,
		)
		listToArray(
			result,
			{ x1: MedicalLocation ->
				medicalLocation_toJs(x1)
			},
		)
	}

	override fun matchMedicalLocationsBy(filter: BaseFilterOptionsJs<MedicalLocationJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MedicalLocation> = baseFilterOptions_fromJs(filter)
		val result = medicalLocationApi.matchMedicalLocationsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMedicalLocationsBySorted(filter: BaseSortableFilterOptionsJs<MedicalLocationJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MedicalLocation> =
				baseSortableFilterOptions_fromJs(filter)
		val result = medicalLocationApi.matchMedicalLocationsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterMedicalLocationsBy(filter: BaseFilterOptionsJs<MedicalLocationJs>):
			Promise<PaginatedListIteratorJs<MedicalLocationJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<MedicalLocation> = baseFilterOptions_fromJs(filter)
		val result = medicalLocationApi.filterMedicalLocationsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: MedicalLocation ->
				medicalLocation_toJs(x1)
			},
		)
	}

	override
			fun filterMedicalLocationsBySorted(filter: BaseSortableFilterOptionsJs<MedicalLocationJs>):
			Promise<PaginatedListIteratorJs<MedicalLocationJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<MedicalLocation> =
				baseSortableFilterOptions_fromJs(filter)
		val result = medicalLocationApi.filterMedicalLocationsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: MedicalLocation ->
				medicalLocation_toJs(x1)
			},
		)
	}
}
