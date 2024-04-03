package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ShamirKeysManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure

@InternalIcureApi
class ShamirKeysManagerImpl(
	private val dataOwnerApi: DataOwnerApi,
	private val encryptionKeysManager: UserEncryptionKeysManager,
	private val exchangeDataManager: ExchangeDataManager,
	private val cryptoService: CryptoService,
	private val shamir: ShamirSecretSharingService
) : ShamirKeysManager {
	override fun getExistingSplitsInfo(dataOwner: CryptoActor): Map<KeypairFingerprintV1String, Set<String>> {
		val legacyPartitionDelegates = dataOwner.privateKeyShamirPartitions.keys
		return if (legacyPartitionDelegates.isNotEmpty()) {
			val fp = dataOwner.publicKey?.fingerprintV1()
			if (fp == null) {
				println("Invalid data owner: the owner has legacy key partitions but no legacy key.")
				emptyMap()
			} else mapOf(fp to legacyPartitionDelegates)
		} else emptyMap()
	}

	override suspend fun updateSelfSplits(
		keySplitsToUpdate: Map<KeypairFingerprintV1String, ShamirKeysManager.ShamirUpdateRequest>,
		keySplitsToDelete: Set<KeypairFingerprintV1String>,
	): CryptoActorStubWithType {
		val self = this.dataOwnerApi.getCurrentDataOwner().toStub()
		val existingSplits = getExistingSplitsInfo(self.stub).keys
		val allKeys = encryptionKeysManager.getDecryptionKeys()
		keySplitsToDelete.intersect(keySplitsToUpdate.keys).let {
			require (it.isEmpty()) {
				"Can't update and delete the same key at once. $it"
			}
		}
		require (keySplitsToDelete.all { existingSplits.contains(it) }) {
			"Can't delete non-existing key split. $keySplitsToDelete"
		}
		val exchangeDataByDelegate = keySplitsToUpdate.keys.flatMap { keySplitsToUpdate[it]!!.notariesIds }.distinct().associateWith {
			exchangeDataManager.getOrCreateEncryptionDataTo(it, false).unencryptedContent.exchangeKey
		}
		val updatedSelf = keySplitsToUpdate.toList().fold(self) { acc, (key, request) ->
			updateKeySplit(acc, key, request, exchangeDataByDelegate, allKeys)
		}.let {
			keySplitsToDelete.fold(it) { acc, key ->
				deleteKeySplit(acc, key)
			}
		}
		return dataOwnerApi.modifyDataOwnerStub(updatedSelf)
	}

	private suspend fun updateKeySplit(
		dataOwner: CryptoActorStubWithType,
		keyFp: KeypairFingerprintV1String,
		request: ShamirKeysManager.ShamirUpdateRequest,
		exchangeDataByDelegate: Map<String, AesKey>,
		allKeys: RsaDecryptionKeysSet
	): CryptoActorStubWithType {
		require (dataOwner.stub.publicKey?.fingerprintV1() == keyFp) {
			"Currently it is possible to use shamir splits only for the legacy public key"
		}
		return CryptoActorStubWithType(
			type = dataOwner.type,
			stub = dataOwner.stub.copy(
				privateKeyShamirPartitions = this.createPartitionsFor(
					requireNotNull(allKeys.getByFingerprintV1(keyFp)) {
						"Can't create shamir recovery data for keypair ${keyFp.s} since the corresponding private key is not available"
					},
					request,
					exchangeDataByDelegate
				)
			)
		)
	}

	private suspend fun createPartitionsFor(
		key: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>,
		request: ShamirKeysManager.ShamirUpdateRequest,
		exchangeDataByDelegate: Map<String, AesKey>,
	): Map<String, HexString>{
		val keyPkcs8 = cryptoService.rsa.exportPrivateKeyPkcs8(key)
		return if (request.notariesIds.size == 1) {
			encryptShares(listOf(keyPkcs8), request.notariesIds, exchangeDataByDelegate)
		} else {
			val shares = shamir.share(keyPkcs8, request.notariesIds.size, request.minShares)
			val paddedShares = shares.map { "f${it.v}" }
			for (share in paddedShares) {
				ensure (share.matches(Regex("^(?:[0-9a-f][0-9a-f])+$"))) {
					"Unexpected result of shamir split: padded shares should be a valid hex value"
				}
				ensure (share == hexToByteArray(share).toHexString()) {
					"Unexpected result with encoding-decoding share"
				}
			}
			encryptShares(
				paddedShares.map { hexToByteArray(it) },
				request.notariesIds,
				exchangeDataByDelegate
			)
		}
	}

	private suspend fun encryptShares(
		shares: List<ByteArray>,
		delegateIds: Set<String>,
		exchangeDataByDelegate: Map<String, AesKey>
	): Map<String, HexString> {
		ensure(shares.size == delegateIds.size) {
			"Unexpected number of shares and delegates"
		}
		return shares.zip(delegateIds).associate { (share, delegateId) ->
			delegateId to HexString(cryptoService.aes.encrypt(share, exchangeDataByDelegate.getValue(delegateId)).toHexString())
		}
	}

	private fun deleteKeySplit(
		dataOwner: CryptoActorStubWithType,
		keyFp: KeypairFingerprintV1String
	): CryptoActorStubWithType {
		require(dataOwner.stub.publicKey?.fingerprintV1() == keyFp) {
			"Currently it is possible to use shamir splits only for the legacy public key"
		}
		return CryptoActorStubWithType(
			type = dataOwner.type,
			stub = dataOwner.stub.copy(
				privateKeyShamirPartitions = emptyMap()
			)
		)
	}
}
