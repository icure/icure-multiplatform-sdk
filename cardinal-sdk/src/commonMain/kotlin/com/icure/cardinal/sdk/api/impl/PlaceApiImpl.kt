package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.raw.RawPlaceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Place
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class PlaceApiImpl(
	private val rawApi: RawPlaceApi,
) : PlaceApi {
	override suspend fun getPlace(placeId: String) = rawApi.getPlace(placeId).successBody()

	override suspend fun createPlace(place: Place) =
		rawApi.createPlace(place).successBody()

	override suspend fun modifyPlace(place: Place) = rawApi.modifyPlace(place).successBodyOrThrowRevisionConflict()

	override suspend fun deletePlaces(placeIds: List<String>) = rawApi.deletePlaces(ListOfIds(placeIds)).successBody()
	override suspend fun getPlaces(
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.getPlaces(startDocumentId, limit).successBody()
}