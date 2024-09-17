// auto-generated file
package com.icure.cardinal.sdk.py.api.ReceiptApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.model.EncryptedReceipt
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val receipt: EncryptedReceipt,
	public val options: ReceiptShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.receipt.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.receipt,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

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
			sdk.receipt.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.receipt,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val receipt: EncryptedReceipt,
	public val delegates: Map<String, ReceiptShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.receipt.encrypted.shareWithMany(
			decodedParams.receipt,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

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
			sdk.receipt.encrypted.shareWithMany(
				decodedParams.receipt,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyReceiptParams(
	public val entity: EncryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun modifyReceiptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.encrypted.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

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
			sdk.receipt.encrypted.modifyReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
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
		sdk.receipt.encrypted.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

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
			sdk.receipt.encrypted.getReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
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
		sdk.receipt.encrypted.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(EncryptedReceipt.serializer()))

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
			sdk.receipt.encrypted.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedReceipt.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
