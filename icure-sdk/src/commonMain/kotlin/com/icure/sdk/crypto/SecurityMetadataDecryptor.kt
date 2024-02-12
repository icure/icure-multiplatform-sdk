package com.icure.sdk.crypto

import com.icure.sdk.model.AccessControlSecret
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.HexString
import com.icure.sdk.model.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.coroutines.flow.Flow

/**
 * Contains decrypted metadata and the data owners which have access to it.
 */
@InternalIcureApi
data class DecryptedMetadataDetails<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val value: T,
	/**
	 * The ids of data owners know to have access to [value]
	 */
	val dataOwnersWithAccess: List<String>
)

/**
 * Logic for the decryption of the metadata used for access control, encryption, and other security features in an entity.
 */
@InternalIcureApi
interface SecurityMetadataDecryptor {
	/**
	 * Decrypt the encryption keys for an entity. Keys must be returned in raw hex format, removing dashes if they were generated from a UUID.
	 * @param typedEntity an encrypted entity or its stub.
	 * @param dataOwnersHierarchySubset only exchange data that is accessible to data owners in this array will be considered when decrypting. It should
	 * contain only data owners from the current data owner hierarchy.
	 * @throws IllegalArgumentException if dataOwnersHierarchySubset is empty
	 * @return a flow containing the decrypted exchange keys. Note that the values may not be repeated (for example if the
	 * same metadata was shared by multiple users to the one of the provided data owners).
	 */
	fun decryptEncryptionKeysOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<HexString>>

	/**
	 * Decrypt the secret ids for an entity.
	 * @param typedEntity an encrypted entity or its stub.
	 * @param dataOwnersHierarchySubset only exchange data that is accessible to data owners in this array will be considered when decrypting. It should
	 * contain only data owners from the current data owner hierarchy.
	 * @throws IllegalArgumentException if dataOwnersHierarchySubset is empty
	 * @return a flow containing the decrypted secret ids. Note that the values may not be repeated (for example if the
	 * same metadata was shared by multiple users to the one of the provided data owners).
	 */
	fun decryptSecretIdsOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<String>>

	/**
	 * Decrypt the owning entity ids of an entity.
	 * @param typedEntity an encrypted entity or its stub.
	 * @param dataOwnersHierarchySubset only exchange data that is accessible to data owners in this array will be considered when decrypting. It should
	 * contain only data owners from the current data owner hierarchy.
	 * @throws IllegalArgumentException if dataOwnersHierarchySubset is empty
	 * @return a flow containing the decrypted owning entity ids. Note that the values may not be repeated (for example if the
	 * same metadata was shared by multiple users to the one of the provided data owners).
	 */
	fun decryptOwningEntityIdsOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<String>>

	/**
	 * Get the maximum access level that any data owner in {@link dataOwnersHierarchySubset} has to {@link typedEntity}, according to the metadata
	 * supported by this decryptor.
	 * - If at least a data owner in {@link dataOwnersHierarchySubset} has write access the method returns {@link AccessLevel.WRITE}.
	 * - If at least a data owner in {@link dataOwnersHierarchySubset} has read access and no data owner has write access the method returns
	 * {@link AccessLevel.READ}.
	 * - If a data owner has no access to the entity the method returns undefined (this can happen if the data owner has access to an entity through
	 * some metadata which is not supported by this decryptor).
	 * @param typedEntity an entity
	 * @param dataOwnersHierarchySubset only exchange data that is accessible to data owners in this array will be considered when calculating the
	 * access level. This array should contain only data owners from the current data owner hierarchy.
	 * @return the access level to the entity or undefined if none of the data owners has full access to the entity.
	 */
	suspend fun getEntityAccessLevel(typedEntity: Encryptable, dataOwnersHierarchySubset: List<String>): AccessLevel?

	/**
	 * Verifies if there is at least one (encrypted) encryption key in the metadata supported by this decryptor, even if it can't be decrypted by the
	 * current data owner.
	 */
	fun hasAnyEncryptionKeys(entity: Encryptable): Boolean
}


@InternalIcureApi
data class SecureDelegationMembersDetails(
	/**
	 * Delegator of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegator: String?,
	/**
	 * Delegate of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegate: String?,
	/**
	 * If the delegation was fully explicit.
	 */
	val fullyExplicit: Boolean,
	/**
	 * Access control secret associated to the exchange data used for the secure delegation, if known and if the
	 * delegation was not fully explicit.
	 */
	val accessControlSecret: AccessControlSecret?,
	/**
	 * Access level granted by the delegation.
	 */
	val accessLevel: AccessLevel,
)

@InternalIcureApi
interface SecureDelegationsDecryptor : SecurityMetadataDecryptor {
	/**
	 * Get information for members of secure delegations in the entity. Also provides information for delegations with anonymous delegate and/or
	 * delegator if one of the delegation members is the current data owner (or a parent) AND can still access the exchange data used for that
	 * secure delegation.
	 */
	suspend fun getDelegationMemberDetails(entity: Encryptable): Map<SecureDelegationKeyString, SecureDelegationMembersDetails>
}