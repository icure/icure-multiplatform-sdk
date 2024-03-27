package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.utils.InternalIcureApi

/**
 * Allows data owners that have been granted access to an entity to identify the anonymous data owners with access to it.
 */
@InternalIcureApi
interface DelegationsDeAnonymization {

	/**
	 * Creates / updates information to allow the data owners in [shareWithDataOwners] to de-anonymize the
	 * delegations contained within [entity].
	 * Note that the delegation de-anonymization information may be used also with other entities of the same type.
	 */
	suspend fun createOrUpdateDeAnonymizationInfo(entity: HasEncryptionMetadata, shareWithDataOwners: List<String>)

	/**
	 * Get the data owners which can access the entity. See {@link EncryptedEntityXApi.getDataOwnersWithAccessTo} for more details.
	 * @param entityWithType an entity.
	 */
	suspend fun getDataOwnersWithAccessTo(entityWithType: HasEncryptionMetadata): EntityAccessInformation
}