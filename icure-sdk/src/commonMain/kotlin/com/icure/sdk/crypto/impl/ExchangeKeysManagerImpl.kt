package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BaseExchangeKeysManager
import com.icure.sdk.crypto.ExchangeKeysManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.LruCacheWithAsyncRetrieve
import com.icure.sdk.utils.currentEpochMs

@InternalIcureApi
class ExchangeKeysManagerImpl(
	private val dataOwnerApi: DataOwnerApi,
	private val baseExchangeKeysManager: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager
) : ExchangeKeysManager {
	companion object {
		private const val DEFAULT_CACHE_SIZE = 500
	}

	// (delegator, delegate) -> (retrievialTime, keys)
	private val cache = LruCacheWithAsyncRetrieve<Pair<String, String>, List<AesKey>>(DEFAULT_CACHE_SIZE)

	override suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey> {
		if (delegatorId == dataOwnerApi.getCurrentDataOwnerId() || delegateId in dataOwnerApi.getCurrentDataOwnerHierarchyIds()) {
			return cache.getCachedOrRetrieve(delegatorId to delegateId) {
				val encryptedKeys = baseExchangeKeysManager.getEncryptedExchangeKeysFor(delegatorId, delegateId)
				baseExchangeKeysManager.tryDecryptExchangeKeys(encryptedKeys, userKeysManager.getDecryptionKeys()).successfulDecryptions
			}
		} else throw InternalIcureException(
			"Delegator $delegatorId is not the current data owner and delegate $delegateId is not part of the current data owner hierarchy: can't get exchange key"
		)
	}

	override suspend fun clearCache(includeKeysFromCurrentDataOwner: Boolean) {
		cache.clear()
	}
}