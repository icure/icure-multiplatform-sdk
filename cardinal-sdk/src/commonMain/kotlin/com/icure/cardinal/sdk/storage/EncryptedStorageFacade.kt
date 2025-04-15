package com.icure.cardinal.sdk.storage

import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.Serializable

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
		return storage.getItem(key)?.let { item ->
			runCatching {
				Serialization.json.decodeFromString(EncryptedItem.serializer(), item)
			}.getOrNull()?.let { encryptedItem ->
				val decryptedValue = runCatching {
					defaultCryptoService.aes.decrypt(base64Decode(encryptedItem.encrypted), encryptionKey).decodeToString()
				}.getOrNull()

				if (decryptedValue == null) {
					null
				} else {
					val hash = defaultCryptoService.digest.sha256(decryptedValue.toByteArray(Charsets.UTF_8))

					decryptedValue.takeIf {
						hash.contentEquals(base64Decode(encryptedItem.hash))
					}
				}
			}

			defaultCryptoService.aes.decrypt(base64Decode(item), encryptionKey).decodeToString()
		}
	}

	override suspend fun setItem(key: String, value: String) {
		val item = EncryptedItem(
			encrypted = base64Encode(defaultCryptoService.aes.encrypt(value.toByteArray(Charsets.UTF_8), encryptionKey)),
			hash = base64Encode(defaultCryptoService.digest.sha256(value.toByteArray(Charsets.UTF_8))),
		)
		storage.setItem(key, Serialization.json.encodeToString(item))
	}

	override suspend fun removeItem(key: String) {
		storage.removeItem(key)
	}
}

@Serializable
private data class EncryptedItem(
	val encrypted: String,
	val hash: String,
)
