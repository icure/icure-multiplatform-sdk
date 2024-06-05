// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.PlaceApi
import com.icure.sdk.js.api.PlaceApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PlaceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.place_toJs
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PlaceApiImplJs(
	private val placeApi: PlaceApi,
) : PlaceApiJs {
	override fun getPlace(placeId: String): Promise<PlaceJs> = GlobalScope.promise {
		place_toJs(placeApi.getPlace(placeId))}


	override fun createPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		place_toJs(placeApi.createPlace(com.icure.sdk.js.model.place_fromJs(place)))}


	override fun modifyPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		place_toJs(placeApi.modifyPlace(com.icure.sdk.js.model.place_fromJs(place)))}


	override fun deletePlaces(placeIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			placeApi.deletePlaces(arrayToList(
				placeIds,
				"placeIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getPlaces(startDocumentId: String?, limit: Double?): Promise<PaginatedListJs<PlaceJs>>
			= GlobalScope.promise {
		paginatedList_toJs(
			placeApi.getPlaces(startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit")),
			{ x1: Place ->
				place_toJs(x1)
			},
		)}

}
