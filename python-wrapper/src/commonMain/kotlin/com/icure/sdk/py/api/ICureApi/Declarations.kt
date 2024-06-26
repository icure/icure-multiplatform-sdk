// auto-generated file
package com.icure.sdk.py.api.ICureApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.IndexingInfo
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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
import kotlinx.serialization.builtins.serializer

public fun getVersionBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.iCure.getVersion()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getVersionAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getVersion()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun isReadyBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.iCure.isReady()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun isReadyAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.isReady()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getProcessInfoBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.iCure.getProcessInfo()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getProcessInfoAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getProcessInfo()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getIndexingInfoBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.iCure.getIndexingInfo()
	}
}.toPyString(IndexingInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getIndexingInfoAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getIndexingInfo()
		}.toPyStringAsyncCallback(IndexingInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getReplicationInfoBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.iCure.getReplicationInfo()
	}
}.toPyString(ReplicationInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getReplicationInfoAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getReplicationInfo()
		}.toPyStringAsyncCallback(ReplicationInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateDesignDocParams(
	public val entityName: String,
	public val warmup: Boolean? = null,
)

public fun updateDesignDocBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDesignDocParams>(params)
	runBlocking {
		sdk.iCure.updateDesignDoc(
			decodedParams.entityName,
			decodedParams.warmup,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateDesignDocAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDesignDocParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.updateDesignDoc(
				decodedParams.entityName,
				decodedParams.warmup,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolvePatientsConflictsParams(
	public val limit: Int? = null,
)

public fun resolvePatientsConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolvePatientsConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolvePatientsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolvePatientsConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolvePatientsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolvePatientsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveContactsConflictsParams(
	public val limit: Int? = null,
)

public fun resolveContactsConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveContactsConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveContactsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveContactsConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveContactsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveContactsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveFormsConflictsParams(
	public val limit: Int? = null,
)

public fun resolveFormsConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveFormsConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveFormsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveFormsConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveFormsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveFormsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveHealthElementsConflictsParams(
	public val limit: Int? = null,
)

public fun resolveHealthElementsConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveHealthElementsConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveHealthElementsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveHealthElementsConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveHealthElementsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveHealthElementsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveInvoicesConflictsParams(
	public val limit: Int? = null,
)

public fun resolveInvoicesConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveInvoicesConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveInvoicesConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveInvoicesConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveInvoicesConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveInvoicesConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveMessagesConflictsParams(
	public val limit: Int? = null,
)

public fun resolveMessagesConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveMessagesConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveMessagesConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveMessagesConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveMessagesConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveMessagesConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveDocumentsConflictsParams(
	public val ids: String? = null,
	public val limit: Int? = null,
)

public fun resolveDocumentsConflictsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveDocumentsConflictsParams>(params)
	runBlocking {
		sdk.iCure.resolveDocumentsConflicts(
			decodedParams.ids,
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun resolveDocumentsConflictsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResolveDocumentsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.resolveDocumentsConflicts(
				decodedParams.ids,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetIndexingInfoByGroupParams(
	public val groupId: String,
)

public fun getIndexingInfoByGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetIndexingInfoByGroupParams>(params)
	runBlocking {
		sdk.iCure.getIndexingInfoByGroup(
			decodedParams.groupId,
		)
	}
}.toPyString(IndexingInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getIndexingInfoByGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetIndexingInfoByGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getIndexingInfoByGroup(
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(IndexingInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReplicatorInfoParams(
	public val id: String,
)

public fun getReplicatorInfoBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReplicatorInfoParams>(params)
	runBlocking {
		sdk.iCure.getReplicatorInfo(
			decodedParams.id,
		)
	}
}.toPyString(ReplicatorDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getReplicatorInfoAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReplicatorInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.getReplicatorInfo(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ReplicatorDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EvictAllFromMapParams(
	public val mapName: String,
)

public fun evictAllFromMapBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<EvictAllFromMapParams>(params)
	runBlocking {
		sdk.iCure.evictAllFromMap(
			decodedParams.mapName,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun evictAllFromMapAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<EvictAllFromMapParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.iCure.evictAllFromMap(
				decodedParams.mapName,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
