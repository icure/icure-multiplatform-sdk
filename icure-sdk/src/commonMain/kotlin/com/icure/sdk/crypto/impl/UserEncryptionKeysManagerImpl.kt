package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.EncryptionKeypairDetails
import com.icure.sdk.crypto.IcureKeypair
import com.icure.sdk.crypto.IcureKeyRecovery
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.RsaDecryptionKeysSet
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.UserKeyPairInformation
import com.icure.sdk.model.CryptoActorStub
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
class UserEncryptionKeysManagerImpl(
	private val cryptoService: CryptoService,
	private val cryptoStrategies: CryptoStrategies,
	private val dataOwnerApi: DataOwnerApi,
	private val icureStorage: IcureStorageFacade,
	private val icureKeyRecovery: IcureKeyRecovery,
	private val keyPairRecoverer: KeyPairRecoverer,
	private val initialiseParentKeys: Boolean
) : UserEncryptionKeysManager {

	override suspend fun initialiseKeys(): Pair<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		TODO("Not yet implemented")
	}

	override suspend fun reloadKeys() {
		TODO("Not yet implemented")
	}

	private suspend fun doLoadKeys() {

	}

	override suspend fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentUserAvailablePublicKeysHex(verifiedOnly: Boolean): List<String> {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentUserHierarchyAvailablePublicKeysHex(): List<String> {
		TODO("Not yet implemented")
	}

	override fun getKeyPairForFingerprint(fingerprint: String): EncryptionKeypairDetails? {
		TODO("Not yet implemented")
	}

	override fun getSelfVerifiedKeys(): List<IcureKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		TODO("Not yet implemented")
	}

	override suspend fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): List<String> {
		TODO("Not yet implemented")
	}

	override suspend fun getDecryptionKeys(): RsaDecryptionKeysSet {
		TODO("Not yet implemented")
	}
}