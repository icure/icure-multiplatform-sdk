// auto-generated file
package com.icure.cardinal.sdk.py.api.ReceiptBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.ByteArray
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
private class DeleteReceiptParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteReceiptBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteReceiptAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.deleteReceipt(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteReceiptsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteReceiptsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptsParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteReceiptsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteReceiptsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.deleteReceipts(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRawReceiptAttachmentParams(
	public val receiptId: String,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRawReceiptAttachmentBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.getRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRawReceiptAttachmentAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.getRawReceiptAttachment(
				decodedParams.receiptId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetRawReceiptAttachmentParams(
	public val receiptId: String,
	public val rev: String,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	@OptIn(InternalIcureApi::class)
	public val attachment: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun setRawReceiptAttachmentBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.setRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.rev,
			decodedParams.blobType,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setRawReceiptAttachmentAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawReceiptAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.setRawReceiptAttachment(
				decodedParams.receiptId,
				decodedParams.rev,
				decodedParams.blobType,
				decodedParams.attachment,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateReceiptParams(
	public val entity: EncryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun createReceiptBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateReceiptParams>(params)
	runBlocking {
		sdk.receipt.createReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createReceiptAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.createReceipt(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedReceipt.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyReceiptParams(
	public val entity: EncryptedReceipt,
)

@OptIn(InternalIcureApi::class)
public fun modifyReceiptBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyReceiptAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.modifyReceipt(
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
public fun getReceiptBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	runBlocking {
		sdk.receipt.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReceiptAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReceiptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.getReceipt(
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
public fun listByReferenceBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	runBlocking {
		sdk.receipt.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(EncryptedReceipt.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listByReferenceAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListByReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedReceipt.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
