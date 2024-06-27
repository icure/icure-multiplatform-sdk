// auto-generated file
package com.icure.sdk.py.api.flavoured.TimeTableApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.TimeTableShareOptions
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.py.serialization.TimeTableSerializer
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
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
private class ShareWithParams(
	public val delegateId: String,
	public val timeTable: TimeTable,
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
		sdk.timeTable.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.timeTable,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(TimeTableSerializer))

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
			sdk.timeTable.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.timeTable,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(TimeTableSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val timeTable: TimeTable,
	public val delegates: Map<String, TimeTableShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.tryShareWithMany(
			decodedParams.timeTable,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(TimeTableSerializer))

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
			sdk.timeTable.tryAndRecover.tryShareWithMany(
				decodedParams.timeTable,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(TimeTableSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val timeTable: TimeTable,
	public val delegates: Map<String, TimeTableShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.shareWithMany(
			decodedParams.timeTable,
			decodedParams.delegates,
		)
	}
}.toPyString(TimeTableSerializer)

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
			sdk.timeTable.tryAndRecover.shareWithMany(
				decodedParams.timeTable,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(TimeTableSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyTimeTableParams(
	public val entity: TimeTable,
)

public fun modifyTimeTableBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.modifyTimeTable(
			decodedParams.entity,
		)
	}
}.toPyString(TimeTableSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyTimeTableAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryAndRecover.modifyTimeTable(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(TimeTableSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTableParams(
	public val entityId: String,
)

public fun getTimeTableBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.getTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(TimeTableSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTableAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryAndRecover.getTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(TimeTableSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

public fun getTimeTablesByPeriodAndAgendaIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.getTimeTablesByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(TimeTableSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTablesByPeriodAndAgendaIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryAndRecover.getTimeTablesByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(TimeTableSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByAgendaIdParams(
	public val agendaId: String,
)

public fun getTimeTablesByAgendaIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.tryAndRecover.getTimeTablesByAgendaId(
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(TimeTableSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getTimeTablesByAgendaIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryAndRecover.getTimeTablesByAgendaId(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(TimeTableSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
