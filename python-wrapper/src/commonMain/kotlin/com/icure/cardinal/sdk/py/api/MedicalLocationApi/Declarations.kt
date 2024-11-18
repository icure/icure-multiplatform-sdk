// auto-generated file
package com.icure.cardinal.sdk.py.api.MedicalLocationApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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

@OptIn(InternalIcureApi::class)
public fun createMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.createMedicalLocation(
			decodedParams.medicalLocationDto,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMedicalLocationParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.deleteMedicalLocations(
			decodedParams.locationIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMedicalLocationsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.getMedicalLocation(
			decodedParams.locationId,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMedicalLocationParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getAllMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.getAllMedicalLocations(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(MedicalLocation.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAllMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllMedicalLocationsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyMedicalLocationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMedicalLocationParams>(params)
	runBlocking {
		sdk.medicalLocation.modifyMedicalLocation(
			decodedParams.medicalLocationDto,
		)
	}
}.toPyString(MedicalLocation.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyMedicalLocationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMedicalLocationParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getMedicalLocationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMedicalLocationsParams>(params)
	runBlocking {
		sdk.medicalLocation.getMedicalLocations(
			decodedParams.medicalLocationIds,
		)
	}
}.toPyString(ListSerializer(MedicalLocation.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMedicalLocationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMedicalLocationsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchMedicalLocationsByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMedicalLocationsByParams>(params)
	runBlocking {
		sdk.medicalLocation.matchMedicalLocationsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMedicalLocationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMedicalLocationsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchMedicalLocationsBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchMedicalLocationsBySortedParams>(params)
	runBlocking {
		sdk.medicalLocation.matchMedicalLocationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMedicalLocationsBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchMedicalLocationsBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterMedicalLocationsByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMedicalLocationsByParams>(params)
	runBlocking {
		sdk.medicalLocation.filterMedicalLocationsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, MedicalLocation.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMedicalLocationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMedicalLocationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.filterMedicalLocationsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, MedicalLocation.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMedicalLocationsBySortedParams(
	public val filter: BaseSortableFilterOptions<MedicalLocation>,
)

@OptIn(InternalIcureApi::class)
public fun filterMedicalLocationsBySortedBlocking(sdk: CardinalNonCryptoApis, params: String):
		PyResult = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMedicalLocationsBySortedParams>(params)
	runBlocking {
		sdk.medicalLocation.filterMedicalLocationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, MedicalLocation.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMedicalLocationsBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterMedicalLocationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.medicalLocation.filterMedicalLocationsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, MedicalLocation.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
