package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensureNonNull

@InternalIcureApi
class AccessControlKeysHeadersProviderImpl(
	private val exchangeDataManager: ExchangeDataManager
): AccessControlKeysHeadersProvider {
	override suspend fun getAccessControlKeysHeadersFor(entityType: EntityWithDelegationTypeName): List<String> =
		ensureNonNull(exchangeDataManager.getAccessControlKeysValue(entityType)) {
			"Exchange data manager does not allow for retrieval of access control keys"
		}.map { it.s }
}