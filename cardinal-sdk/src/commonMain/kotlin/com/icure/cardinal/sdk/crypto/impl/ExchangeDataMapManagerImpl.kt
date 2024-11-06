package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.cardinal.sdk.api.raw.RawExchangeDataMapApi
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.model.ExchangeDataMap
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.SynchronisedLruCache

@InternalIcureApi
class ExchangeDataMapManagerImpl(
	private val rawApi: RawExchangeDataMapApi,
	private val cryptoService: CryptoService
) : ExchangeDataMapManager {
	// We don't cache the map value because it is used only once and then cached in the exchange data manager.
	// We cache only the keys to prevent unnecessary requests when we know they are available.
	private val cache = SynchronisedLruCache<SecureDelegationKeyString, Unit>(1000)

	override suspend fun createExchangeDataMaps(batch: ExchangeDataMapCreationBatch) {
		if (batch.batch.isEmpty()) return
		val accessKeyToDelegationKey = batch.batch.keys.associateWith { it.toSecureDelegationKeyString(cryptoService) }
		val existing = cache.getMany(accessKeyToDelegationKey.values).keys
		val toCreate = ExchangeDataMapCreationBatch(batch.batch.filter { accessKeyToDelegationKey[it.key] !in existing })
		if (toCreate.batch.isNotEmpty()) {
			// Note that by now another coroutine could have started the creation of the same exchange data map, but it
			// is only wasted job, not really a big deal.
			// In future still we may want to try to improve this.
			rawApi.createOrUpdateExchangeDataMapBatch(toCreate).successBody()
			cache.setMany(toCreate.batch.keys.map { accessKeyToDelegationKey.getValue(it) to Unit })
		}
	}

	override suspend fun getExchangeDataMapBatch(
		accessControlKeyHashes: List<SecureDelegationKeyString>
	): List<ExchangeDataMap> =
		rawApi.getExchangeDataMapBatch(ListOfIds(accessControlKeyHashes.map { it.s })).successBody().also { retrieved ->
			cache.setMany(retrieved.map { SecureDelegationKeyString(it.id) to Unit })
		}
}