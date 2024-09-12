// auto-generated file
package com.icure.cardinal.sdk.py.api.MessageApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@Serializable
private class CreateMessageParams(
	public val entity: DecryptedMessage,
)

@OptIn(InternalIcureApi::class)
public fun createMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMessageParams>(params)
	runBlocking {
		sdk.message.createMessage(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.createMessage(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateMessageInTopicParams(
	public val entity: DecryptedMessage,
)

@OptIn(InternalIcureApi::class)
public fun createMessageInTopicBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMessageInTopicParams>(params)
	runBlocking {
		sdk.message.createMessageInTopic(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createMessageInTopicAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateMessageInTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.createMessageInTopic(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedMessage?,
	public val patient: Patient?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.message.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun withEncryptionMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val message: Message,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.message.getEncryptionKeysOf(
			decodedParams.message,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEncryptionKeysOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getEncryptionKeysOf(
				decodedParams.message,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val message: Message,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.message.hasWriteAccess(
			decodedParams.message,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.hasWriteAccess(
				decodedParams.message,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val message: Message,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.message.decryptPatientIdOf(
			decodedParams.message,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.decryptPatientIdOf(
				decodedParams.message,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: Message,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.message.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val message: EncryptedMessage,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.message.decrypt(
			decodedParams.message,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.decrypt(
				decodedParams.message,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val message: EncryptedMessage,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.message.tryDecrypt(
			decodedParams.message,
		)
	}
}.toPyString(PolymorphicSerializer(Message::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryDecrypt(
				decodedParams.message,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Message::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMessagesByParams(
	public val filter: FilterOptions<Message>,
)

@OptIn(InternalIcureApi::class)
public fun matchMessagesByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMessagesByParams>(params)
	runBlocking {
		sdk.message.matchMessagesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMessagesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.matchMessagesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMessagesBySortedParams(
	public val filter: SortableFilterOptions<Message>,
)

@OptIn(InternalIcureApi::class)
public fun matchMessagesBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMessagesBySortedParams>(params)
	runBlocking {
		sdk.message.matchMessagesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchMessagesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchMessagesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.matchMessagesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMessageParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMessageParams>(params)
	runBlocking {
		sdk.message.deleteMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMessageParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteMessagesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMessagesParams>(params)
	runBlocking {
		sdk.message.deleteMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.deleteMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val message: DecryptedMessage,
	public val options: MessageShareOptions,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.message.shareWith(
			decodedParams.delegateId,
			decodedParams.message,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedMessage.serializer()))

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
			sdk.message.shareWith(
				decodedParams.delegateId,
				decodedParams.message,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedMessage.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val message: DecryptedMessage,
	public val delegates: Map<String, MessageShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.message.tryShareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.tryShareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedMessage.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val message: DecryptedMessage,
	public val delegates: Map<String, MessageShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.message.shareWithMany(
			decodedParams.message,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedMessage.serializer())

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
			sdk.message.shareWithMany(
				decodedParams.message,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	runBlocking {
		sdk.message.findMessagesByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesByParams(
	public val filter: FilterOptions<Message>,
)

@OptIn(InternalIcureApi::class)
public fun filterMessagesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterMessagesByParams>(params)
	runBlocking {
		sdk.message.filterMessagesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMessagesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterMessagesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.filterMessagesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMessagesBySortedParams(
	public val filter: SortableFilterOptions<Message>,
)

@OptIn(InternalIcureApi::class)
public fun filterMessagesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterMessagesBySortedParams>(params)
	runBlocking {
		sdk.message.filterMessagesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterMessagesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterMessagesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.filterMessagesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedMessage.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMessageParams(
	public val entity: DecryptedMessage,
)

@OptIn(InternalIcureApi::class)
public fun modifyMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMessageParams>(params)
	runBlocking {
		sdk.message.modifyMessage(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.modifyMessage(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessageParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getMessageBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessageParams>(params)
	runBlocking {
		sdk.message.getMessage(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedMessage.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMessageAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessage(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedMessage.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getMessagesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessagesParams>(params)
	runBlocking {
		sdk.message.getMessages(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessages(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByTransportGuidsParams(
	public val hcPartyId: String,
	public val transportGuids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listMessagesByTransportGuidsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	runBlocking {
		sdk.message.listMessagesByTransportGuids(
			decodedParams.hcPartyId,
			decodedParams.transportGuids,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listMessagesByTransportGuidsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListMessagesByTransportGuidsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.listMessagesByTransportGuids(
				decodedParams.hcPartyId,
				decodedParams.transportGuids,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByHCPartyPatientForeignKeysParams(
	public val secretPatientKeys: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesByHCPartyPatientForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.message.findMessagesByHCPartyPatientForeignKeys(
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByHCPartyPatientForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByHCPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByHCPartyPatientForeignKeys(
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesParams(
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindMessagesParams>(params)
	runBlocking {
		sdk.message.findMessages(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessages(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenMessagesParams(
	public val messageId: String,
)

@OptIn(InternalIcureApi::class)
public fun getChildrenMessagesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenMessagesParams>(params)
	runBlocking {
		sdk.message.getChildrenMessages(
			decodedParams.messageId,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getChildrenMessagesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenMessagesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getChildrenMessages(
				decodedParams.messageId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMessagesChildrenParams(
	public val messageIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getMessagesChildrenBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessagesChildrenParams>(params)
	runBlocking {
		sdk.message.getMessagesChildren(
			decodedParams.messageIds,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMessagesChildrenAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMessagesChildrenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.getMessagesChildren(
				decodedParams.messageIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListMessagesByInvoicesParams(
	public val invoiceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun listMessagesByInvoicesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListMessagesByInvoicesParams>(params)
	runBlocking {
		sdk.message.listMessagesByInvoices(
			decodedParams.invoiceIds,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listMessagesByInvoicesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListMessagesByInvoicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.listMessagesByInvoices(
				decodedParams.invoiceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByTransportGuidParams(
	public val transportGuid: String,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesByTransportGuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByTransportGuidParams>(params)
	runBlocking {
		sdk.message.findMessagesByTransportGuid(
			decodedParams.transportGuid,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByTransportGuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByTransportGuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByTransportGuid(
				decodedParams.transportGuid,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedMessage.serializer()), resultCallback)
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

@OptIn(InternalIcureApi::class)
public fun findMessagesByTransportGuidSentDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
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
}.toPyString(PaginatedList.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByTransportGuidSentDateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByTransportGuidSentDateParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByToAddressParams(
	public val toAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesByToAddressBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindMessagesByToAddressParams>(params)
	runBlocking {
		sdk.message.findMessagesByToAddress(
			decodedParams.toAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByToAddressAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindMessagesByToAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByToAddress(
				decodedParams.toAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindMessagesByFromAddressParams(
	public val fromAddress: String,
	public val startKey: JsonElement?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun findMessagesByFromAddressBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByFromAddressParams>(params)
	runBlocking {
		sdk.message.findMessagesByFromAddress(
			decodedParams.fromAddress,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findMessagesByFromAddressAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindMessagesByFromAddressParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.findMessagesByFromAddress(
				decodedParams.fromAddress,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesStatusBitsParams(
	public val entityIds: List<String>,
	public val statusBits: Int,
)

@OptIn(InternalIcureApi::class)
public fun setMessagesStatusBitsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetMessagesStatusBitsParams>(params)
	runBlocking {
		sdk.message.setMessagesStatusBits(
			decodedParams.entityIds,
			decodedParams.statusBits,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setMessagesStatusBitsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetMessagesStatusBitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.setMessagesStatusBits(
				decodedParams.entityIds,
				decodedParams.statusBits,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetMessagesReadStatusParams(
	public val entityIds: List<String>,
	public val time: Long?,
	public val readStatus: Boolean,
	public val userId: String?,
)

@OptIn(InternalIcureApi::class)
public fun setMessagesReadStatusBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetMessagesReadStatusParams>(params)
	runBlocking {
		sdk.message.setMessagesReadStatus(
			decodedParams.entityIds,
			decodedParams.time,
			decodedParams.readStatus,
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(DecryptedMessage.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setMessagesReadStatusAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetMessagesReadStatusParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.message.setMessagesReadStatus(
				decodedParams.entityIds,
				decodedParams.time,
				decodedParams.readStatus,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMessage.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<Message>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.message.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedMessage.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
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
