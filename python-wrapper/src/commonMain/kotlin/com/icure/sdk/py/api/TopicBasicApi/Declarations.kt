// auto-generated file
package com.icure.sdk.py.api.TopicBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class MatchTopicsByParams(
	public val filter: BaseFilterOptions<Topic>,
)

public fun matchTopicsByBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTopicsByParams>(params)
	runBlocking {
		sdk.topic.matchTopicsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchTopicsByAsync(
	sdk: IcureBaseApis,
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
private class MatchTopicsBySortedParams(
	public val filter: BaseSortableFilterOptions<Topic>,
)

public fun matchTopicsBySortedBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTopicsBySortedParams>(params)
	runBlocking {
		sdk.topic.matchTopicsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchTopicsBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTopicsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.matchTopicsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTopicsByParams(
	public val filter: BaseFilterOptions<Topic>,
)

public fun filterTopicsByBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	runBlocking {
		sdk.topic.filterTopicsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTopic.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterTopicsByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.filterTopicsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTopic.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterTopicsBySortedParams(
	public val filter: BaseSortableFilterOptions<Topic>,
)

public fun filterTopicsBySortedBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsBySortedParams>(params)
	runBlocking {
		sdk.topic.filterTopicsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTopic.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterTopicsBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.filterTopicsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTopic.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteTopicParams(
	public val entityId: String,
)

public fun deleteTopicBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicParams>(params)
	runBlocking {
		sdk.topic.deleteTopic(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteTopicAsync(
	sdk: IcureBaseApis,
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

public fun deleteTopicsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTopicsParams>(params)
	runBlocking {
		sdk.topic.deleteTopics(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteTopicsAsync(
	sdk: IcureBaseApis,
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
private class ModifyTopicParams(
	public val entity: EncryptedTopic,
)

public fun modifyTopicBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTopicParams>(params)
	runBlocking {
		sdk.topic.modifyTopic(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyTopicAsync(
	sdk: IcureBaseApis,
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
		}.toPyStringAsyncCallback(EncryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicParams(
	public val entityId: String,
)

public fun getTopicBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicParams>(params)
	runBlocking {
		sdk.topic.getTopic(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTopicAsync(
	sdk: IcureBaseApis,
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
		}.toPyStringAsyncCallback(EncryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicsParams(
	public val entityIds: List<String>,
)

public fun getTopicsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicsParams>(params)
	runBlocking {
		sdk.topic.getTopics(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedTopic.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTopicsAsync(
	sdk: IcureBaseApis,
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
		}.toPyStringAsyncCallback(ListSerializer(EncryptedTopic.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
	public val topicRole: TopicRole,
)

public fun addParticipantBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddParticipantParams>(params)
	runBlocking {
		sdk.topic.addParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
			decodedParams.topicRole,
		)
	}
}.toPyString(EncryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun addParticipantAsync(
	sdk: IcureBaseApis,
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
		}.toPyStringAsyncCallback(EncryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
)

public fun removeParticipantBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveParticipantParams>(params)
	runBlocking {
		sdk.topic.removeParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(EncryptedTopic.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun removeParticipantAsync(
	sdk: IcureBaseApis,
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
		}.toPyStringAsyncCallback(EncryptedTopic.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: BaseFilterOptions<Topic>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureBaseApis, params: String): PyResult =
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
	sdk: IcureBaseApis,
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