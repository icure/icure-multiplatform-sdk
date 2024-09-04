package com.icure.sdk.py.PyCryptoStrategies

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.crypto.entities.map
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.withResultHolder
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun create(
	pyRecoverAndVerifySelfHierarchyKeys: CPointer<CFunction<(resultHolder: COpaquePointer, keysData: CValues<ByteVar>, keyPairRecoverer: COpaquePointer) -> Unit>>,
	pyGenerateNewKeyForDataOwner: CPointer<CFunction<(resultHolder: COpaquePointer, self: CValues<ByteVar>) -> Unit>>,
	pyVerifyDelegatePublicKeys: CPointer<CFunction<(resultHolder: COpaquePointer, delegate: CValues<ByteVar>, publicKeys: CValues<ByteVar>) -> Unit>>,
	pyDataOwnerRequiresAnonymousDelegation: CPointer<CFunction<(resultHolder: COpaquePointer, dataOwner: CValues<ByteVar>) -> Unit>>
): COpaquePointer {
	val strategies = object : CryptoStrategies {
		override suspend fun recoverAndVerifySelfHierarchyKeys(
			keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
			cryptoPrimitives: CryptoService,
			keyPairRecoverer: KeyPairRecoverer
		): Map<String, CryptoStrategies.RecoveredKeyData> {
			val keyPairRecovererStableRef = StableRef.create(keyPairRecoverer)
			return try {
				withResultHolder(MapSerializer(String.serializer(), PyRecoveredKeyData.serializer())) { resultHolder ->
					pyRecoverAndVerifySelfHierarchyKeys(
						resultHolder,
						Serialization.fullLanguageInteropJson.encodeToString(ListSerializer(CryptoStrategies.KeyDataRecoveryRequest.serializer()), keysData).cstr,
						keyPairRecovererStableRef.asCPointer()
					)
				}.toKt()
			} finally {
				keyPairRecovererStableRef.dispose()
			}
		}

		override suspend fun generateNewKeyForDataOwner(
			self: DataOwnerWithType,
			cryptoPrimitives: CryptoService
		): CryptoStrategies.KeyGenerationRequestResult = withResultHolder(PyKeyGenerationRequestResult.serializer()) { resultHolderPtr ->
			pyGenerateNewKeyForDataOwner(
				resultHolderPtr,
				Serialization.fullLanguageInteropJson.encodeToString(DataOwnerWithType.serializer(), self).cstr
			)
		}.toKt()

		override suspend fun verifyDelegatePublicKeys(
			delegate: CryptoActorStubWithType,
			publicKeys: List<SpkiHexString>,
			cryptoPrimitives: CryptoService
		): List<SpkiHexString> = withResultHolder(ListSerializer(SpkiHexString.serializer())) { resultHolder ->
			pyVerifyDelegatePublicKeys.invoke(
				resultHolder,
				Serialization.fullLanguageInteropJson.encodeToString(CryptoActorStubWithType.serializer(), delegate).cstr,
				Serialization.fullLanguageInteropJson.encodeToString(ListSerializer(SpkiHexString.serializer()), publicKeys).cstr,
			)
		}

		override suspend fun dataOwnerRequiresAnonymousDelegation(
			dataOwner: CryptoActorStubWithType
		): Boolean = withResultHolder(Boolean.serializer()) { resultHolder ->
			pyDataOwnerRequiresAnonymousDelegation.invoke(
				resultHolder,
				Serialization.fullLanguageInteropJson.encodeToString(CryptoActorStubWithType.serializer(), dataOwner).cstr
			)
		}
	}
	return StableRef.create(strategies).asCPointer()
}

@OptIn(ExperimentalForeignApi::class)
fun recoverWithRecoveryKey(
	keyPairRecovererPtr: COpaquePointer,
	recoveryKey: String,
	autoDelete: Boolean
): String = runBlocking {
	kotlin.runCatching {
		keyPairRecovererPtr.asStableRef<KeyPairRecoverer>().get().recoverWithRecoveryKey(
			RecoveryDataKey(HexString(recoveryKey)),
			autoDelete
		)
	}.map { recoveryResult ->
		recoveryResult.map { recoveredKeys ->
			recoveredKeys.mapValues { (_, v) ->
				v.mapValues {
					ExportedRsaKeyPair(
						defaultCryptoService.rsa.exportPrivateKeyPkcs8(it.value.private),
						it.value.algorithm.identifier
					)
				}
			}
		}
	}.toPyString(
		RecoveryResult.serializer(
			MapSerializer(
				String.serializer(),
				MapSerializer(
					SpkiHexString.serializer(),
					ExportedRsaKeyPair.serializer()
				)
			)
		)
	)
}

@Serializable
private sealed interface PyKeyGenerationRequestResult {
	suspend fun toKt(): CryptoStrategies.KeyGenerationRequestResult

	@Serializable
	data object Allow : PyKeyGenerationRequestResult {
		override suspend fun toKt() = CryptoStrategies.KeyGenerationRequestResult.Allow
	}

	@Serializable
	data object Deny : PyKeyGenerationRequestResult {
		override suspend fun toKt() = CryptoStrategies.KeyGenerationRequestResult.Deny
	}
	@Serializable
	class Use(
		@Serializable(with = ByteArraySerializer:: class) val keyPkcs8: ByteArray
	) : PyKeyGenerationRequestResult {
		override suspend fun toKt() = CryptoStrategies.KeyGenerationRequestResult.Use(
			defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, keyPkcs8)
		)
	}
}

@Serializable
private class PyRecoveredKeyData(
	val recoveredKeys: Map<KeypairFingerprintV1String, ExportedRsaKeyPair>,
	val keyAuthenticity: Map<KeypairFingerprintV1String, Boolean>
) {
	suspend fun toKt() = CryptoStrategies.RecoveredKeyData(
		recoveredKeys = recoveredKeys.mapValues { it.value.toKt() },
		keyAuthenticity = keyAuthenticity
	)
}

private suspend fun Map<String, PyRecoveredKeyData>.toKt(): Map<String, CryptoStrategies.RecoveredKeyData> =
	mapValues { it.value.toKt() }

@Serializable
private class ExportedRsaKeyPair(
	@Serializable(with = ByteArraySerializer::class) val private: ByteArray,
	val algorithm: String
) {
	suspend fun toKt(): RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> =
		defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.fromIdentifier(algorithm), private)
}
