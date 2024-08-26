// auto-generated file
package com.icure.sdk.py.api.MessageApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.MessageShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Message
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.MessageSerializer
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
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
	public val message: Message,
	public val options: MessageShareOptions,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.message,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(MessageSerializer))

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
			sdk.message.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.message,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val message: Message,
	public val delegates: Map<String, MessageShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.tryShareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(MessageSerializer))

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
			sdk.message.tryAndRecover.tryShareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val message: Message,
	public val delegates: Map<String, MessageShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.shareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(MessageSerializer)

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
			sdk.message.tryAndRecover.shareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(MessageSerializer, resultCallback)
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

public fun findMessagesByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MessageSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MessageSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesByParams(
	public val filter: FilterOptions<Message>,
)

public fun filterMessagesByBlocking(sdk: IcureApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.filterMessagesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MessageSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterMessagesByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.filterMessagesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MessageSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesBySortedParams(
	public val filter: SortableFilterOptions<Message>,
)

public fun filterMessagesBySortedBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesBySortedParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.filterMessagesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MessageSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterMessagesBySortedAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMessagesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.filterMessagesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MessageSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMessageParams(
	public val entity: Message,
)

public fun modifyMessageBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.modifyMessage(
			decodedParams.entity,
		)
	}
}.toPyString(MessageSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyMessageAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.modifyMessage(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(MessageSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessageParams(
	public val entityId: String,
)

public fun getMessageBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.getMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(MessageSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getMessageAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.getMessage(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(MessageSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesParams(
	public val entityIds: List<String>,
)

public fun getMessagesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.getMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.getMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByTransportGuidsParams(
	public val hcPartyId: String,
	public val transportGuids: List<String>,
)

public fun listMessagesByTransportGuidsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.listMessagesByTransportGuids(
			decodedParams.hcPartyId,
			decodedParams.transportGuids,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByTransportGuidsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.listMessagesByTransportGuids(
				decodedParams.hcPartyId,
				decodedParams.transportGuids,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByHCPartyPatientForeignKeysParams(
	public val secretPatientKeys: List<String>,
)

public fun findMessagesByHCPartyPatientForeignKeysBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByHCPartyPatientForeignKeys(
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByHCPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByHCPartyPatientForeignKeys(
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesParams(
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessages(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessages(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenMessagesParams(
	public val messageId: String,
)

public fun getChildrenMessagesBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.getChildrenMessages(
			decodedParams.messageId,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenMessagesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.getChildrenMessages(
				decodedParams.messageId,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesChildrenParams(
	public val messageIds: List<String>,
)

public fun getMessagesChildrenBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.getMessagesChildren(
			decodedParams.messageIds,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getMessagesChildrenAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMessagesChildrenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.getMessagesChildren(
				decodedParams.messageIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByInvoicesParams(
	public val invoiceIds: List<String>,
)

public fun listMessagesByInvoicesBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.listMessagesByInvoices(
			decodedParams.invoiceIds,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listMessagesByInvoicesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListMessagesByInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.listMessagesByInvoices(
				decodedParams.invoiceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByTransportGuidParams(
	public val transportGuid: String,
)

public fun findMessagesByTransportGuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByTransportGuid(
			decodedParams.transportGuid,
		)
	}
}.toPyString(PaginatedList.serializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByTransportGuidAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByTransportGuid(
				decodedParams.transportGuid,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MessageSerializer), resultCallback)
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

public fun findMessagesByTransportGuidSentDateBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByTransportGuidSentDate(
			decodedParams.transportGuid,
			decodedParams.from,
			decodedParams.to,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.hcpId,
		)
	}
}.toPyString(PaginatedList.serializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByTransportGuidSentDateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByTransportGuidSentDate(
				decodedParams.transportGuid,
				decodedParams.from,
				decodedParams.to,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.hcpId,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByToAddressParams(
	public val toAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesByToAddressBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByToAddress(
			decodedParams.toAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByToAddressAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByToAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByToAddress(
				decodedParams.toAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByFromAddressParams(
	public val fromAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findMessagesByFromAddressBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.findMessagesByFromAddress(
			decodedParams.fromAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findMessagesByFromAddressAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindMessagesByFromAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.findMessagesByFromAddress(
				decodedParams.fromAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesStatusBitsParams(
	public val entityIds: List<String>,
	public val statusBits: Int,
)

public fun setMessagesStatusBitsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.setMessagesStatusBits(
			decodedParams.entityIds,
			decodedParams.statusBits,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesStatusBitsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesStatusBitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.setMessagesStatusBits(
				decodedParams.entityIds,
				decodedParams.statusBits,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesReadStatusParams(
	public val entityIds: List<String>,
	public val time: Long?,
	public val readStatus: Boolean,
	public val userId: String?,
)

public fun setMessagesReadStatusBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	runBlocking {
		sdk.message.tryAndRecover.setMessagesReadStatus(
			decodedParams.entityIds,
			decodedParams.time,
			decodedParams.readStatus,
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(MessageSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun setMessagesReadStatusAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetMessagesReadStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryAndRecover.setMessagesReadStatus(
				decodedParams.entityIds,
				decodedParams.time,
				decodedParams.readStatus,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(MessageSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
