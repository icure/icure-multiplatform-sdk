// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.MedicalLocationJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MedicalLocationApi")
public external interface MedicalLocationApiJs {
	public fun createMedicalLocation(medicalLocationDto: MedicalLocationJs): Promise<MedicalLocationJs>

	public fun deleteMedicalLocations(locationIds: ListOfIdsJs): Promise<Array<DocIdentifierJs>>

	public fun getMedicalLocation(locationId: String): Promise<MedicalLocationJs?>

	public fun getAllMedicalLocations(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<MedicalLocationJs>>

	public fun modifyMedicalLocation(medicalLocationDto: MedicalLocationJs): Promise<MedicalLocationJs>

	public fun getMedicalLocations(medicalLocationIds: Array<String>):
			Promise<Array<MedicalLocationJs>>

	public fun matchMedicalLocationsBy(filter: BaseFilterOptionsJs<MedicalLocationJs>):
			Promise<Array<String>>

	public fun matchMedicalLocationsBySorted(filter: BaseSortableFilterOptionsJs<MedicalLocationJs>):
			Promise<Array<String>>

	public fun filterMedicalLocationsBy(filter: BaseFilterOptionsJs<MedicalLocationJs>):
			Promise<PaginatedListIteratorJs<MedicalLocationJs>>

	public fun filterMedicalLocationsBySorted(filter: BaseSortableFilterOptionsJs<MedicalLocationJs>):
			Promise<PaginatedListIteratorJs<MedicalLocationJs>>
}
