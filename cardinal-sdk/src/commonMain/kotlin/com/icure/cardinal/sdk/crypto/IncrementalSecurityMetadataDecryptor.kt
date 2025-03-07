package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface IncrementalSecurityMetadataDecryptor {
	/**
	 * Attempts to do the action providing "incrementally decrypted" keys as input; stops the first time the action
	 * completes successfully.
	 * The method tries to decrypt encryption keys for the entity "incrementally", trying first to decrypt keys that
	 * require less effort for decryption (e.g. using already cached exchange data or using exchange data for which the
	 * id is known without going through the exchange data map). Each time one or more new keys are decrypted the action
	 * is called providing ALL keys decrypted up to that point.
	 * If no key can be decrypted at all the method returns null without ever attempting the action (the action always
	 * receives at least a key in input or is not called).
	 * @param entity the entity from which to decrypt the encryption keys.
	 * @param entityType the type of entity
	 * @param action the action that consumes the encryption key. Note: if null is returned the action is considered
	 * unsuccessful. If null would be a valid success value T needs to be a wrapper around the actual result.
	 * @return the wrapped result of the first successful action invocation, or null if the action never succeeded or if
	 * no key could be decrypted
	 */
	suspend fun <E : HasEncryptionMetadata, T : Any> doIncrementallyDecryptingKeys(
		entityGroupId: String?,
		entity: E,
		entityType: EntityWithEncryptionMetadataTypeName,
		action: suspend (
			entity: E,
			entityType: EntityWithEncryptionMetadataTypeName,
			keys: List<EntityEncryptionKeyDetails>
		) -> T?
	): T?

	/**
	 * Bulk version of [doIncrementallyDecryptingKeys].
	 * Differences:
	 * - The action is called until it succeeds for all entities or until all decryptable keys have been tried.
	 * - For each input the action must return an entry for that entity id with the result if successful or not include
	 *   the entity id in the result keys if unsuccessful.
	 * - An attempt on the action is done only if new keys could be decrypted for all the entities.
	 *   Additionally, there will be a final attempt after attempting all decryption steps if at least a new key could be
	 *   decrypted for an entity since the last attempt.
	 *   In this case entities for which no new key could be decrypted are omitted from the input.
	 * @param entities
	 * @param entitiesType
	 * @param action
	 * @return all entities id for which the action completed successfully associated to the result.
	 */
	suspend fun <E : HasEncryptionMetadata, T : Any> doManyIncrementallyDecryptingKeys(
		entitiesGroupId: String?,
		entities: List<E>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		action: suspend (
			entity: E,
			entityType: EntityWithEncryptionMetadataTypeName,
			keys: List<EntityEncryptionKeyDetails>
		) -> T?
	): Map<String, T>
}