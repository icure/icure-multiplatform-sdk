package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.ExchangeDataMap
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface ExchangeDataMapManager {
	/**
	 * This function creates a batch of Exchange Data Map, ignoring the one that already exist and are already present in the cache.
	 * The ones that are not are created and their ids are cached.
	 * @param batch a map where each key is the hex-encoded access control key to another map that associates the encoded id of an
	 * Exchange Data entity to the fingerprint of the key used to encrypt it.
	 */
	suspend fun createExchangeDataMaps(batch: ExchangeDataMapCreationBatch): Unit

	/**
	 * Retrieves a batch of Exchange Data Maps.
	 * @param accessControlKeyHashes the hex-encoded hashes of the Exchange Data Maps to retrieve.
	 */
	suspend fun getExchangeDataMapBatch(accessControlKeyHashes: List<SecureDelegationKeyString>): List<ExchangeDataMap>
}