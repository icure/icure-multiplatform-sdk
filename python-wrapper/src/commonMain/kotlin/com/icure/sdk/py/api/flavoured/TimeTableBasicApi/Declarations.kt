// auto-generated file
package com.icure.sdk.py.api.flavoured.TimeTableBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
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
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
