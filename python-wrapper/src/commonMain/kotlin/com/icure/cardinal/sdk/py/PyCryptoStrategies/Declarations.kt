package com.icure.cardinal.sdk.py.PyCryptoStrategies

import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.py.utils.withResultHolder
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun create(
	pyGenerateNewKeyForDataOwner: CPointer<CFunction<(resultHolder: COpaquePointer, self: CValues<ByteVar>) -> Unit>>,
	pyVerifyDelegatePublicKeys: CPointer<CFunction<(resultHolder: COpaquePointer, delegate: CValues<ByteVar>, publicKeys: CValues<ByteVar>) -> Unit>>,
	pyDataOwnerRequiresAnonymousDelegation: CPointer<CFunction<(resultHolder: COpaquePointer, dataOwner: CValues<ByteVar>) -> Unit>>
): COpaquePointer {
	val strategies = object : CryptoStrategies {
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
private class ExportedRsaKeyPair(
	@Serializable(with = ByteArraySerializer::class) val private: ByteArray,
	val algorithm: String
) {
	suspend fun toKt(): RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> =
		defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.fromIdentifier(algorithm), private)
}
