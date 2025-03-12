package com.icure.cardinal.sdk.crypto

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi

/**
 * Provides access to exchange keys. Caches everything.
 */
@InternalIcureApi
interface ExchangeKeysManager {
	val base: BaseExchangeKeysManager

	/**
	 * Get all keys currently available for a delegator-delegate pair.
	 * At least one of the two data owners must be part of the hierarchy for the current data owner.
	 * Suspends if the cache didn't yet finish loading.
	 * @param delegatorId id of a delegator
	 * @param delegateId id of a delegate
	 * @throws IllegalArgumentException if neither the delegator nor the delegate is part of the hierarchy of the current data owner.
	 * @return all available exchange keys from the delegator-delegate pair.
	 */
	suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>

	/**
	 * Empties the exchange keys cache.
	 */
	fun requestCacheReload()
}