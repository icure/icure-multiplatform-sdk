package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.utils.InternalIcureApi

/**
 * More powerful version of {@link BaseExchangeKeysManager} with a simplified interface. Has the following functionalities:
 * - Caches results
 * - Automatically creates new exchange keys if none is available
 * - Automatically choose the public keys to use during the creation of new exchange keys
 * - Automatically retrieves the private keys to use during decryption.
 */
@InternalIcureApi
interface ExchangeKeysManager {
	val base: BaseExchangeKeysManager

	/**
	 * Get all keys currently available for a delegator-delegate pair. At least one of the two data owners must be part of the hierarchy for the current
	 * data owner.
	 * @param delegatorId id of a delegator
	 * @param delegateId id of a delegate
	 * @throws IllegalArgumentException if neither the delegator nor the delegate is part of the hierarchy of the current data owner.
	 * @return all available exchange keys from the delegator-delegate pair.
	 */
	suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey>

	/**
	 * Empties the exchange keys cache.
	 * @param includeKeysFromCurrentDataOwner if true also clears the keys where the current data owner is the delegator,
	 * else only clears the keys where the current data owner is the delegate.
	 */
	suspend fun clearCache(includeKeysFromCurrentDataOwner: Boolean)
}