package com.icure.cardinal.sdk.crypto

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.utils.InternalIcureApi

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

	suspend fun encryptEncryptionKey(hexKey: HexString, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String

	suspend fun encryptEncryptionKeys(hexKeys: Set<HexString>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String>

	suspend fun decryptEncryptionKey(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): HexString

	suspend fun decryptEncryptionKeys(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<HexString>
	
	suspend fun encryptSecretId(secretId: String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String

	suspend fun encryptSecretIds(secretIds: Set<String>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String>

	suspend fun decryptSecretId(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): String

	suspend fun decryptSecretIds(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<String>

	suspend fun encryptOwningEntityId(owningEntityId: String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String

	suspend fun encryptOwningEntityIds(owningEntityIds: Set<String>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String>

	suspend fun decryptOwningEntityId(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): String

	suspend fun decryptOwningEntityIds(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<String>
}
