package com.icure.cardinal.sdk.storage

import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray

enum class SecureKeyAccessLevel {
	DevicePasscode,
	Biometric,
}

class EncryptedStorageFacade(
	val storage: StorageFacade,
	val encryptionKey: AesKey<CbcWithPkcs7Padding>,
): StorageFacade {

	companion object {
		const val SECRET_KEY = "com.icure.cardinal.sdk.storage.SecureStorageFacade.encryptionKey"
	}

	@OptIn(ExperimentalStdlibApi::class)
	override suspend fun getItem(key: String): String? {
		return storage.getItem(key)?.let { encryptedValue ->
			defaultCryptoService.aes.decrypt(base64Decode(encryptedValue), encryptionKey).decodeToString()
		}
	}

	override suspend fun setItem(key: String, value: String) {
		storage.setItem(key, base64Encode(defaultCryptoService.aes.encrypt(value.toByteArray(Charsets.UTF_8), encryptionKey)))
	}

	override suspend fun removeItem(key: String) {
		storage.removeItem(key)
	}
}
