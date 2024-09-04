// auto-generated file
package com.icure.sdk.py.api.AccessLogBasicApi

import com.icure.sdk.CardinalBaseApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
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
private class MatchAccessLogsByParams(
	public val filter: BaseFilterOptions<AccessLog>,
)

public fun matchAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.matchAccessLogsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAccessLogsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.matchAccessLogsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAccessLogsBySortedParams(
	public val filter: BaseSortableFilterOptions<AccessLog>,
)

public fun matchAccessLogsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAccessLogsBySortedParams>(params)
	runBlocking {
		sdk.accessLog.matchAccessLogsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchAccessLogsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAccessLogsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.matchAccessLogsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterAccessLogsByParams(
	public val filter: BaseFilterOptions<AccessLog>,
)

public fun filterAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.filterAccessLogsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAccessLogsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.filterAccessLogsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAccessLogsBySortedParams(
	public val filter: BaseSortableFilterOptions<AccessLog>,
)

public fun filterAccessLogsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAccessLogsBySortedParams>(params)
	runBlocking {
		sdk.accessLog.filterAccessLogsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterAccessLogsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAccessLogsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.filterAccessLogsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogParams(
	public val entityId: String,
)

public fun deleteAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLog(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLog(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogsParams(
	public val entityIds: List<String>,
)

public fun deleteAccessLogsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAccessLogsParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogs(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteAccessLogsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAccessLogsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogs(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyAccessLogParams(
	public val entity: EncryptedAccessLog,
)

public fun modifyAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.modifyAccessLog(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.modifyAccessLog(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAccessLogParams(
	public val entityId: String,
)

public fun getAccessLogBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.getAccessLog(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.getAccessLog(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAccessLogsParams(
	public val entityIds: List<String>,
)

public fun getAccessLogsBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAccessLogsParams>(params)
	runBlocking {
		sdk.accessLog.getAccessLogs(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedAccessLog.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAccessLogsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAccessLogsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.getAccessLogs(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedAccessLog.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAccessLogsByParams(
	public val fromEpoch: Long?,
	public val toEpoch: Long?,
	public val startKey: Long?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun findAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.findAccessLogsBy(
			decodedParams.fromEpoch,
			decodedParams.toEpoch,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedAccessLog.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.findAccessLogsBy(
				decodedParams.fromEpoch,
				decodedParams.toEpoch,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedAccessLog.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAccessLogsByUserAfterDateParams(
	public val userId: String,
	public val accessType: String? = null,
	public val startDate: Long? = null,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val descending: Boolean? = null,
)

public fun findAccessLogsByUserAfterDateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
	runBlocking {
		sdk.accessLog.findAccessLogsByUserAfterDate(
			decodedParams.userId,
			decodedParams.accessType,
			decodedParams.startDate,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.descending,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedAccessLog.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findAccessLogsByUserAfterDateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.findAccessLogsByUserAfterDate(
				decodedParams.userId,
				decodedParams.accessType,
				decodedParams.startDate,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.descending,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedAccessLog.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAccessLogsInGroupParams(
	public val groupId: String,
	public val fromEpoch: Long? = null,
	public val toEpoch: Long? = null,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findAccessLogsInGroupBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsInGroupParams>(params)
	runBlocking {
		sdk.accessLog.findAccessLogsInGroup(
			decodedParams.groupId,
			decodedParams.fromEpoch,
			decodedParams.toEpoch,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedAccessLog.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findAccessLogsInGroupAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAccessLogsInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.findAccessLogsInGroup(
				decodedParams.groupId,
				decodedParams.fromEpoch,
				decodedParams.toEpoch,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedAccessLog.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
