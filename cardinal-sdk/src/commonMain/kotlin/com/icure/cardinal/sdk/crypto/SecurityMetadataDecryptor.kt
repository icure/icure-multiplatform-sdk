package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.flow.Flow

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
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
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
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
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
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
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
	suspend fun getEntityAccessLevel(typedEntity: EntityWithTypeInfo<*>, dataOwnersHierarchySubset: Set<String>): AccessLevel?

	/**
	 * Verifies if there is at least one (encrypted) encryption key in the metadata supported by this decryptor, even if it can't be decrypted by the
	 * current data owner.
	 */
	fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean
}


