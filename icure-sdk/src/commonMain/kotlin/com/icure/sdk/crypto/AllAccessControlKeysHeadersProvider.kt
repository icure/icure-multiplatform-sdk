package com.icure.sdk.crypto

import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface AllAccessControlKeysHeadersProvider {
	/**
	 * Provides the headers containing all access control keys for a given entity type that available to the current
	 * user (in the context of an authenticated iCure API).
	 * These headers can be used to prove the right to access some data protected by secure delegations as an
	 * anonymous data owner.
	 */
	suspend fun getAccessControlKeysHeaders(entityType: EntityWithDelegationTypeName): Pair<String, List<String>> // TODO ktorify headers
}
