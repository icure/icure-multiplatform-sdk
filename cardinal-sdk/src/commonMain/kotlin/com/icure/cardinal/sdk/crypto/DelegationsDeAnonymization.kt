package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.utils.InternalIcureApi

/**
 * Allows data owners that have been granted access to an entity to identify the anonymous data owners with access to it.
 */
@InternalIcureApi
interface DelegationsDeAnonymization : EntityAccessInformationProvider {

	/**
	 * Creates / updates information to allow the data owners in [shareWithDataOwners] to de-anonymize the
	 * delegations contained within [entity].
	 * Note that the delegation de-anonymization information may be used also with other entities of the same type.
	 */
	suspend fun createOrUpdateDeAnonymizationInfo(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		shareWithDataOwners: Set<EntityReferenceInGroup>
	)
}