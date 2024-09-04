// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.PlaceApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PlaceJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.place_fromJs
import com.icure.cardinal.sdk.js.model.place_toJs
import com.icure.cardinal.sdk.model.Place
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PlaceApiImplJs(
	private val placeApi: PlaceApi,
) : PlaceApiJs {
	override fun getPlace(placeId: String): Promise<PlaceJs> = GlobalScope.promise {
		val placeIdConverted: String = placeId
		val result = placeApi.getPlace(
			placeIdConverted,
		)
		place_toJs(result)
	}

	override fun createPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.createPlace(
			placeConverted,
		)
		place_toJs(result)
	}

	override fun modifyPlace(place: PlaceJs): Promise<PlaceJs> = GlobalScope.promise {
		val placeConverted: Place = place_fromJs(place)
		val result = placeApi.modifyPlace(
			placeConverted,
		)
		place_toJs(result)
	}

	override fun deletePlaces(placeIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val placeIdsConverted: List<String> = arrayToList(
			placeIds,
			"placeIds",
			{ x1: String ->
				x1
			},
		)
		val result = placeApi.deletePlaces(
			placeIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getPlaces(options: dynamic): Promise<PaginatedListJs<PlaceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = placeApi.getPlaces(
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Place ->
					place_toJs(x1)
				},
			)
		}
	}
}
