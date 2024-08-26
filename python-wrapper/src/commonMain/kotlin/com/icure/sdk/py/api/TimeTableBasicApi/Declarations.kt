// auto-generated file
package com.icure.sdk.py.api.TimeTableBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.TimeTable
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
import kotlin.Byte
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
private class MatchTimeTablesByParams(
	public val filter: BaseFilterOptions<TimeTable>,
)

public fun matchTimeTablesByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTimeTablesByParams>(params)
	runBlocking {
		sdk.timeTable.matchTimeTablesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchTimeTablesByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTimeTablesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.matchTimeTablesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchTimeTablesBySortedParams(
	public val filter: BaseSortableFilterOptions<TimeTable>,
)

public fun matchTimeTablesBySortedBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTimeTablesBySortedParams>(params)
	runBlocking {
		sdk.timeTable.matchTimeTablesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchTimeTablesBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchTimeTablesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.matchTimeTablesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesByParams(
	public val filter: BaseFilterOptions<TimeTable>,
)

public fun filterTimeTablesByBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTimeTablesByParams>(params)
	runBlocking {
		sdk.timeTable.filterTimeTablesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterTimeTablesByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTimeTablesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.filterTimeTablesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesBySortedParams(
	public val filter: BaseSortableFilterOptions<TimeTable>,
)

public fun filterTimeTablesBySortedBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTimeTablesBySortedParams>(params)
	runBlocking {
		sdk.timeTable.filterTimeTablesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterTimeTablesBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterTimeTablesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.filterTimeTablesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteTimeTableParams(
	public val entityId: String,
)

public fun deleteTimeTableBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.deleteTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteTimeTableAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.deleteTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteTimeTablesParams(
	public val entityIds: List<String>,
)

public fun deleteTimeTablesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTimeTablesParams>(params)
	runBlocking {
		sdk.timeTable.deleteTimeTables(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteTimeTablesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteTimeTablesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.deleteTimeTables(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyTimeTableParams(
	public val entity: EncryptedTimeTable,
)

public fun modifyTimeTableBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.modifyTimeTable(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyTimeTableAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.modifyTimeTable(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTableParams(
	public val entityId: String,
)

public fun getTimeTableBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedTimeTable.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTableAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesParams(
	public val timeTableIds: List<String>,
)

public fun getTimeTablesBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTables(
			decodedParams.timeTableIds,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTablesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTables(
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

public fun getTimeTablesByPeriodAndAgendaIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTablesByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTablesByPeriodAndAgendaIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTablesByPeriodAndAgendaId(
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

public fun getTimeTablesByAgendaIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTablesByAgendaId(
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedTimeTable.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTablesByAgendaIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTablesByAgendaId(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
