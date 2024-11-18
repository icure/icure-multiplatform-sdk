// auto-generated file
package com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
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
	public val accessLog: EncryptedAccessLog,
	public val options: AccessLogShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.accessLog,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

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
			sdk.accessLog.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.accessLog,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val accessLog: EncryptedAccessLog,
	public val delegates: Map<String, AccessLogShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.shareWithMany(
			decodedParams.accessLog,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

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
			sdk.accessLog.encrypted.shareWithMany(
				decodedParams.accessLog,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedAccessLog.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAccessLogsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findAccessLogsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.findAccessLogsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAccessLogsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.findAccessLogsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAccessLogsByParams(
	public val filter: FilterOptions<AccessLog>,
)

@OptIn(InternalIcureApi::class)
public fun filterAccessLogsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.filterAccessLogsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAccessLogsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterAccessLogsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.filterAccessLogsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAccessLogsBySortedParams(
	public val filter: SortableFilterOptions<AccessLog>,
)

@OptIn(InternalIcureApi::class)
public fun filterAccessLogsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterAccessLogsBySortedParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.filterAccessLogsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterAccessLogsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterAccessLogsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.filterAccessLogsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedAccessLog.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class UndeleteAccessLogByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteAccessLogByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogByIdParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.undeleteAccessLogById(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.undeleteAccessLogById(
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
public fun undeleteAccessLogBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.undeleteAccessLog(
			decodedParams.accessLog,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteAccessLogAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.undeleteAccessLog(
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
public fun modifyAccessLogBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.modifyAccessLog(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyAccessLogAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.modifyAccessLog(
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
public fun getAccessLogBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.getAccessLog(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedAccessLog.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAccessLogAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.getAccessLog(
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
public fun getAccessLogsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogsParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.getAccessLogs(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedAccessLog.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAccessLogsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAccessLogsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.getAccessLogs(
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
public fun findAccessLogsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsByParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.findAccessLogsBy(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.findAccessLogsBy(
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
public fun findAccessLogsByUserAfterDateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.findAccessLogsByUserAfterDate(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAccessLogsByUserAfterDateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.findAccessLogsByUserAfterDate(
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
public fun findAccessLogsInGroupBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsInGroupParams>(params)
	runBlocking {
		sdk.accessLog.encrypted.findAccessLogsInGroup(
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
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindAccessLogsInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.accessLog.encrypted.findAccessLogsInGroup(
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
