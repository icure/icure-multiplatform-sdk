package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPlaceApi
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

interface PlaceApi {
	suspend fun getPlace(placeId: String): Place
	suspend fun createPlace(place: Place): Place
	suspend fun modifyPlace(place: Place): Place
	suspend fun deletePlaces(placeIds: List<String>): List<DocIdentifier>
	suspend fun getPlaces(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Place>
}

@InternalIcureApi
internal class PlaceApiImpl(
	private val rawApi: RawPlaceApi,
) : PlaceApi {
	override suspend fun getPlace(placeId: String) = rawApi.getPlace(placeId).successBody()

	override suspend fun createPlace(place: Place) =
		rawApi.createPlace(place).successBody()

	override suspend fun modifyPlace(place: Place) = rawApi.modifyPlace(place).successBody()

	override suspend fun deletePlaces(placeIds: List<String>) = rawApi.deletePlaces(ListOfIds(placeIds)).successBody()
	override suspend fun getPlaces(
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.getPlaces(startDocumentId, limit).successBody()
}

