package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.RsaService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.entities.IcureKeyInfo
import com.icure.sdk.crypto.UserSignatureKeysManager
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.LruCacheWithAsyncRetrieve
import com.icure.sdk.utils.SingleValueAsyncCache

@InternalIcureApi
class UserSignatureKeysManagerImpl(
	private val iCureStorage: IcureStorageFacade,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService
) : UserSignatureKeysManager {
	private val signatureKeyCache: SingleValueAsyncCache<
		IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>>,
		Unit
	> = SingleValueAsyncCache()
	private data class LoadedKey(val key: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>?)
	private val verificationKeysCache = LruCacheWithAsyncRetrieve<KeypairFingerprintV2String, LoadedKey>(20)

	override suspend fun getOrCreateSignatureKeyPair(): IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>> =
		signatureKeyCache.getCachedOrRetrieve {
			(
				iCureStorage.loadSignatureKey(dataOwnerApi.getCurrentDataOwnerId()) ?: cryptoService.rsa.generateKeyPair(
					RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256,
					RsaService.KeySize.Rsa2048
				)
			).let {
				IcureKeyInfo(cryptoService.rsa.exportSpkiHex(it.public), it) to Unit
			}
		}.first.also {
			verificationKeysCache.set(it.pubSpkiHexString.fingerprintV2(), LoadedKey(it.key.public))
		}

	override suspend fun getSignatureVerificationKey(fingerprint: KeypairFingerprintV2String): PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>? =
		verificationKeysCache.getCachedOrRetrieve(fingerprint) {
			LoadedKey(iCureStorage.loadSignatureVerificationKey(dataOwnerApi.getCurrentDataOwnerId(), KeypairFingerprintV1String.fromV2(fingerprint)))
		}.key
}