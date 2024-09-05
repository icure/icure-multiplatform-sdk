// auto-generated file
package com.icure.cardinal.sdk.py.api.TopicApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.py.serialization.TopicSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Byte
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

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val topic: Topic,
	public val options: TopicShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.topic,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(TopicSerializer))

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
			sdk.topic.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.topic,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(TopicSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val topic: Topic,
	public val delegates: Map<String, TopicShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.tryShareWithMany(
			decodedParams.topic,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(TopicSerializer))

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
			sdk.topic.tryAndRecover.tryShareWithMany(
				decodedParams.topic,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(TopicSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val topic: Topic,
	public val delegates: Map<String, TopicShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.shareWithMany(
			decodedParams.topic,
			decodedParams.delegates,
		)
	}
}.toPyString(TopicSerializer)

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
			sdk.topic.tryAndRecover.shareWithMany(
				decodedParams.topic,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(TopicSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTopicsByParams(
	public val filter: FilterOptions<Topic>,
)

public fun filterTopicsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.filterTopicsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, TopicSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterTopicsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.filterTopicsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, TopicSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterTopicsBySortedParams(
	public val filter: SortableFilterOptions<Topic>,
)

public fun filterTopicsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsBySortedParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.filterTopicsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, TopicSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterTopicsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTopicsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.filterTopicsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, TopicSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyTopicParams(
	public val entity: Topic,
)

public fun modifyTopicBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTopicParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.modifyTopic(
			decodedParams.entity,
		)
	}
}.toPyString(TopicSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyTopicAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.modifyTopic(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(TopicSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicParams(
	public val entityId: String,
)

public fun getTopicBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.getTopic(
			decodedParams.entityId,
		)
	}
}.toPyString(TopicSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getTopicAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.getTopic(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(TopicSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTopicsParams(
	public val entityIds: List<String>,
)

public fun getTopicsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicsParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.getTopics(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(TopicSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getTopicsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTopicsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.getTopics(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(TopicSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
	public val topicRole: TopicRole,
)

public fun addParticipantBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddParticipantParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.addParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
			decodedParams.topicRole,
		)
	}
}.toPyString(TopicSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun addParticipantAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddParticipantParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.addParticipant(
				decodedParams.entityId,
				decodedParams.dataOwnerId,
				decodedParams.topicRole,
			)
		}.toPyStringAsyncCallback(TopicSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveParticipantParams(
	public val entityId: String,
	public val dataOwnerId: String,
)

public fun removeParticipantBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveParticipantParams>(params)
	runBlocking {
		sdk.topic.tryAndRecover.removeParticipant(
			decodedParams.entityId,
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(TopicSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun removeParticipantAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveParticipantParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.topic.tryAndRecover.removeParticipant(
				decodedParams.entityId,
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(TopicSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
