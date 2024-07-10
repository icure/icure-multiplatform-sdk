// auto-generated file
package com.icure.sdk.py.api.flavoured.MessageBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.Message
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@Serializable
private class MatchMessagesByParams(
	@Contextual
	public val filter: AbstractFilter<Message>,
)

public fun matchMessagesByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMessagesByParams>(params)
	runBlocking {
		sdk.message.matchMessagesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchMessagesByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.matchMessagesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMessageParams(
	public val entityId: String,
)

public fun deleteMessageBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMessageParams>(params)
	runBlocking {
		sdk.message.deleteMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteMessageAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.deleteMessage(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMessagesParams(
	public val entityIds: List<String>,
)

public fun deleteMessagesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMessagesParams>(params)
	runBlocking {
		sdk.message.deleteMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteMessagesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.deleteMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	@Contextual
	public val filter: AbstractFilter<Message>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.message.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedMessage.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMessageParams(
	public val entity: EncryptedMessage,
)

public fun modifyMessageBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	runBlocking {
		sdk.message.modifyMessage(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedMessage.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyMessageAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.modifyMessage(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessageParams(
	public val entityId: String,
)

public fun getMessageBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	runBlocking {
		sdk.message.getMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedMessage.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMessageAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessage(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesParams(
	public val entityIds: List<String>,
)

public fun getMessagesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	runBlocking {
		sdk.message.getMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesByParams(
	@Contextual
	public val filterChain: FilterChain<Message>,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun filterMessagesByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	runBlocking {
		sdk.message.filterMessagesBy(
			decodedParams.filterChain,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterMessagesByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.filterMessagesBy(
				decodedParams.filterChain,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByTransportGuidsParams(
	public val hcPartyId: String,
	public val transportGuids: List<String>,
)

public fun listMessagesByTransportGuidsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	runBlocking {
		sdk.message.listMessagesByTransportGuids(
			decodedParams.hcPartyId,
			decodedParams.transportGuids,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByTransportGuidsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.listMessagesByTransportGuids(
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

public fun findMessagesByHCPartyPatientForeignKeysBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.message.findMessagesByHCPartyPatientForeignKeys(
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByHCPartyPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByHCPartyPatientForeignKeys(
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

public fun findMessagesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	runBlocking {
		sdk.message.findMessages(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessages(
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

public fun getChildrenMessagesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	runBlocking {
		sdk.message.getChildrenMessages(
			decodedParams.messageId,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenMessagesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getChildrenMessages(
				decodedParams.messageId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesChildrenParams(
	public val messageIds: List<String>,
)

public fun getMessagesChildrenBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	runBlocking {
		sdk.message.getMessagesChildren(
			decodedParams.messageIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesChildrenAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessagesChildren(
				decodedParams.messageIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByInvoicesParams(
	public val invoiceIds: List<String>,
)

public fun listMessagesByInvoicesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	runBlocking {
		sdk.message.listMessagesByInvoices(
			decodedParams.invoiceIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByInvoicesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.listMessagesByInvoices(
				decodedParams.invoiceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByTransportGuidParams(
	public val transportGuid: String,
)

public fun findMessagesByTransportGuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	runBlocking {
		sdk.message.findMessagesByTransportGuid(
			decodedParams.transportGuid,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByTransportGuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByTransportGuid(
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

public fun findMessagesByTransportGuidSentDateBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	runBlocking {
		sdk.message.findMessagesByTransportGuidSentDate(
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
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByTransportGuidSentDate(
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

public fun findMessagesByToAddressBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	runBlocking {
		sdk.message.findMessagesByToAddress(
			decodedParams.toAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByToAddressAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByToAddress(
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

public fun findMessagesByFromAddressBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	runBlocking {
		sdk.message.findMessagesByFromAddress(
			decodedParams.fromAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByFromAddressAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByFromAddress(
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

public fun setMessagesStatusBitsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	runBlocking {
		sdk.message.setMessagesStatusBits(
			decodedParams.entityIds,
			decodedParams.statusBits,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesStatusBitsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.setMessagesStatusBits(
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
	public val userId: String,
)

public fun setMessagesReadStatusBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	runBlocking {
		sdk.message.setMessagesReadStatus(
			decodedParams.entityIds,
			decodedParams.time,
			decodedParams.readStatus,
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(EncryptedMessage.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesReadStatusAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.setMessagesReadStatus(
				decodedParams.entityIds,
				decodedParams.time,
				decodedParams.readStatus,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
