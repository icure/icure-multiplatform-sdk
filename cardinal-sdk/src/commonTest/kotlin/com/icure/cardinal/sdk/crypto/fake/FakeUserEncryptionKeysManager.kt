package com.icure.cardinal.sdk.crypto.fake

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CachedKeypairDetails
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.UserKeyPairInformation
import com.icure.cardinal.sdk.crypto.entities.toPrivateKeyInfo
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class FakeUserEncryptionKeysManager : UserEncryptionKeysManager {
	private val selfKeys = mutableMapOf<KeypairFingerprintV2String, CachedKeypairDetails>()

	fun addSelfKey(
		key: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		verified: Boolean
	) {
		selfKeys[key.pubSpkiHexString.fingerprintV2()] = CachedKeypairDetails(key, verified, verified)
	}

	override fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation {
		TODO("Not yet implemented")
	}

	override fun getCurrentUserAvailablePublicKeysHex(verifiedOnly: Boolean): Set<SpkiHexString> =
		selfKeys.values.filter { !verifiedOnly || it.isVerified }.map { it.keyPair.pubSpkiHexString }.toSet()

	override fun getCurrentUserHierarchyAvailablePublicKeysHex(): Set<SpkiHexString> =
		selfKeys.values.map { it.keyPair.pubSpkiHexString }.toSet()

	override fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails? =
		selfKeys[fingerprint]

	override fun getSelfVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		selfKeys.values.filter { it.isVerified }.map { it.keyPair }.toSet()

	override fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString> {
		TODO("Not yet implemented")
	}

	override fun getDecryptionKeys(includeParent: Boolean): RsaDecryptionKeysSet =
		RsaDecryptionKeysSet(selfKeys.values.map { it.keyPair.toPrivateKeyInfo() })

	override suspend fun reloadKeys() {
	}
}