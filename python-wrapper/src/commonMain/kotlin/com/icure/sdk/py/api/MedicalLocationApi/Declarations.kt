// auto-generated file
package com.icure.sdk.py.api.MedicalLocationApi

import com.icure.sdk.CardinalNonCryptoApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
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
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateMedicalLocationParams(
	public val medicalLocationDto: MedicalLocation,
)

public fun createMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.createMedicalLocation(
			decodedParams.medicalLocationDto,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateMedicalLocationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.createMedicalLocation(
				decodedParams.medicalLocationDto,
			)
		}.toPyStringAsyncCallback(MedicalLocation.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMedicalLocationsParams(
	public val locationIds: ListOfIds,
)

public fun deleteMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.deleteMedicalLocations(
			decodedParams.locationIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMedicalLocationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.deleteMedicalLocations(
				decodedParams.locationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMedicalLocationParams(
	public val locationId: String,
)

public fun getMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.getMedicalLocation(
			decodedParams.locationId,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMedicalLocationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.getMedicalLocation(
				decodedParams.locationId,
			)
		}.toPyStringAsyncCallback(MedicalLocation.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAllMedicalLocationsParams(
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun getAllMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAllMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.getAllMedicalLocations(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(MedicalLocation.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAllMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAllMedicalLocationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.getAllMedicalLocations(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MedicalLocation.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyMedicalLocationParams(
	public val medicalLocationDto: MedicalLocation,
)

public fun modifyMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.modifyMedicalLocation(
			decodedParams.medicalLocationDto,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMedicalLocationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.modifyMedicalLocation(
				decodedParams.medicalLocationDto,
			)
		}.toPyStringAsyncCallback(MedicalLocation.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMedicalLocationsParams(
	public val medicalLocationIds: List<String>,
)

public fun getMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.getMedicalLocations(
			decodedParams.medicalLocationIds,
		)
	}
}.toPyString(ListSerializer(MedicalLocation.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMedicalLocationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.getMedicalLocations(
				decodedParams.medicalLocationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(MedicalLocation.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMedicalLocationsByParams(
	public val filter: BaseFilterOptions<MedicalLocation>,
)

public fun matchMedicalLocationsByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMedicalLocationsByParams>(params)
	runBlocking {
		sdk.medicalLocation.matchMedicalLocationsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchMedicalLocationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMedicalLocationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.matchMedicalLocationsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMedicalLocationsBySortedParams(
	public val filter: BaseSortableFilterOptions<MedicalLocation>,
)

public fun matchMedicalLocationsBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMedicalLocationsBySortedParams>(params)
	runBlocking {
		sdk.medicalLocation.matchMedicalLocationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchMedicalLocationsBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMedicalLocationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.matchMedicalLocationsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMedicalLocationsByParams(
	public val filter: BaseFilterOptions<MedicalLocation>,
)

public fun filterMedicalLocationsByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMedicalLocationsByParams>(params)
	runBlocking {
		sdk.medicalLocation.filterMedicalLocationsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MedicalLocation.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMedicalLocationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMedicalLocationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.filterMedicalLocationsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MedicalLocation.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMedicalLocationsBySortedParams(
	public val filter: BaseSortableFilterOptions<MedicalLocation>,
)

public fun filterMedicalLocationsBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMedicalLocationsBySortedParams>(params)
	runBlocking {
		sdk.medicalLocation.filterMedicalLocationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MedicalLocation.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMedicalLocationsBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMedicalLocationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.filterMedicalLocationsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MedicalLocation.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
