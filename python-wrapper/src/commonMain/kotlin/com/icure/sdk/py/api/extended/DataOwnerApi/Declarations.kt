// auto-generated file
package com.icure.sdk.py.api.extended.DataOwnerApi

import com.icure.sdk.IcureApis
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
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

public fun getCurrentDataOwnerBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwner()
	}
}.toPyString(DataOwnerWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwner()
		}.toPyStringAsyncCallback(DataOwnerWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerStubBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerStub()
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerStubAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerStub()
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerIdBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerId()
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerIdAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerId()
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerHierarchyIdsBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchyIds()
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyIdsAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchyIds()
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnerParams(
	public val ownerId: String,
)

public fun getDataOwnerBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnerParams>(params)
	runBlocking {
		sdk.dataOwner.getDataOwner(
			decodedParams.ownerId,
		)
	}
}.toPyString(DataOwnerWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDataOwnerAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnerParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getDataOwner(
				decodedParams.ownerId,
			)
		}.toPyStringAsyncCallback(DataOwnerWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnerStubParams(
	public val ownerId: String,
)

public fun getDataOwnerStubBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnerStubParams>(params)
	runBlocking {
		sdk.dataOwner.getDataOwnerStub(
			decodedParams.ownerId,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDataOwnerStubAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnerStubParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getDataOwnerStub(
				decodedParams.ownerId,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCurrentDataOwnerHierarchyIdsFromParams(
	public val parentId: String,
)

public fun getCurrentDataOwnerHierarchyIdsFromBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCurrentDataOwnerHierarchyIdsFromParams>(params)
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchyIdsFrom(
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyIdsFromAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCurrentDataOwnerHierarchyIdsFromParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchyIdsFrom(
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerHierarchyBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerHierarchy()
	}
}.toPyString(ListSerializer(DataOwnerWithType.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerHierarchyAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerHierarchy()
		}.toPyStringAsyncCallback(ListSerializer(DataOwnerWithType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDataOwnerStubParams(
	public val cryptoActorStubWithTypeDto: CryptoActorStubWithType,
)

public fun modifyDataOwnerStubBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDataOwnerStubParams>(params)
	runBlocking {
		sdk.dataOwner.modifyDataOwnerStub(
			decodedParams.cryptoActorStubWithTypeDto,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyDataOwnerStubAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDataOwnerStubParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.modifyDataOwnerStub(
				decodedParams.cryptoActorStubWithTypeDto,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentDataOwnerTypeBlocking(sdk: IcureApis): String = kotlin.runCatching {
	runBlocking {
		sdk.dataOwner.getCurrentDataOwnerType()
	}
}.toPyString(DataOwnerType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentDataOwnerTypeAsync(sdk: IcureApis,
		resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>):
		Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCurrentDataOwnerType()
		}.toPyStringAsyncCallback(DataOwnerType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCryptoActorStubParams(
	public val ownerId: String,
)

public fun getCryptoActorStubBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCryptoActorStubParams>(params)
	runBlocking {
		sdk.dataOwner.getCryptoActorStub(
			decodedParams.ownerId,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCryptoActorStubAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCryptoActorStubParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.dataOwner.getCryptoActorStub(
				decodedParams.ownerId,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun clearCurrentDataOwnerIdsCache(sdk: IcureApis): String = kotlin.runCatching {
	sdk.dataOwner.clearCurrentDataOwnerIdsCache()
}.toPyString(Unit.serializer())
