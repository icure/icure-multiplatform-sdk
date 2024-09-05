package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPlaceApi {
	// region common endpoints

	suspend fun createPlace(placeDto: Place): HttpResponse<Place>

	suspend fun deletePlaces(placeIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun getPlace(placeId: String): HttpResponse<Place>

	suspend fun getPlaces(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Place>>

	suspend fun modifyPlace(placeDto: Place): HttpResponse<Place>
	// endregion
}
