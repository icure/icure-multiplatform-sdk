// auto-generated file
package com.icure.sdk.py.api.TarificationApi

import com.icure.sdk.CardinalNonCryptoApis
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
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
private class GetTarificationParams(
	public val tarificationId: String,
)

public fun getTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationParams>(params)
	runBlocking {
		sdk.tarification.getTarification(
			decodedParams.tarificationId,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationParams>(params)
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

public fun createTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateTarificationParams>(params)
	runBlocking {
		sdk.tarification.createTarification(
			decodedParams.tarification,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateTarificationParams>(params)
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

public fun getTarificationsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationsParams>(params)
	runBlocking {
		sdk.tarification.getTarifications(
			decodedParams.tarificationIds,
		)
	}
}.toPyString(ListSerializer(Tarification.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTarificationsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationsParams>(params)
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

public fun modifyTarificationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTarificationParams>(params)
	runBlocking {
		sdk.tarification.modifyTarification(
			decodedParams.tarification,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyTarificationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTarificationParams>(params)
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

public fun findTarificationsByLabelBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindTarificationsByLabelParams>(params)
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

@OptIn(ExperimentalForeignApi::class)
public fun findTarificationsByLabelAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindTarificationsByLabelParams>(params)
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

public fun findTarificationsByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindTarificationsByParams>(params)
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

@OptIn(ExperimentalForeignApi::class)
public fun findTarificationsByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindTarificationsByParams>(params)
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

public fun getTarificationWithPartsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationWithPartsParams>(params)
	runBlocking {
		sdk.tarification.getTarificationWithParts(
			decodedParams.type,
			decodedParams.tarification,
			decodedParams.version,
		)
	}
}.toPyString(Tarification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTarificationWithPartsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTarificationWithPartsParams>(params)
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
