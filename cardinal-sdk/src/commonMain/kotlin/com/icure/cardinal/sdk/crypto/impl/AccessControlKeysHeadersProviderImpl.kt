package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.ensureNonNull

@InternalIcureApi
class AccessControlKeysHeadersProviderImpl(
	private val exchangeDataManager: ExchangeDataManager
): AccessControlKeysHeadersProvider {
	override suspend fun getAccessControlKeysHeadersFor(entityType: EntityWithEncryptionMetadataTypeName): List<String> =
		ensureNonNull(exchangeDataManager.getEncodedAccessControlKeysValue(entityType)) {
			"Exchange data manager does not allow for retrieval of access control keys"
		}.map { it.s }
}
