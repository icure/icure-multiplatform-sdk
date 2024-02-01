package com.icure.sdk.crypto

import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.Encryptable
import com.icure.sdk.utils.InternalIcureApi

/**
 * Details on data owners with access to an entity
 */
data class EntityAccessInformation(
	/**
	 * The data owners with access to the entity, and how
	 */
	val permissionsByDataOwnerId: Map<String, AccessLevel>,
	/**
	 * Whether the entity has been shared with anonymous data owner who could not be identified by the current data
	 * owner.
	 */
	val hasUnknownAnonymousDataOwners: Boolean
)

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
	suspend fun createOrUpdateDeAnonymizationInfo(entity: Encryptable, shareWithDataOwners: List<String>)

	/**
	 * Get the data owners which can access the entity. See {@link EncryptedEntityXApi.getDataOwnersWithAccessTo} for more details.
	 * @param entityWithType an entity.
	 */
	suspend fun getDataOwnersWithAccessTo(entityWithType: Encryptable): EntityAccessInformation
}