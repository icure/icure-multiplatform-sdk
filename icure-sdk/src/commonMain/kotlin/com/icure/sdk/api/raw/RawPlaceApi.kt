package com.icure.sdk.api.raw

import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
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
