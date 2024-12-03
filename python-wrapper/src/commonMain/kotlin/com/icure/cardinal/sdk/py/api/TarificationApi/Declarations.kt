// auto-generated file
package com.icure.cardinal.sdk.py.api.TarificationApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
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

@Serializable
private class GetTarificationParams(
	public val tarificationId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTarificationParams>(params)
	runBlocking {
		sdk.tarification.getTarification(
			decodedParams.tarificationId,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTarificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.getTarification(
				decodedParams.tarificationId,
			)
		}.toPyStringAsyncCallback(Tarification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateTarificationParams(
	public val tarification: Tarification,
)

@OptIn(InternalIcureApi::class)
public fun createTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateTarificationParams>(params)
	runBlocking {
		sdk.tarification.createTarification(
			decodedParams.tarification,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateTarificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.createTarification(
				decodedParams.tarification,
			)
		}.toPyStringAsyncCallback(Tarification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTarificationsParams(
	public val tarificationIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getTarificationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTarificationsParams>(params)
	runBlocking {
		sdk.tarification.getTarifications(
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(Tarification.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTarificationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTarificationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.getTarifications(
				decodedParams.tarificationIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Tarification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyTarificationParams(
	public val tarification: Tarification,
)

@OptIn(InternalIcureApi::class)
public fun modifyTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTarificationParams>(params)
	runBlocking {
		sdk.tarification.modifyTarification(
			decodedParams.tarification,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTarificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.modifyTarification(
				decodedParams.tarification,
			)
		}.toPyStringAsyncCallback(Tarification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindTarificationsByLabelParams(
	public val region: String? = null,
	public val types: String? = null,
	public val language: String? = null,
	public val label: String? = null,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findTarificationsByLabelBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindTarificationsByLabelParams>(params)
	runBlocking {
		sdk.tarification.findTarificationsByLabel(
			decodedParams.region,
			decodedParams.types,
			decodedParams.language,
			decodedParams.label,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Tarification.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findTarificationsByLabelAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindTarificationsByLabelParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.findTarificationsByLabel(
				decodedParams.region,
				decodedParams.types,
				decodedParams.language,
				decodedParams.label,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Tarification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindTarificationsByParams(
	public val region: String? = null,
	public val type: String? = null,
	public val tarification: String? = null,
	public val version: String? = null,
	public val startDocumentId: String? = null,
	public val startKey: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findTarificationsByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindTarificationsByParams>(params)
	runBlocking {
		sdk.tarification.findTarificationsBy(
			decodedParams.region,
			decodedParams.type,
			decodedParams.tarification,
			decodedParams.version,
			decodedParams.startDocumentId,
			decodedParams.startKey,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Tarification.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findTarificationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindTarificationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.findTarificationsBy(
				decodedParams.region,
				decodedParams.type,
				decodedParams.tarification,
				decodedParams.version,
				decodedParams.startDocumentId,
				decodedParams.startKey,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Tarification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTarificationWithPartsParams(
	public val type: String,
	public val tarification: String,
	public val version: String,
)

@OptIn(InternalIcureApi::class)
public fun getTarificationWithPartsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTarificationWithPartsParams>(params)
	runBlocking {
		sdk.tarification.getTarificationWithParts(
			decodedParams.type,
			decodedParams.tarification,
			decodedParams.version,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTarificationWithPartsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTarificationWithPartsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.tarification.getTarificationWithParts(
				decodedParams.type,
				decodedParams.tarification,
				decodedParams.version,
			)
		}.toPyStringAsyncCallback(Tarification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
