// auto-generated file
package com.icure.cardinal.sdk.py.api.CryptoApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.Pkcs8BytesAsBase64Serializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
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
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer

public fun forceReloadBlocking(sdk: CardinalApis): String = kotlin.runCatching {
	runBlocking {
		sdk.crypto.forceReload()
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun forceReloadAsync(sdk: CardinalApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.forceReload()
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CurrentDataOwnerKeysParams(
	public val filterTrustedKeys: Boolean = true,
)

@OptIn(InternalIcureApi::class)
public fun currentDataOwnerKeysBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CurrentDataOwnerKeysParams>(params)
	runBlocking {
		sdk.crypto.currentDataOwnerKeys(
			decodedParams.filterTrustedKeys,
		)
	}
}.toPyString(MapSerializer(String.serializer(),
		MapSerializer(KeypairFingerprintV1String.serializer(), Pkcs8BytesAsBase64Serializer)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun currentDataOwnerKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CurrentDataOwnerKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.currentDataOwnerKeys(
				decodedParams.filterTrustedKeys,
			)
		}.toPyStringAsyncCallback(MapSerializer(String.serializer(),
				MapSerializer(KeypairFingerprintV1String.serializer(), Pkcs8BytesAsBase64Serializer)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
