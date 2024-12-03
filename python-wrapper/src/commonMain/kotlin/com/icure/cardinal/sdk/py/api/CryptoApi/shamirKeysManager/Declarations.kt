// auto-generated file
package com.icure.cardinal.sdk.py.api.CryptoApi.shamirKeysManager

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.CryptoActorAsStubDeserializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetExistingSplitsInfoParams(
	@Serializable(CryptoActorAsStubDeserializer::class)
	@OptIn(InternalIcureApi::class)
	public val dataOwner: CryptoActor,
)

@OptIn(InternalIcureApi::class)
public fun getExistingSplitsInfo(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetExistingSplitsInfoParams>(params)
	sdk.crypto.shamirKeysManager.getExistingSplitsInfo(
		decodedParams.dataOwner,
	)
}.toPyString(MapSerializer(KeypairFingerprintV1String.serializer(),
		SetSerializer(String.serializer())))

@Serializable
private class UpdateSelfSplitsParams(
	public val keySplitsToUpdate: Map<KeypairFingerprintV1String, ShamirUpdateRequest>,
	public val keySplitsToDelete: Set<KeypairFingerprintV1String>,
)

@OptIn(InternalIcureApi::class)
public fun updateSelfSplitsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateSelfSplitsParams>(params)
	runBlocking {
		sdk.crypto.shamirKeysManager.updateSelfSplits(
			decodedParams.keySplitsToUpdate,
			decodedParams.keySplitsToDelete,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateSelfSplitsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateSelfSplitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.shamirKeysManager.updateSelfSplits(
				decodedParams.keySplitsToUpdate,
				decodedParams.keySplitsToDelete,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
