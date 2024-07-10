// auto-generated file
package com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
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
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val maintenanceTask: EncryptedMaintenanceTask,
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
		sdk.maintenanceTask.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.maintenanceTask,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedMaintenanceTask.serializer()))

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
			sdk.maintenanceTask.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.maintenanceTask,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedMaintenanceTask.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.encrypted.tryShareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedMaintenanceTask.serializer()))

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
			sdk.maintenanceTask.encrypted.tryShareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedMaintenanceTask.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val maintenanceTask: EncryptedMaintenanceTask,
	public val delegates: Map<String, MaintenanceTaskShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.maintenanceTask.encrypted.shareWithMany(
			decodedParams.maintenanceTask,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedMaintenanceTask.serializer())

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
			sdk.maintenanceTask.encrypted.shareWithMany(
				decodedParams.maintenanceTask,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyMaintenanceTaskParams(
	public val entity: EncryptedMaintenanceTask,
)

public fun modifyMaintenanceTaskBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.encrypted.modifyMaintenanceTask(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyMaintenanceTaskAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.encrypted.modifyMaintenanceTask(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMaintenanceTaskParams(
	public val entityId: String,
)

public fun getMaintenanceTaskBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	runBlocking {
		sdk.maintenanceTask.encrypted.getMaintenanceTask(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedMaintenanceTask.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMaintenanceTaskAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMaintenanceTaskParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.encrypted.getMaintenanceTask(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedMaintenanceTask.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterMaintenanceTasksByParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	@Contextual
	public val filterChain: FilterChain<MaintenanceTask>,
)

public fun filterMaintenanceTasksByBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	runBlocking {
		sdk.maintenanceTask.encrypted.filterMaintenanceTasksBy(
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.filterChain,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedMaintenanceTask.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterMaintenanceTasksByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterMaintenanceTasksByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.maintenanceTask.encrypted.filterMaintenanceTasksBy(
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedMaintenanceTask.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
