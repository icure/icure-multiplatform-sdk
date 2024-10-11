// auto-generated file
package com.icure.cardinal.sdk.py.api.ReceiptApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val receipt: Receipt,
	public val options: ReceiptShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.receipt,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.receipt,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val receipt: Receipt,
	public val delegates: Map<String, ReceiptShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.shareWithMany(
			decodedParams.receipt,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.shareWithMany(
				decodedParams.receipt,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyReceiptParams(
	public val entity: Receipt,
)

@OptIn(InternalIcureApi::class)
public fun modifyReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.modifyReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReceiptParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(Receipt::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReceiptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.getReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Receipt::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListByReferenceParams(
	public val reference: String,
)

@OptIn(InternalIcureApi::class)
public fun listByReferenceBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Receipt::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listByReferenceAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Receipt::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
