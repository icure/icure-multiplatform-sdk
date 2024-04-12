package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.utils.InternalIcureApi

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
	suspend fun createOrUpdateDeAnonymizationInfo(entity: EntityWithTypeInfo<*>, shareWithDataOwners: Set<String>)
}