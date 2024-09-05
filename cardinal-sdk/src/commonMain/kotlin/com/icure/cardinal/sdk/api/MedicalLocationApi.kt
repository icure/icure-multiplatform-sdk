package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface MedicalLocationApi {
	suspend fun createMedicalLocation(medicalLocationDto: MedicalLocation): MedicalLocation

	suspend fun deleteMedicalLocations(locationIds: ListOfIds): List<DocIdentifier>

	suspend fun getMedicalLocation(locationId: String): MedicalLocation

	@Deprecated("Use filter instead")
	suspend fun getAllMedicalLocations(
		startDocumentId: String? = null,
		limit: Int? = null
	): PaginatedList<MedicalLocation>

	suspend fun modifyMedicalLocation(medicalLocationDto: MedicalLocation): MedicalLocation

	suspend fun getMedicalLocations(medicalLocationIds: List<String>): List<MedicalLocation>

	suspend fun matchMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): List<String>

	suspend fun matchMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): List<String>

	suspend fun filterMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): PaginatedListIterator<MedicalLocation>

	suspend fun filterMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): PaginatedListIterator<MedicalLocation>
}