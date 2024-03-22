package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.SpkiHexString

object BasicCryptoStrategies : CryptoStrategies {
	override suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, CryptoStrategies.RecoveredKeyData> =
		keysData.associate {
			it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
				emptyMap(),
				emptyMap()
			)
		}

	override suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): CryptoStrategies.KeyGenerationRequestResult =
		CryptoStrategies.KeyGenerationRequestResult.Allow

	override suspend fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithType,
		publicKeys: List<SpkiHexString>,
		cryptoPrimitives: CryptoService
	): List<SpkiHexString> =
		publicKeys

	override suspend fun dataOwnerRequiresAnonymousDelegation(dataOwner: CryptoActorStubWithType): Boolean =
		dataOwner.type != DataOwnerType.Hcp
}