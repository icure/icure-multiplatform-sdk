// auto-generated file
package com.icure.sdk.py.api.MaintenanceTaskApi.tryAndRecover

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.py.serialization.MaintenanceTaskSerializer
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
	public val maintenanceTask: MaintenanceTask,
	public val options: MaintenanceTaskShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.maintenanceTask,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(MaintenanceTaskSerializer))

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
			sdk.maintenanceTask.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.maintenanceTask,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(MaintenanceTaskSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val maintenanceTask: MaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.tryShareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(MaintenanceTaskSerializer))

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
			sdk.maintenanceTask.tryAndRecover.tryShareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(MaintenanceTaskSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val maintenanceTask: MaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.shareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(MaintenanceTaskSerializer)

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
			sdk.maintenanceTask.tryAndRecover.shareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(MaintenanceTaskSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksByParams(
	public val filter: FilterOptions<MaintenanceTask>,
)

public fun filterMaintenanceTasksByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.filterMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MaintenanceTaskSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryAndRecover.filterMaintenanceTasksBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MaintenanceTaskSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksBySortedParams(
	public val filter: SortableFilterOptions<MaintenanceTask>,
)

public fun filterMaintenanceTasksBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.filterMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, MaintenanceTaskSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryAndRecover.filterMaintenanceTasksBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, MaintenanceTaskSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMaintenanceTaskParams(
	public val entity: MaintenanceTask,
)

public fun modifyMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.modifyMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(MaintenanceTaskSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryAndRecover.modifyMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(MaintenanceTaskSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTaskParams(
	public val entityId: String,
)

public fun getMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.getMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(MaintenanceTaskSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryAndRecover.getMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(MaintenanceTaskSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTasksParams(
	public val entityIds: List<String>,
)

public fun getMaintenanceTasksBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTasksParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryAndRecover.getMaintenanceTasks(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(MaintenanceTaskSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getMaintenanceTasksAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTasksParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryAndRecover.getMaintenanceTasks(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(MaintenanceTaskSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
