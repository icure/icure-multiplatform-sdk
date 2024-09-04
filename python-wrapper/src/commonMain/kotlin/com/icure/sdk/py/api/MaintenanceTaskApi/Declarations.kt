// auto-generated file
package com.icure.sdk.py.api.MaintenanceTaskApi

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.MaintenanceTaskSerializer
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
import kotlin.Boolean
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateMaintenanceTaskParams(
	public val entity: DecryptedMaintenanceTask,
)

public fun createMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.createMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createMaintenanceTaskAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.createMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val maintenanceTask: DecryptedMaintenanceTask?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
)

public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.maintenanceTask.withEncryptionMetadata(
			decodedParams.maintenanceTask,
			decodedParams.user,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun withEncryptionMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.withEncryptionMetadata(
				decodedParams.maintenanceTask,
				decodedParams.user,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(MaintenanceTaskSerializer::class)
	public val maintenanceTask: MaintenanceTask,
)

public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.maintenanceTask.getEncryptionKeysOf(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEncryptionKeysOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.getEncryptionKeysOf(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(MaintenanceTaskSerializer::class)
	public val maintenanceTask: MaintenanceTask,
)

public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.maintenanceTask.hasWriteAccess(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.hasWriteAccess(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	@Serializable(MaintenanceTaskSerializer::class)
	public val maintenanceTask: MaintenanceTask,
)

public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.maintenanceTask.decryptPatientIdOf(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.decryptPatientIdOf(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(MaintenanceTaskSerializer::class)
	public val entity: MaintenanceTask,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.maintenanceTask.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
)

public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.maintenanceTask.decrypt(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.decrypt(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
)

public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryDecrypt(
			decodedParams.maintenanceTask,
		)
	}
}.toPyString(MaintenanceTaskSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.tryDecrypt(
				decodedParams.maintenanceTask,
			)
		}.toPyStringAsyncCallback(MaintenanceTaskSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchMaintenanceTasksByParams(
	public val filter: FilterOptions<MaintenanceTask>,
)

public fun matchMaintenanceTasksByBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
	public val filter: SortableFilterOptions<MaintenanceTask>,
)

public fun matchMaintenanceTasksBySortedBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
private class DeleteMaintenanceTaskParams(
	public val entityId: String,
)

public fun deleteMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun deleteMaintenanceTasksBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
private class ShareWithParams(
	public val delegateId: String,
	public val maintenanceTask: DecryptedMaintenanceTask,
	public val options: MaintenanceTaskShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.maintenanceTask.shareWith(
			decodedParams.delegateId,
			decodedParams.maintenanceTask,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedMaintenanceTask.serializer()))

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
			sdk.maintenanceTask.shareWith(
				decodedParams.delegateId,
				decodedParams.maintenanceTask,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedMaintenanceTask.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val maintenanceTask: DecryptedMaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.tryShareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedMaintenanceTask.serializer()))

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
			sdk.maintenanceTask.tryShareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedMaintenanceTask.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val maintenanceTask: DecryptedMaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.shareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.shareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
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
		sdk.maintenanceTask.filterMaintenanceTasksBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedMaintenanceTask.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksByAsync(
	sdk: CardinalApis,
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
			PaginatedListIteratorAndSerializer(it, DecryptedMaintenanceTask.serializer())}
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
		sdk.maintenanceTask.filterMaintenanceTasksBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedMaintenanceTask.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksBySortedAsync(
	sdk: CardinalApis,
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
			PaginatedListIteratorAndSerializer(it, DecryptedMaintenanceTask.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyMaintenanceTaskParams(
	public val entity: DecryptedMaintenanceTask,
)

public fun modifyMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.modifyMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.modifyMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTaskParams(
	public val entityId: String,
)

public fun getMaintenanceTaskBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.getMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.getMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedMaintenanceTask.serializer(), resultCallback)
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
		sdk.maintenanceTask.getMaintenanceTasks(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedMaintenanceTask.serializer()))

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
			sdk.maintenanceTask.getMaintenanceTasks(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedMaintenanceTask.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<MaintenanceTask>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
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
	sdk: CardinalApis,
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
