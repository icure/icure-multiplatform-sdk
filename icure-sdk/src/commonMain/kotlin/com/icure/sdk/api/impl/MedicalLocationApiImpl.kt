package com.icure.sdk.api.impl

import com.icure.sdk.api.MedicalLocationApi
import com.icure.sdk.api.raw.RawMedicalLocationApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.mapMedicalLocationFilterOptions
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator

@InternalIcureApi
internal class MedicalLocationApiImpl(
	private val rawApi: RawMedicalLocationApi
) : MedicalLocationApi {
	override suspend fun createMedicalLocation(medicalLocationDto: MedicalLocation): MedicalLocation =
		rawApi.createMedicalLocation(medicalLocationDto).successBody()

	override suspend fun deleteMedicalLocations(locationIds: ListOfIds): List<DocIdentifier> =
		rawApi.deleteMedicalLocations(locationIds).successBody()

	override suspend fun getMedicalLocation(locationId: String): MedicalLocation =
		rawApi.getMedicalLocation(locationId).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getAllMedicalLocations(startDocumentId: String?, limit: Int?): PaginatedList<MedicalLocation> =
		rawApi.getMedicalLocations(startDocumentId, limit).successBody()

	override suspend fun modifyMedicalLocation(medicalLocationDto: MedicalLocation): MedicalLocation =
		rawApi.modifyMedicalLocation(medicalLocationDto).successBody()

	override suspend fun getMedicalLocations(medicalLocationIds: List<String>): List<MedicalLocation> =
		rawApi.getMedicalLocationsByIds(ListOfIds(medicalLocationIds)).successBody()

	override suspend fun matchMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): List<String> =
		rawApi.matchMedicalLocationsBy(mapMedicalLocationFilterOptions(filter)).successBody()

	override suspend fun matchMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): List<String> =
		matchMedicalLocationsBy(filter)

	override suspend fun filterMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): PaginatedListIterator<MedicalLocation> =
		IdsPageIterator(matchMedicalLocationsBy(filter), ::getMedicalLocations)

	override suspend fun filterMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): PaginatedListIterator<MedicalLocation> =
		filterMedicalLocationsBy(filter)
}