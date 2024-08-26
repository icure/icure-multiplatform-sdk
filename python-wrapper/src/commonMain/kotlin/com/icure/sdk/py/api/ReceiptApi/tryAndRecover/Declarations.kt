// auto-generated file
package com.icure.sdk.py.api.ReceiptApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.ReceiptShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.Receipt
import com.icure.sdk.py.serialization.ReceiptSerializer
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val receipt: Receipt,
	public val options: ReceiptShareOptions? = null,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.receipt,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(ReceiptSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.receipt,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(ReceiptSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val receipt: Receipt,
	public val delegates: Map<String, ReceiptShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.tryShareWithMany(
			decodedParams.receipt,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(ReceiptSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.tryShareWithMany(
				decodedParams.receipt,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(ReceiptSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val receipt: Receipt,
	public val delegates: Map<String, ReceiptShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.shareWithMany(
			decodedParams.receipt,
			decodedParams.delegates,
		)
	}
}.toPyString(ReceiptSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.shareWithMany(
				decodedParams.receipt,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(ReceiptSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyReceiptParams(
	public val entity: Receipt,
)

public fun modifyReceiptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(ReceiptSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyReceiptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.modifyReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(ReceiptSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReceiptParams(
	public val entityId: String,
)

public fun getReceiptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReceiptParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(ReceiptSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getReceiptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.getReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(ReceiptSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListByReferenceParams(
	public val reference: String,
)

public fun listByReferenceBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListByReferenceParams>(params)
	runBlocking {
		sdk.receipt.tryAndRecover.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(ReceiptSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listByReferenceAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListByReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.tryAndRecover.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(ReceiptSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
