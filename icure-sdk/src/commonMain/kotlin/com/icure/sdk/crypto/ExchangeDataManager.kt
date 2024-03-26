package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ResourceNotFoundException

/**
 * Exchange data manager which automatically handles decryption and cache
 */
@InternalIcureApi
interface ExchangeDataManager {
	/**
	 * Updates all exchange data between the current data owner and another data owner to allow the other data owner to access existing exchange data
	 * using a new public key.
	 * @param otherDataOwner the other data owner.
	 * @param newDataOwnerPublicKey a new public key of the other data owner. The key MUST BE VERIFIED.
	 */
	suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString)

	/**
	 * Gets any existing and verified exchange data from the current data owner to the provided delegate or creates new data if no verified data is
	 * available, then caches it.
	 * Data retrieved from this method is safe for encryption.
	 *
	 * @param delegateId the id of the delegate.
	 * @param allowCreationWithoutDelegateKey if true, when creating new exchange data, even if no verified key is available for the delegate the method
	 * will create the new exchange data anyway (will not be usable by the delegate without additional steps).
	 * @return the access control secret and key of the data to use for encryption.
	 */
	suspend fun getOrCreateEncryptionDataTo(
		delegateId: String,
		allowCreationWithoutDelegateKey: Boolean,
	): ExchangeDataWithUnencryptedContent

	/**
	 * Retrieve the cached decrypted exchange data key associated with any of the provided hashes/entry keys of secure delegations.
	 * Note: data retrieved from this method may be NOT SAFE FOR ENCRYPTION.
	 * @param hashes hashes of access control secrets for a specific entity, as they appear in the key of secure delegation entries
	 * @param entityType type of the entity containing the metadata for which you are retrieving the encryption key.
	 * @return the exchange data and decrypted key associated to that hash if cached
	 */
	suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Collection<SecureDelegationKeyString>,
		entityType: EntityWithEncryptionMetadataTypeName,
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent>

	/**
	 * Retrieves the exchange data with the provided id (from the cache if available or from the server otherwise if allowed by
	 * [retrieveIfNotCached]) and attempts to decrypt it, then caches the result.
	 * Note: data retrieved from this method may be NOT SAFE FOR ENCRYPTION.
	 * @param id id of the exchange data
	 * @param retrieveIfNotCached if false and there is no cached exchange data with the provided id the method returns undefined, else the method will
	 * attempt to load the exchange data from the server.
	 * @return null if the exchange data is not cached and [retrieveIfNotCached] is false. Else a pair wiht object containing:
	 * - exchangeData: the exchange data with the provided id
	 * - exchangeKey: the exchange key corresponding to the provided exchange data if it could be decrypted, else undefined
	 * @throws ResourceNotFoundException if no exchange data with the given id is cached and [retrieveIfNotCached] is
	 * true and the data could not be found in the server either.
	 */
	suspend fun getDecryptionDataById(
		id: String,
		retrieveIfNotCached: Boolean,
	): ExchangeDataWithPotentiallyDecryptedContent?

	/**
	 * Clears the cache or fully repopulates the cache if the current data owner can retrieve all of his exchange data according to the crypto
	 * strategies.
	 */
	suspend fun clearOrRepopulateCache()

	/**
	 * If the current data owner requires anonymous delegations this returns the base64 representation of the
	 * concatenation of all available access control keys for the current data owner.
	 * If the current data owner is explicit returns null.
	 */
	suspend fun getAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String>?
}
