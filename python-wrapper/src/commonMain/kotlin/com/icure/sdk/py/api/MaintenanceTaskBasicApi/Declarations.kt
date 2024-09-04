// auto-generated file
package com.icure.sdk.py.api.MaintenanceTaskBasicApi

import com.icure.sdk.CardinalBaseApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
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
private class MatchMaintenanceTasksByParams(
	public val filter: BaseFilterOptions<MaintenanceTask>,
)

public fun matchMaintenanceTasksByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.matchMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchMaintenanceTasksByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.matchMaintenanceTasksBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMaintenanceTasksBySortedParams(
	public val filter: BaseSortableFilterOptions<MaintenanceTask>,
)

public fun matchMaintenanceTasksBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMaintenanceTasksBySortedParams>(params)
	runBlocking {
		sdk.maintenanceTask.matchMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchMaintenanceTasksBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchMaintenanceTasksBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.matchMaintenanceTasksBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksByParams(
	public val filter: BaseFilterOptions<MaintenanceTask>,
)

public fun filterMaintenanceTasksByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.filterMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedMaintenanceTask.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.filterMaintenanceTasksBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksBySortedParams(
	public val filter: BaseSortableFilterOptions<MaintenanceTask>,
)

public fun filterMaintenanceTasksBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	runBlocking {
		sdk.maintenanceTask.filterMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedMaintenanceTask.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.filterMaintenanceTasksBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTaskParams(
	public val entityId: String,
)

public fun deleteMaintenanceTaskBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteMaintenanceTaskAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMaintenanceTasksParams(
	public val entityIds: List<String>,
)

public fun deleteMaintenanceTasksBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMaintenanceTasksParams>(params)
	runBlocking {
		sdk.maintenanceTask.deleteMaintenanceTasks(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteMaintenanceTasksAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMaintenanceTasksParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.deleteMaintenanceTasks(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyMaintenanceTaskParams(
	public val entity: EncryptedMaintenanceTask,
)

public fun modifyMaintenanceTaskBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.modifyMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyMaintenanceTaskAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.modifyMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTaskParams(
	public val entityId: String,
)

public fun getMaintenanceTaskBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.getMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMaintenanceTaskAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.getMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTasksParams(
	public val entityIds: List<String>,
)

public fun getMaintenanceTasksBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTasksParams>(params)
	runBlocking {
		sdk.maintenanceTask.getMaintenanceTasks(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedMaintenanceTask.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMaintenanceTasksAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTasksParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.getMaintenanceTasks(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedMaintenanceTask.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: BaseFilterOptions<MaintenanceTask>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.maintenanceTask.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedMaintenanceTask.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
