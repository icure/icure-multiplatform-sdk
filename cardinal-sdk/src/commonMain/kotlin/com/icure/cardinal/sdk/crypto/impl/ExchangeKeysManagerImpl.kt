package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.LruCacheWithAsyncRetrieve

@InternalIcureApi
class ExchangeKeysManagerImpl(
	private val dataOwnerApi: DataOwnerApi,
	override val base: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager
) : ExchangeKeysManager {
	companion object {
		private const val DEFAULT_CACHE_SIZE = 500
	}

	// (delegator, delegate) -> (retrievialTime, keys)
	private val cache = LruCacheWithAsyncRetrieve<Pair<String, String>, List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>(DEFAULT_CACHE_SIZE)

	override suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>> {
		if (delegatorId == dataOwnerApi.getCurrentDataOwnerId() || delegateId in dataOwnerApi.getCurrentDataOwnerHierarchyIds()) {
			return cache.getCachedOrRetrieve(delegatorId to delegateId) {
				val encryptedKeys = base.getEncryptedExchangeKeysFor(delegatorId, delegateId)
				base.tryDecryptExchangeKeys(encryptedKeys, userKeysManager.getDecryptionKeys()).successfulDecryptions
			}
		} else throw InternalCardinalException(
			"Delegator $delegatorId is not the current data owner and delegate $delegateId is not part of the current data owner hierarchy: can't get exchange key"
		)
	}

	override suspend fun clearCache(includeKeysFromCurrentDataOwner: Boolean) {
		cache.clear()
	}
}