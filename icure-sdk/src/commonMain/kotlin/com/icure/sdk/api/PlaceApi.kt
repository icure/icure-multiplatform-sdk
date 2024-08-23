package com.icure.sdk.api

import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue

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

