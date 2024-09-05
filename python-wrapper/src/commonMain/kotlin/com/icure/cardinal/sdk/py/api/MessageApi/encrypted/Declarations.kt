// auto-generated file
package com.icure.cardinal.sdk.py.api.MessageApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.serialization.PatientSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.json.JsonElement

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val message: EncryptedMessage,
	public val options: MessageShareOptions,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.message.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.message,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.message,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedMessage.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val message: EncryptedMessage,
	public val delegates: Map<String, MessageShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.message.encrypted.tryShareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.tryShareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedMessage.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val message: EncryptedMessage,
	public val delegates: Map<String, MessageShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.message.encrypted.shareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedMessage.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.shareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findMessagesByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesByParams(
	public val filter: FilterOptions<Message>,
)

public fun filterMessagesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	runBlocking {
		sdk.message.encrypted.filterMessagesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMessagesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.filterMessagesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesBySortedParams(
	public val filter: SortableFilterOptions<Message>,
)

public fun filterMessagesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesBySortedParams>(params)
	runBlocking {
		sdk.message.encrypted.filterMessagesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMessagesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.filterMessagesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMessageParams(
	public val entity: EncryptedMessage,
)

public fun modifyMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	runBlocking {
		sdk.message.encrypted.modifyMessage(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedMessage.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.modifyMessage(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessageParams(
	public val entityId: String,
)

public fun getMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	runBlocking {
		sdk.message.encrypted.getMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedMessage.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.getMessage(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesParams(
	public val entityIds: List<String>,
)

public fun getMessagesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	runBlocking {
		sdk.message.encrypted.getMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.getMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByTransportGuidsParams(
	public val hcPartyId: String,
	public val transportGuids: List<String>,
)

public fun listMessagesByTransportGuidsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	runBlocking {
		sdk.message.encrypted.listMessagesByTransportGuids(
			decodedParams.hcPartyId,
			decodedParams.transportGuids,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByTransportGuidsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.listMessagesByTransportGuids(
				decodedParams.hcPartyId,
				decodedParams.transportGuids,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByHCPartyPatientForeignKeysParams(
	public val secretPatientKeys: List<String>,
)

public fun findMessagesByHCPartyPatientForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByHCPartyPatientForeignKeys(
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByHCPartyPatientForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByHCPartyPatientForeignKeys(
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesParams(
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessages(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessages(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenMessagesParams(
	public val messageId: String,
)

public fun getChildrenMessagesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	runBlocking {
		sdk.message.encrypted.getChildrenMessages(
			decodedParams.messageId,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.getChildrenMessages(
				decodedParams.messageId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesChildrenParams(
	public val messageIds: List<String>,
)

public fun getMessagesChildrenBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	runBlocking {
		sdk.message.encrypted.getMessagesChildren(
			decodedParams.messageIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesChildrenAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.getMessagesChildren(
				decodedParams.messageIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByInvoicesParams(
	public val invoiceIds: List<String>,
)

public fun listMessagesByInvoicesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	runBlocking {
		sdk.message.encrypted.listMessagesByInvoices(
			decodedParams.invoiceIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.listMessagesByInvoices(
				decodedParams.invoiceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByTransportGuidParams(
	public val transportGuid: String,
)

public fun findMessagesByTransportGuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByTransportGuid(
			decodedParams.transportGuid,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByTransportGuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByTransportGuid(
				decodedParams.transportGuid,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByTransportGuidSentDateParams(
	public val transportGuid: String,
	public val from: Long,
	public val to: Long,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val hcpId: String? = null,
)

public fun findMessagesByTransportGuidSentDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByTransportGuidSentDate(
			decodedParams.transportGuid,
			decodedParams.from,
			decodedParams.to,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.hcpId,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByTransportGuidSentDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByTransportGuidSentDate(
				decodedParams.transportGuid,
				decodedParams.from,
				decodedParams.to,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.hcpId,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByToAddressParams(
	public val toAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesByToAddressBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByToAddress(
			decodedParams.toAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByToAddressAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByToAddress(
				decodedParams.toAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByFromAddressParams(
	public val fromAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesByFromAddressBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	runBlocking {
		sdk.message.encrypted.findMessagesByFromAddress(
			decodedParams.fromAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByFromAddressAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.findMessagesByFromAddress(
				decodedParams.fromAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesStatusBitsParams(
	public val entityIds: List<String>,
	public val statusBits: Int,
)

public fun setMessagesStatusBitsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	runBlocking {
		sdk.message.encrypted.setMessagesStatusBits(
			decodedParams.entityIds,
			decodedParams.statusBits,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesStatusBitsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.setMessagesStatusBits(
				decodedParams.entityIds,
				decodedParams.statusBits,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesReadStatusParams(
	public val entityIds: List<String>,
	public val time: Long?,
	public val readStatus: Boolean,
	public val userId: String?,
)

public fun setMessagesReadStatusBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	runBlocking {
		sdk.message.encrypted.setMessagesReadStatus(
			decodedParams.entityIds,
			decodedParams.time,
			decodedParams.readStatus,
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesReadStatusAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.encrypted.setMessagesReadStatus(
				decodedParams.entityIds,
				decodedParams.time,
				decodedParams.readStatus,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
