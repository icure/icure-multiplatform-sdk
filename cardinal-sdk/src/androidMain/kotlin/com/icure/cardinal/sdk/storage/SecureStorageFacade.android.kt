package com.icure.cardinal.sdk.storage

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.icure.kryptom.crypto.AesAlgorithm.CbcWithPkcs7Padding
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<CbcWithPkcs7Padding> {
	return getSecretKey(cryptoService, key, storageFacade) ?: createSecretKey(accessLevel, cryptoService, key, storageFacade)
}

private suspend fun getSecretKey(cryptoService: CryptoService, key: String, storage: StorageFacade): AesKey<CbcWithPkcs7Padding>? {
	val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
	val iv = storage.getItem("$key.iv")?.let { base64Decode(it) }
	val cipherBytes = storage.getItem("$key.cipher")?.let { base64Decode(it) }

	if (iv == null && cipherBytes == null && !keyStore.containsAlias(key)) return null
	if (iv == null || cipherBytes == null) throw IllegalStateException("Missing IV or cipher bytes")
	if (!keyStore.containsAlias(key)) throw IllegalStateException("Key not found in keystore")

	val keyStoreKey = (keyStore.getEntry(key, null) as KeyStore.SecretKeyEntry).secretKey
	return decryptKey(cipherBytes, iv, keyStoreKey, cryptoService)
}

private suspend fun createSecretKey(accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService, key: String, storage: StorageFacade): AesKey<CbcWithPkcs7Padding> {
	val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
	val keyGenParameterSpec = KeyGenParameterSpec.Builder(key, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
		.setBlockModes(KeyProperties.BLOCK_MODE_CBC)
		.setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
		.setUserAuthenticationRequired(true)
		.setUserAuthenticationParameters(30, accessLevel.fold(0) { acc, level -> acc or level.toKeyProperties() })
		.build()
	keyGenerator.init(keyGenParameterSpec)
	val keyStoreKey = keyGenerator.generateKey()
	val aesKey = cryptoService.aes.generateKey(CbcWithPkcs7Padding)
	val (iv, cipherBytes) = encryptKey(aesKey, keyStoreKey, cryptoService)
	storage.setItem("$key.iv", base64Encode(iv))
	storage.setItem("$key.cipher", base64Encode(cipherBytes))
	return aesKey
}

private suspend fun encryptKey(aesKey: AesKey<CbcWithPkcs7Padding>, secretKey: SecretKey, cryptoService: CryptoService): Pair<ByteArray, ByteArray> {
	return try {
		val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
		cipher.init(Cipher.ENCRYPT_MODE, secretKey)

		val iv = cipher.iv
		val cipherBytes = cipher.doFinal(cryptoService.aes.exportKey(aesKey))
		Pair(iv, cipherBytes)
	} catch (e: Exception) {
		throw IllegalStateException("Failed to encrypt key", e)
	}
}

private suspend fun decryptKey(cipherBytes: ByteArray, iv: ByteArray, secretKey: SecretKey, cryptoService: CryptoService): AesKey<CbcWithPkcs7Padding> {
	return try {
		val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
		val spec = IvParameterSpec(iv)
		cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)

		val aesKeyBytes = cipher.doFinal(cipherBytes)
		cryptoService.aes.loadKey(CbcWithPkcs7Padding, aesKeyBytes)
	} catch (e: Exception) {
		throw IllegalStateException("Failed to decrypt key", e)
	}
}

private fun SecureKeyAccessLevel.toKeyProperties(): Int {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> KeyProperties.AUTH_DEVICE_CREDENTIAL
		SecureKeyAccessLevel.Biometric -> KeyProperties.AUTH_BIOMETRIC_STRONG
	}
}
