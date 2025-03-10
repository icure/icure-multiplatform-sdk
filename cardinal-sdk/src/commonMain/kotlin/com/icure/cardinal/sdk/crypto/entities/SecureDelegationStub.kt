package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.Sha256HexString
import com.icure.cardinal.sdk.model.embed.SecureDelegation

/**
 * A stub to support the creation of a secure delegation.
 */
data class SecureDelegationStub(
	/**
	 * Aes encryption key in hex format to use for the encryption of [SecureDelegation.encryptionKeys],
	 * [SecureDelegation.owningEntityIds], and [SecureDelegation.secretIds].
	 * Note: this MUST NOT be included in the created secure delegation nor in the security metadata.
	 */
	val encryptionKeyHex: HexString,
	/**
	 * The key to use for the secure delegations created using this stub.
	 * Note: this MUST NOT be included in the created secure delegation, but only in the security metadata (as the map
	 * key).
	 */
	val secureDelegationKey: String,
	/**
	 * This stub is only applicable for the creation of secure delegations in entities of this type.
	 * Note: this MUST NOT be included in the created secure delegation nor in the security metadata.
	 */
	val applicableEntity: EntityWithEncryptionMetadataTypeName,
	/**
	 * The value to use for [SecureDelegation.delegator].
	 */
	val delegator: String? = null,
	/**
	 * The value to use for [SecureDelegation.delegate].
	 */
	val delegate: String? = null,
	/**
	 * The value to use for [SecureDelegation.exchangeDataId].
	 */
	val exchangeDataId: String? = null,
	/**
	 * The value to use for [SecureDelegation.permissions].
	 */
	val permissions: AccessLevel,
	/**
	 * The value to use for [SecureDelegation.parentDelegations].
	 */
	val parentDelegations: Set<Sha256HexString>
)