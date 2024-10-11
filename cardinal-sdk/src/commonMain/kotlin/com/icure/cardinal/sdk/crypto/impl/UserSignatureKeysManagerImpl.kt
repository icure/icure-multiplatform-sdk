package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.RsaService
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.UserSignatureKeysManager
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.LruCacheWithAsyncRetrieve
import com.icure.cardinal.sdk.utils.SingleValueAsyncCache

@InternalIcureApi
class UserSignatureKeysManagerImpl(
	private val iCureStorage: CardinalStorageFacade,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService
) : UserSignatureKeysManager {
	private val signatureKeyCache: SingleValueAsyncCache<
		CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>>,
		Unit
	> = SingleValueAsyncCache()
	private data class LoadedKey(val key: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>?)
	private val verificationKeysCache = LruCacheWithAsyncRetrieve<KeypairFingerprintV2String, LoadedKey>(20)

	override suspend fun getOrCreateSignatureKeyPair(): CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>> =
		signatureKeyCache.getCachedOrRetrieve {
			(
				iCureStorage.loadSignatureKey(dataOwnerApi.getCurrentDataOwnerId()) ?: cryptoService.rsa.generateKeyPair(
					RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256,
					RsaService.KeySize.Rsa2048
				).also {
					iCureStorage.saveSignatureKeyPair(dataOwnerApi.getCurrentDataOwnerId(), it)
				}
			).let {
				CardinalKeyInfo(cryptoService.rsa.exportSpkiHex(it.public), it) to Unit
			}
		}.first.also {
			verificationKeysCache.set(it.pubSpkiHexString.fingerprintV2(), LoadedKey(it.key.public))
		}

	override suspend fun getSignatureVerificationKey(fingerprint: KeypairFingerprintV2String): PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>? =
		verificationKeysCache.getCachedOrRetrieve(fingerprint) {
			LoadedKey(iCureStorage.loadSignatureVerificationKey(dataOwnerApi.getCurrentDataOwnerId(), KeypairFingerprintV1String.fromV2(fingerprint)))
		}.key
}