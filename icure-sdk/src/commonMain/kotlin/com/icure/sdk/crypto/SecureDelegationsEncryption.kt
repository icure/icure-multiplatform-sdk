package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.HexString
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.model.SecureDelegation
import com.icure.sdk.utils.InternalIcureApi
@InternalIcureApi
interface SecureDelegationsEncryption {
	/**
	 * If the secure delegation has an encrypted exchange data id attempts to decrypt it with the available keys for the current user.
	 * @param encryptedExchangeIds a map that associates an encrypted exchange data id to the fingerprint of the public key used to encrypt it.
	 * @return the id of the exchange data used for the encryption of the provided secure delegation if it was encrypted and could be decrypted,
	 * undefined otherwise (there was no encrypted id of the exchange data, or it could not be decrypted as no key was available).
	 */
	suspend fun decryptExchangeDataId(encryptedExchangeIds: Map<KeypairFingerprintV2String, Base64String>): String?

	/**
	 * Encrypts the exchange data id for a secure delegation. To avoid leaks of sensitive data the provided public keys should be only keys of users
	 * which DO NOT REQUIRE anonymous delegations
	 */
	suspend fun encryptExchangeDataId(exchangeDataId: String, publicKeys: VerifiedRsaEncryptionKeysSet): Map<KeypairFingerprintV2String, Base64String>

	suspend fun encryptEncryptionKey(hexKey: HexString, key: AesKey): Base64String

	suspend fun encryptEncryptionKeys(hexKeys: Set<HexString>, key: AesKey): Set<Base64String>

	suspend fun decryptEncryptionKey(encrypted: Base64String, key: AesKey): HexString

	suspend fun decryptEncryptionKeys(delegation: SecureDelegation, key: AesKey): Set<HexString>
	
	suspend fun encryptSecretId(secretId: String, key: AesKey): Base64String

	suspend fun encryptSecretIds(secretIds: Set<String>, key: AesKey): Set<Base64String>

	suspend fun decryptSecretId(encrypted: Base64String, key: AesKey): String

	suspend fun decryptSecretIds(delegation: SecureDelegation, key: AesKey): Set<String>

	suspend fun encryptOwningEntityId(owningEntityId: String, key: AesKey): Base64String

	suspend fun encryptOwningEntityIds(owningEntityIds: Set<String>, key: AesKey): Set<Base64String>

	suspend fun decryptOwningEntityId(encrypted: Base64String, key: AesKey): String

	suspend fun decryptOwningEntityIds(delegation: SecureDelegation, key: AesKey): Set<String>
}
