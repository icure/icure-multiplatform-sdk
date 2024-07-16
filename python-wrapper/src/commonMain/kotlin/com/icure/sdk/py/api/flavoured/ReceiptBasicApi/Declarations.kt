// auto-generated file
package com.icure.sdk.py.api.flavoured.ReceiptBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.ByteArray
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
private class DeleteReceiptParams(
	public val entityId: String,
)

public fun deleteReceiptBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteReceiptParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteReceiptAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteReceiptParams>(params)
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

public fun deleteReceiptsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteReceiptsParams>(params)
	runBlocking {
		sdk.receipt.deleteReceipts(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteReceiptsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteReceiptsParams>(params)
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

public fun getRawReceiptAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.getRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getRawReceiptAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawReceiptAttachmentParams>(params)
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
	public val attachment: ByteArray,
)

public fun setRawReceiptAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawReceiptAttachmentParams>(params)
	runBlocking {
		sdk.receipt.setRawReceiptAttachment(
			decodedParams.receiptId,
			decodedParams.rev,
			decodedParams.blobType,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setRawReceiptAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawReceiptAttachmentParams>(params)
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
private class ModifyReceiptParams(
	public val entity: EncryptedReceipt,
)

public fun modifyReceiptBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyReceiptParams>(params)
	runBlocking {
		sdk.receipt.modifyReceipt(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyReceiptAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyReceiptParams>(params)
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

public fun getReceiptBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReceiptParams>(params)
	runBlocking {
		sdk.receipt.getReceipt(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedReceipt.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getReceiptAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReceiptParams>(params)
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

public fun listByReferenceBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListByReferenceParams>(params)
	runBlocking {
		sdk.receipt.listByReference(
			decodedParams.reference,
		)
	}
}.toPyString(ListSerializer(EncryptedReceipt.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listByReferenceAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListByReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.receipt.listByReference(
				decodedParams.reference,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedReceipt.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
