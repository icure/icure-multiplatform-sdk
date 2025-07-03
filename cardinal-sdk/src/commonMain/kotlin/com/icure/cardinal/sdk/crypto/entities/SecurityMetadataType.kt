package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.AesService
import com.icure.utils.InternalIcureApi

/**
 * @param DecryptedType the type of the decrypted security metadata. Must properly implement hashCode / equal, required
 * for proper deduplication of values.
 */
@InternalIcureApi
sealed interface SecurityMetadataType<DecryptedType : Any> {
	fun extractLegacyDelegations(entity: HasEncryptionMetadata): Map<String, Set<Delegation>>
	suspend fun validateLegacyDecrypted(result: String): Boolean
	fun mapLegacyDecrypted(result: String): DecryptedType
	suspend fun decryptSecureDelegation(
		delegation: SecureDelegation,
		key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		secureDelegationsEncryption: SecureDelegationsEncryption
	): Set<DecryptedType>
	fun hasValueIn(delegation: SecureDelegation): Boolean

	data object SecretId : SecurityMetadataType<String> {
		override fun extractLegacyDelegations(entity: HasEncryptionMetadata) =
			entity.delegations

		override suspend fun validateLegacyDecrypted(result: String): Boolean =
			true

		override fun mapLegacyDecrypted(result: String): String =
			result

		override suspend fun decryptSecureDelegation(
			delegation: SecureDelegation,
			key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
			secureDelegationsEncryption: SecureDelegationsEncryption
		): Set<String> =
			secureDelegationsEncryption.decryptSecretIds(delegation, key)

		override fun hasValueIn(delegation: SecureDelegation): Boolean =
			delegation.secretIds.isNotEmpty()
	}

	data object OwningEntityId : SecurityMetadataType<String> {
		override fun extractLegacyDelegations(entity: HasEncryptionMetadata) =
			entity.cryptedForeignKeys

		override suspend fun validateLegacyDecrypted(result: String): Boolean =
			true

		override fun mapLegacyDecrypted(result: String): String =
			result

		override suspend fun decryptSecureDelegation(
			delegation: SecureDelegation,
			key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
			secureDelegationsEncryption: SecureDelegationsEncryption
		): Set<String> =
			secureDelegationsEncryption.decryptOwningEntityIds(delegation, key)

		override fun hasValueIn(delegation: SecureDelegation): Boolean =
			delegation.owningEntityIds.isNotEmpty()
	}

	data object EncryptionKey : SecurityMetadataType<HexString> {
		private val uuidChars = "0123456789abcdefABCDEF-".toSet()

		override fun extractLegacyDelegations(entity: HasEncryptionMetadata) =
			if (
				entity.encryptionKeys.isNotEmpty()
				|| entity.securityMetadata?.secureDelegations?.any { it.value.encryptionKeys.isNotEmpty() } == true
			) {
				// There are some encryption keys defined for the entity (either legacy or in secure delegations)
				entity.encryptionKeys
			} else {
				/*
				 * There are no encryption keys set for the entity.
				 * This is either a super-legacy entity that was not yet migrated (uses the value in legacy delegations
				 * as encryption key), or simply the entity was not encrypted.
				 * Try to use legacy delegation if present as encryption key.
				 * This is still needed as there are some cases where users need to migrate data from
				 * the old "iCure for MAC"; we may lock this behind a configuration value if needed.
				 */
				entity.delegations
			}

		override suspend fun validateLegacyDecrypted(result: String): Boolean =
			result.all { it in uuidChars } && result.count { it != '-' }.let { hexDigitSize ->
				hexDigitSize % 2 == 0 && (hexDigitSize / 2).let { byteSize ->
					byteSize == AesService.KeySize.Aes128.byteSize || byteSize == AesService.KeySize.Aes256.byteSize
				}
			}

		override fun mapLegacyDecrypted(result: String): HexString =
			HexString(result.filter { it != '-' })

		override suspend fun decryptSecureDelegation(
			delegation: SecureDelegation,
			key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
			secureDelegationsEncryption: SecureDelegationsEncryption
		): Set<HexString> =
			secureDelegationsEncryption.decryptEncryptionKeys(delegation, key)

		override fun hasValueIn(delegation: SecureDelegation): Boolean =
			delegation.encryptionKeys.isNotEmpty()
	}
}
