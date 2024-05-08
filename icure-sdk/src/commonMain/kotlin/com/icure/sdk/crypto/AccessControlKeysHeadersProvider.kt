package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface AccessControlKeysHeadersProvider {
	/**
	 * Provides the headers containing all access control keys for a given entity type that available to the current
	 * user (in the context of an authenticated iCure API).
	 * These headers can be used to prove the right to access some data protected by secure delegations as an
	 * anonymous data owner.
	 * @return the values for an header containing access control keys for the given entity type. Note that these values
	 * should not be concatenated into a single header entry, and instead the header should be repeated for each entry.
	 */
	suspend fun getAccessControlKeysHeadersFor(entityType: EntityWithEncryptionMetadataTypeName): List<String>
}
