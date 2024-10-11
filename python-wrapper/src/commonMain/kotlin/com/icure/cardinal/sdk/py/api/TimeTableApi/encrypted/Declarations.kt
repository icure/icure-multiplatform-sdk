// auto-generated file
package com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.TimeTable
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
import kotlin.Byte
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val timeTable: EncryptedTimeTable,
	public val options: TimeTableShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.timeTable,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

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
			sdk.timeTable.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.timeTable,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val timeTable: EncryptedTimeTable,
	public val delegates: Map<String, TimeTableShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.shareWithMany(
			decodedParams.timeTable,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

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
			sdk.timeTable.encrypted.shareWithMany(
				decodedParams.timeTable,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesByParams(
	public val filter: FilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun filterTimeTablesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterTimeTablesByParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.filterTimeTablesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterTimeTablesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterTimeTablesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.filterTimeTablesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesBySortedParams(
	public val filter: SortableFilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun filterTimeTablesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterTimeTablesBySortedParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.filterTimeTablesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterTimeTablesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterTimeTablesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.filterTimeTablesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class UndeleteTimeTableParams(
	public val timeTable: TimeTable,
)

@OptIn(InternalIcureApi::class)
public fun undeleteTimeTableBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.undeleteTimeTable(
			decodedParams.timeTable,
		)
	}
}.toPyString(PolymorphicSerializer(TimeTable::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.undeleteTimeTable(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(TimeTable::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyTimeTableParams(
	public val entity: EncryptedTimeTable,
)

@OptIn(InternalIcureApi::class)
public fun modifyTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.modifyTimeTable(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.modifyTimeTable(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteTimeTableByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteTimeTableByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteTimeTableByIdParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.undeleteTimeTableById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteTimeTableByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteTimeTableByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.undeleteTimeTableById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTableParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.getTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.getTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesParams(
	public val timeTableIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.getTimeTables(
			decodedParams.timeTableIds,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.getTimeTables(
				decodedParams.timeTableIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesByPeriodAndAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.getTimeTablesByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesByPeriodAndAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.getTimeTablesByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByAgendaIdParams(
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesByAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.encrypted.getTimeTablesByAgendaId(
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesByAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.encrypted.getTimeTablesByAgendaId(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
