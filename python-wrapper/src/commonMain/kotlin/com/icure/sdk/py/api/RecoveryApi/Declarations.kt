// auto-generated file
package com.icure.sdk.py.api.RecoveryApi

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.py.serialization.RsaEncryptionAlgorithmSerializer
import com.icure.sdk.py.serialization.RsaKeypairSerializer
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
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateRecoveryInfoForAvailableKeyPairsParams(
	public val includeParentsKeys: Boolean = false,
	public val lifetimeSeconds: Int? = null,
)

public fun createRecoveryInfoForAvailableKeyPairsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateRecoveryInfoForAvailableKeyPairsParams>(params)
	runBlocking {
		sdk.recovery.createRecoveryInfoForAvailableKeyPairs(
			decodedParams.includeParentsKeys,
			decodedParams.lifetimeSeconds,
		)
	}
}.toPyString(RecoveryDataKey.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createRecoveryInfoForAvailableKeyPairsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateRecoveryInfoForAvailableKeyPairsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.createRecoveryInfoForAvailableKeyPairs(
				decodedParams.includeParentsKeys,
				decodedParams.lifetimeSeconds,
			)
		}.toPyStringAsyncCallback(RecoveryDataKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RecoverKeyPairsParams(
	public val recoveryKey: RecoveryDataKey,
	public val autoDelete: Boolean,
)

public fun recoverKeyPairsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RecoverKeyPairsParams>(params)
	runBlocking {
		sdk.recovery.recoverKeyPairs(
			decodedParams.recoveryKey,
			decodedParams.autoDelete,
		)
	}
}.toPyString(RecoveryResult.serializer(MapSerializer(String.serializer(),
		MapSerializer(SpkiHexString.serializer(),
		RsaKeypairSerializer(RsaEncryptionAlgorithmSerializer)))))

@OptIn(ExperimentalForeignApi::class)
public fun recoverKeyPairsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RecoverKeyPairsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.recoverKeyPairs(
				decodedParams.recoveryKey,
				decodedParams.autoDelete,
			)
		}.toPyStringAsyncCallback(RecoveryResult.serializer(MapSerializer(String.serializer(),
				MapSerializer(SpkiHexString.serializer(),
				RsaKeypairSerializer(RsaEncryptionAlgorithmSerializer)))), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateExchangeDataRecoveryInfoParams(
	public val delegateId: String,
	public val lifetimeSeconds: Int? = null,
)

public fun createExchangeDataRecoveryInfoBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateExchangeDataRecoveryInfoParams>(params)
	runBlocking {
		sdk.recovery.createExchangeDataRecoveryInfo(
			decodedParams.delegateId,
			decodedParams.lifetimeSeconds,
		)
	}
}.toPyString(RecoveryDataKey.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createExchangeDataRecoveryInfoAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateExchangeDataRecoveryInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.createExchangeDataRecoveryInfo(
				decodedParams.delegateId,
				decodedParams.lifetimeSeconds,
			)
		}.toPyStringAsyncCallback(RecoveryDataKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RecoverExchangeDataParams(
	public val recoveryKey: RecoveryDataKey,
)

public fun recoverExchangeDataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RecoverExchangeDataParams>(params)
	runBlocking {
		sdk.recovery.recoverExchangeData(
			decodedParams.recoveryKey,
		)
	}
}.toPyString(RecoveryDataUseFailureReason.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun recoverExchangeDataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RecoverExchangeDataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.recoverExchangeData(
				decodedParams.recoveryKey,
			)
		}.toPyStringAsyncCallback(RecoveryDataUseFailureReason.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteRecoveryInfoParams(
	public val recoveryKey: RecoveryDataKey,
)

public fun deleteRecoveryInfoBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteRecoveryInfoParams>(params)
	runBlocking {
		sdk.recovery.deleteRecoveryInfo(
			decodedParams.recoveryKey,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteRecoveryInfoAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteRecoveryInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.deleteRecoveryInfo(
				decodedParams.recoveryKey,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAllRecoveryInfoForParams(
	public val dataOwnerId: String,
)

public fun deleteAllRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.deleteAllRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteAllRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.deleteAllRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAllKeyPairRecoveryInfoForParams(
	public val dataOwnerId: String,
)

public fun deleteAllKeyPairRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllKeyPairRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.deleteAllKeyPairRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteAllKeyPairRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllKeyPairRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.deleteAllKeyPairRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAllExchangeDataRecoveryInfoForParams(
	public val dataOwnerId: String,
)

public fun deleteAllExchangeDataRecoveryInfoForBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllExchangeDataRecoveryInfoForParams>(params)
	runBlocking {
		sdk.recovery.deleteAllExchangeDataRecoveryInfoFor(
			decodedParams.dataOwnerId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteAllExchangeDataRecoveryInfoForAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAllExchangeDataRecoveryInfoForParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.recovery.deleteAllExchangeDataRecoveryInfoFor(
				decodedParams.dataOwnerId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
