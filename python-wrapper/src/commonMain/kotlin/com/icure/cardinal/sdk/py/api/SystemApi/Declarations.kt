// auto-generated file
package com.icure.cardinal.sdk.py.api.SystemApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.IndexingInfo
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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

public fun getVersionBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.system.getVersion()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getVersionAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getVersion()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun isReadyBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.system.isReady()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun isReadyAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.isReady()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getProcessInfoBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.system.getProcessInfo()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getProcessInfoAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getProcessInfo()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getIndexingInfoBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.system.getIndexingInfo()
	}
}.toPyString(IndexingInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getIndexingInfoAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getIndexingInfo()
		}.toPyStringAsyncCallback(IndexingInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getReplicationInfoBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.system.getReplicationInfo()
	}
}.toPyString(ReplicationInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getReplicationInfoAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getReplicationInfo()
		}.toPyStringAsyncCallback(ReplicationInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateDesignDocParams(
	public val entityName: String,
	public val warmup: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun updateDesignDocBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDesignDocParams>(params)
	runBlocking {
		sdk.system.updateDesignDoc(
			decodedParams.entityName,
			decodedParams.warmup,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateDesignDocAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDesignDocParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.updateDesignDoc(
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

@OptIn(InternalIcureApi::class)
public fun resolvePatientsConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolvePatientsConflictsParams>(params)
	runBlocking {
		sdk.system.resolvePatientsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolvePatientsConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolvePatientsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolvePatientsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveContactsConflictsParams(
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun resolveContactsConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveContactsConflictsParams>(params)
	runBlocking {
		sdk.system.resolveContactsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveContactsConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveContactsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveContactsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveFormsConflictsParams(
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun resolveFormsConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResolveFormsConflictsParams>(params)
	runBlocking {
		sdk.system.resolveFormsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveFormsConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResolveFormsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveFormsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveHealthElementsConflictsParams(
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun resolveHealthElementsConflictsBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveHealthElementsConflictsParams>(params)
	runBlocking {
		sdk.system.resolveHealthElementsConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveHealthElementsConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveHealthElementsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveHealthElementsConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveInvoicesConflictsParams(
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun resolveInvoicesConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveInvoicesConflictsParams>(params)
	runBlocking {
		sdk.system.resolveInvoicesConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveInvoicesConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveInvoicesConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveInvoicesConflicts(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResolveMessagesConflictsParams(
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun resolveMessagesConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveMessagesConflictsParams>(params)
	runBlocking {
		sdk.system.resolveMessagesConflicts(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveMessagesConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveMessagesConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveMessagesConflicts(
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

@OptIn(InternalIcureApi::class)
public fun resolveDocumentsConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveDocumentsConflictsParams>(params)
	runBlocking {
		sdk.system.resolveDocumentsConflicts(
			decodedParams.ids,
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resolveDocumentsConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ResolveDocumentsConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.resolveDocumentsConflicts(
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

@OptIn(InternalIcureApi::class)
public fun getIndexingInfoByGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetIndexingInfoByGroupParams>(params)
	runBlocking {
		sdk.system.getIndexingInfoByGroup(
			decodedParams.groupId,
		)
	}
}.toPyString(IndexingInfo.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getIndexingInfoByGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetIndexingInfoByGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getIndexingInfoByGroup(
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(IndexingInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReplicatorInfoParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun getReplicatorInfoBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReplicatorInfoParams>(params)
	runBlocking {
		sdk.system.getReplicatorInfo(
			decodedParams.id,
		)
	}
}.toPyString(ReplicatorDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReplicatorInfoAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReplicatorInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.getReplicatorInfo(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ReplicatorDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EvictAllFromMapParams(
	public val mapName: String,
)

@OptIn(InternalIcureApi::class)
public fun evictAllFromMapBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EvictAllFromMapParams>(params)
	runBlocking {
		sdk.system.evictAllFromMap(
			decodedParams.mapName,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun evictAllFromMapAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<EvictAllFromMapParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.system.evictAllFromMap(
				decodedParams.mapName,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
