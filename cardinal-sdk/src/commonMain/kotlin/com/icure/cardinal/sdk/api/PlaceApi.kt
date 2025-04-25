package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

interface PlaceApi {
	suspend fun getPlace(placeId: String): Place?
	suspend fun createPlace(place: Place): Place
	suspend fun modifyPlace(place: Place): Place
	suspend fun deletePlaces(placeIds: List<String>): List<DocIdentifier>
	@Deprecated("Will be replaced by filters")
	suspend fun getPlaces(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Place>
}

