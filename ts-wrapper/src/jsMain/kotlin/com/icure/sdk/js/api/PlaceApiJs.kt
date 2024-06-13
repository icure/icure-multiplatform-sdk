// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PlaceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PlaceApi")
public external interface PlaceApiJs {
	public fun getPlace(placeId: String): Promise<PlaceJs>

	public fun createPlace(place: PlaceJs): Promise<PlaceJs>

	public fun modifyPlace(place: PlaceJs): Promise<PlaceJs>

	public fun deletePlaces(placeIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getPlaces(options: dynamic): Promise<PaginatedListJs<PlaceJs>>
}
