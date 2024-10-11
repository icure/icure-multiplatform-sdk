// auto-generated file
package com.icure.cardinal.sdk.py.api.AccessLogBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
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

@OptIn(InternalIcureApi::class)
public fun matchAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.matchAccessLogsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAccessLogsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchAccessLogsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAccessLogsBySortedParams>(params)
	runBlocking {
		sdk.accessLog.matchAccessLogsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchAccessLogsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchAccessLogsBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.filterAccessLogsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAccessLogsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterAccessLogsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterAccessLogsBySortedParams>(params)
	runBlocking {
		sdk.accessLog.filterAccessLogsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAccessLogsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterAccessLogsBySortedParams>(params)
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
private class DeleteAccessLogUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogUnsafeParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogsUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsUnsafeParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogsUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogByIdParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogsByIdsParams(
	public val entityIds: List<IdWithMandatoryRev>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsByIdsParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAccessLogByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeAccessLogByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAccessLogByIdParams>(params)
	runBlocking {
		sdk.accessLog.purgeAccessLogById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAccessLogByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAccessLogByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.purgeAccessLogById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogParams(
	public val accessLog: AccessLog,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLog(
			decodedParams.accessLog,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLog(
				decodedParams.accessLog,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAccessLogsParams(
	public val accessLogs: List<AccessLog>,
)

@OptIn(InternalIcureApi::class)
public fun deleteAccessLogsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsParams>(params)
	runBlocking {
		sdk.accessLog.deleteAccessLogs(
			decodedParams.accessLogs,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteAccessLogsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteAccessLogsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.deleteAccessLogs(
				decodedParams.accessLogs,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeAccessLogParams(
	public val accessLog: AccessLog,
)

@OptIn(InternalIcureApi::class)
public fun purgeAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.purgeAccessLog(
			decodedParams.accessLog,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.purgeAccessLog(
				decodedParams.accessLog,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteAccessLogByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteAccessLogByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogByIdParams>(params)
	runBlocking {
		sdk.accessLog.undeleteAccessLogById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteAccessLogByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.undeleteAccessLogById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteAccessLogParams(
	public val accessLog: AccessLog,
)

@OptIn(InternalIcureApi::class)
public fun undeleteAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.undeleteAccessLog(
			decodedParams.accessLog,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.undeleteAccessLog(
				decodedParams.accessLog,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyAccessLogParams(
	public val entity: EncryptedAccessLog,
)

@OptIn(InternalIcureApi::class)
public fun modifyAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.modifyAccessLog(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAccessLogParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getAccessLogBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.getAccessLog(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAccessLogAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getAccessLogsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogsParams>(params)
	runBlocking {
		sdk.accessLog.getAccessLogs(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedAccessLog.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAccessLogsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findAccessLogsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsByParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAccessLogsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findAccessLogsByUserAfterDateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAccessLogsByUserAfterDateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findAccessLogsInGroupBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsInGroupParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAccessLogsInGroupAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsInGroupParams>(params)
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
