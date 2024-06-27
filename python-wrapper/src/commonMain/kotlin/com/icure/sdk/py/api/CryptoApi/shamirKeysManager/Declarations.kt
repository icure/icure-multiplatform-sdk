// auto-generated file
package com.icure.sdk.py.api.CryptoApi.shamirKeysManager

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
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
	public val dataOwner: CryptoActor,
)

public fun getExistingSplitsInfo(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetExistingSplitsInfoParams>(params)
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

public fun updateSelfSplitsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateSelfSplitsParams>(params)
	runBlocking {
		sdk.crypto.shamirKeysManager.updateSelfSplits(
			decodedParams.keySplitsToUpdate,
			decodedParams.keySplitsToDelete,
		)
	}
}.toPyString(CryptoActorStubWithType.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateSelfSplitsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateSelfSplitsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.crypto.shamirKeysManager.updateSelfSplits(
				decodedParams.keySplitsToUpdate,
				decodedParams.keySplitsToDelete,
			)
		}.toPyStringAsyncCallback(CryptoActorStubWithType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
