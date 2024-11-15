package com.icure.cardinal.sdk.storage

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import io.ktor.utils.io.core.toByteArray

class SecureStorageFacade private constructor (
	val storage: StorageFacade,
	val encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	val cryptoService: CryptoService
): StorageFacade {

	companion object {
		const val SECRET_KEY = "com.icure.cardinal.sdk.storage.SecureStorageFacade.encryptionKey"

		suspend operator fun invoke(storage: StorageFacade, cryptoService: CryptoService = defaultCryptoService, accessLevel: Set<SecureKeyAccessLevel>): SecureStorageFacade {
			val encryptionKey = getOrCreateSecretKey(storage, SECRET_KEY, accessLevel)
			return SecureStorageFacade(storage, encryptionKey, cryptoService)
		}
	}

	override suspend fun getItem(key: String): String? {
		return storage.getItem(key)?.let { encryptedValue ->
			cryptoService.aes.decrypt(encryptedValue.toByteArray(), encryptionKey).toString()
		}
	}

	override suspend fun setItem(key: String, value: String) {
		storage.setItem(key, cryptoService.aes.encrypt(value.toByteArray(), encryptionKey).toString())
	}

	override suspend fun removeItem(key: String) {
		storage.removeItem(key)
	}
}

/**
 * Get or create a secret key for encryption.
 *
 * @param storageFacade The storage facade to use to store the secret key.
 * @param key The key to use to store/access the AES key.
 */
expect suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding>

enum class SecureKeyAccessLevel {
	DevicePasscode,
	Biometric,
}
