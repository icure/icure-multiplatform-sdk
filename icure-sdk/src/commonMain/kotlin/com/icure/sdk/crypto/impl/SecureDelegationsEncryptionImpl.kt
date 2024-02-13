package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.crypto.SecureDelegationsEncryption
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.HexString
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.model.SecureDelegation
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.base64Encode
import com.icure.sdk.utils.decode
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray

@InternalIcureApi
class SecureDelegationsEncryptionImpl(
	private val userEncryptionKeys: UserEncryptionKeysManager,
	private val cryptoService: CryptoService
) : SecureDelegationsEncryption {
	companion object {
		/**
		 * WARNING: this values should be ALWAYS be the string 'Cure' and its utf-8 bytes. If changed, it would not be possible to decrypt old secretIds and owningEntityIds
		 * anymore.
		 */
		private const val decryptionValidatorPrefix = "Cure"
		private val decryptionValidatorBytes = decryptionValidatorPrefix.toByteArray(Charsets.UTF_8)
	}

	override suspend fun decryptExchangeDataId(encryptedExchangeIds: Map<KeypairFingerprintV2String, Base64String>): String? =
		cryptoService.decryptDataWithKeys(
			encryptedExchangeIds,
			userEncryptionKeys.getDecryptionKeys(),
			KeyIdentifierFormat.FingerprintV2
		)?.decodeToString()

	override suspend fun encryptExchangeDataId(
		exchangeDataId: String,
		publicKeys: VerifiedRsaEncryptionKeysSet
	): Map<KeypairFingerprintV2String, Base64String> =
		cryptoService.encryptDataWithKeys(
			exchangeDataId.toByteArray(Charsets.UTF_8),
			publicKeys,
			KeyIdentifierFormat.FingerprintV2
		)

	override suspend fun encryptEncryptionKey(hexKey: HexString, key: AesKey): Base64String =
		cryptoService.aes.encrypt(
			decryptionValidatorBytes + hexKey.decodedBytes(),
			key
		).base64Encode()

	override suspend fun encryptEncryptionKeys(hexKeys: Set<HexString>, key: AesKey): Set<Base64String> =
		hexKeys.mapTo(mutableSetOf()) { encryptEncryptionKey(it, key) }

	override suspend fun decryptEncryptionKey(encrypted: Base64String, key: AesKey): HexString =
		cryptoService.aes.decrypt(encrypted.decode(), key).also {
			if (!it.sliceArray(0 until decryptionValidatorBytes.size).contentEquals(decryptionValidatorBytes))
				throw IllegalEntityException("Decrypted key is not valid")
		}.let { HexString(it.sliceArray(decryptionValidatorBytes.size until it.size).toHexString()) }

	override suspend fun decryptEncryptionKeys(delegation: SecureDelegation, key: AesKey): Set<HexString> =
		delegation.encryptionKeys.mapTo(mutableSetOf()) { decryptEncryptionKey(it, key) }

	override suspend fun encryptSecretId(secretId: String, key: AesKey): Base64String =
		cryptoService.aes.encrypt(
			(decryptionValidatorPrefix + secretId).toByteArray(Charsets.UTF_8),
			key
		).base64Encode()

	override suspend fun encryptSecretIds(secretIds: Set<String>, key: AesKey): Set<Base64String> =
		secretIds.mapTo(mutableSetOf()) { encryptSecretId(it, key) }

	override suspend fun decryptSecretId(encrypted: Base64String, key: AesKey): String =
		cryptoService.aes.decrypt(encrypted.decode(), key).let {
			val decrypted = it.decodeToString()
			if (!decrypted.startsWith(decryptionValidatorPrefix)) throw IllegalEntityException("Decrypted secretId is not valid")
			decrypted.substring(decryptionValidatorPrefix.length)
		}

	override suspend fun decryptSecretIds(delegation: SecureDelegation, key: AesKey): Set<String> =
		delegation.secretIds.mapTo(mutableSetOf()) { decryptSecretId(it, key) }

	override suspend fun encryptOwningEntityId(owningEntityId: String, key: AesKey): Base64String =
		cryptoService.aes.encrypt(
			(decryptionValidatorPrefix + owningEntityId).toByteArray(Charsets.UTF_8),
			key
		).base64Encode()

	override suspend fun encryptOwningEntityIds(owningEntityIds: Set<String>, key: AesKey): Set<Base64String> =
		owningEntityIds.mapTo(mutableSetOf()) { encryptOwningEntityId(it, key) }

	override suspend fun decryptOwningEntityId(encrypted: Base64String, key: AesKey): String =
		cryptoService.aes.decrypt(encrypted.decode(), key).let {
			val decrypted = it.decodeToString()
			if (!decrypted.startsWith(decryptionValidatorPrefix)) throw IllegalEntityException("Decrypted owningEntityId is not valid")
			decrypted.substring(decryptionValidatorPrefix.length)
		}

	override suspend fun decryptOwningEntityIds(delegation: SecureDelegation, key: AesKey): Set<String> =
		delegation.owningEntityIds.mapTo(mutableSetOf()) { decryptOwningEntityId(it, key) }
}