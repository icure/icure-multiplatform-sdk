package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.ShamirKeysManagerApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override suspend fun forceReload() {
		internal.forceReload()
	}

	override suspend fun currentDataOwnerKeys(
		filterTrustedKeys: Boolean
	): Map<String, Map<KeypairFingerprintV1String, ByteArray>> =
		internal.userEncryptionKeysManager.getCurrentUserHierarchyAvailableKeypairs().run {
			listOf(self) + parents
		}.associate { keyInfo ->
			keyInfo.dataOwnerId to keyInfo.keys.filter { cachedKeypairDetails ->
				!filterTrustedKeys || cachedKeypairDetails.isDevice || cachedKeypairDetails.isVerified
			}.associate { cachedKeypairDetails ->
				Pair(
					cachedKeypairDetails.keyPair.pubSpkiHexString.fingerprintV1(),
					defaultCryptoService.rsa.exportPrivateKeyPkcs8(cachedKeypairDetails.keyPair.key.private)
				)
			}
		}
}