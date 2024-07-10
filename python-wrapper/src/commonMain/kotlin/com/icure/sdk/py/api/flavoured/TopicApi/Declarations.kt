// auto-generated file
package com.icure.sdk.py.api.flavoured.TopicApi

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.serialization.TopicSerializer
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
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateTopicParams(
	public val entity: DecryptedTopic,
)

public fun createTopicBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateTopicParams>(params)
	runBlocking {
		sdk.topic.createTopic(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createTopicAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.createTopic(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedTopic?,
	@Serializable(PatientSerializer::class)
	public val patient: Patient?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdOption =
			com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent,
)

public fun withEncryptionMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.topic.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun withEncryptionMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(TopicSerializer::class)
	public val topic: Topic,
)

public fun getEncryptionKeysOfBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.topic.getEncryptionKeysOf(
			decodedParams.topic,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEncryptionKeysOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.getEncryptionKeysOf(
				decodedParams.topic,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(TopicSerializer::class)
	public val topic: Topic,
)

public fun hasWriteAccessBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.topic.hasWriteAccess(
			decodedParams.topic,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.hasWriteAccess(
				decodedParams.topic,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	@Serializable(TopicSerializer::class)
	public val topic: Topic,
)

public fun decryptPatientIdOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.topic.decryptPatientIdOf(
			decodedParams.topic,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.decryptPatientIdOf(
				decodedParams.topic,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(TopicSerializer::class)
	public val entity: Topic,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.topic.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteTopicParams(
	public val entityId: String,
)

public fun deleteTopicBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicParams>(params)
	runBlocking {
		sdk.topic.deleteTopic(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteTopicAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.deleteTopic(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteTopicsParams(
	public val entityIds: List<String>,
)

public fun deleteTopicsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicsParams>(params)
	runBlocking {
		sdk.topic.deleteTopics(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteTopicsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.deleteTopics(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchTopicsByParams(
	@Contextual
	public val filter: AbstractFilter<Topic>,
)

public fun matchTopicsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTopicsByParams>(params)
	runBlocking {
		sdk.topic.matchTopicsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchTopicsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTopicsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.matchTopicsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	@Contextual
	public val filter: AbstractFilter<Topic>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.topic.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedTopic.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedTopic.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val topic: DecryptedTopic,
	public val shareEncryptionKeys: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val shareOwningEntityIds: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val requestedPermission: RequestedPermission =
			com.icure.sdk.model.requests.RequestedPermission.MaxWrite,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.topic.shareWith(
			decodedParams.delegateId,
			decodedParams.topic,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedTopic.serializer()))

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
			sdk.topic.shareWith(
				decodedParams.delegateId,
				decodedParams.topic,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedTopic.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val topic: DecryptedTopic,
	public val delegates: Map<String, TopicShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.topic.tryShareWithMany(
			decodedParams.topic,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedTopic.serializer()))

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
			sdk.topic.tryShareWithMany(
				decodedParams.topic,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedTopic.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val topic: DecryptedTopic,
	public val delegates: Map<String, TopicShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.topic.shareWithMany(
			decodedParams.topic,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedTopic.serializer())

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
			sdk.topic.shareWithMany(
				decodedParams.topic,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyTopicParams(
	public val entity: DecryptedTopic,
)

public fun modifyTopicBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTopicParams>(params)
	runBlocking {
		sdk.topic.modifyTopic(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyTopicAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.modifyTopic(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicParams(
	public val entityId: String,
)

public fun getTopicBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicParams>(params)
	runBlocking {
		sdk.topic.getTopic(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTopicAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.getTopic(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicsParams(
	public val entityIds: List<String>,
)

public fun getTopicsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicsParams>(params)
	runBlocking {
		sdk.topic.getTopics(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedTopic.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTopicsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.getTopics(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedTopic.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTopicsByParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	@Contextual
	public val filterChain: FilterChain<Topic>,
)

public fun filterTopicsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	runBlocking {
		sdk.topic.filterTopicsBy(
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.filterChain,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedTopic.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterTopicsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.filterTopicsBy(
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedTopic.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
	public val topicRole: TopicRole,
)

public fun addParticipantBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddParticipantParams>(params)
	runBlocking {
		sdk.topic.addParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
			decodedParams.topicRole,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun addParticipantAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddParticipantParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.addParticipant(
				decodedParams.entityId,
				decodedParams.dataOwnerId,
				decodedParams.topicRole,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
)

public fun removeParticipantBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveParticipantParams>(params)
	runBlocking {
		sdk.topic.removeParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(DecryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun removeParticipantAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveParticipantParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.removeParticipant(
				decodedParams.entityId,
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(DecryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
