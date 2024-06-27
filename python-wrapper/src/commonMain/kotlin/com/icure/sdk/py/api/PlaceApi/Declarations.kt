// auto-generated file
package com.icure.sdk.py.api.PlaceApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class GetPlaceParams(
	public val placeId: String,
)

public fun getPlaceBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPlaceParams>(params)
	runBlocking {
		sdk.place.getPlace(
			decodedParams.placeId,
		)
	}
}.toPyString(Place.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPlaceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.getPlace(
				decodedParams.placeId,
			)
		}.toPyStringAsyncCallback(Place.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePlaceParams(
	public val place: Place,
)

public fun createPlaceBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePlaceParams>(params)
	runBlocking {
		sdk.place.createPlace(
			decodedParams.place,
		)
	}
}.toPyString(Place.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createPlaceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.createPlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(Place.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPlaceParams(
	public val place: Place,
)

public fun modifyPlaceBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPlaceParams>(params)
	runBlocking {
		sdk.place.modifyPlace(
			decodedParams.place,
		)
	}
}.toPyString(Place.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPlaceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPlaceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.modifyPlace(
				decodedParams.place,
			)
		}.toPyStringAsyncCallback(Place.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePlacesParams(
	public val placeIds: List<String>,
)

public fun deletePlacesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePlacesParams>(params)
	runBlocking {
		sdk.place.deletePlaces(
			decodedParams.placeIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deletePlacesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.deletePlaces(
				decodedParams.placeIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPlacesParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun getPlacesBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPlacesParams>(params)
	runBlocking {
		sdk.place.getPlaces(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Place.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPlacesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPlacesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.place.getPlaces(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Place.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
