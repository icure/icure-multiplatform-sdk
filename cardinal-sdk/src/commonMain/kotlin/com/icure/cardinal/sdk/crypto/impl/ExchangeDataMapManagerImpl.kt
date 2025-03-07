package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.raw.RawExchangeDataMapApi
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.model.ExchangeDataMap
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.SynchronisedLruCache
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class ExchangeDataMapManagerImpl(
	private val rawApi: RawExchangeDataMapApi,
	private val cryptoService: CryptoService,
	private val boundGroupId: String?
) : ExchangeDataMapManager {
	// We don't cache the map value because it is used only once and then cached in the exchange data manager.
	// We cache only the keys to prevent unnecessary create requests when we know they're available.
	private val cache = SynchronisedLruCache<Pair<String?, SecureDelegationKeyString>, Unit>(1000)

	override suspend fun createExchangeDataMaps(
		groupId: String?,
		batch: ExchangeDataMapCreationBatch
	) {
		if (batch.batch.isEmpty()) return
		val requestGroup = mapGroupIdWithBoundGroupId(groupId = groupId, boundGroupId = boundGroupId)
		val accessKeyToDelegationKey = batch.batch.keys.associateWith {
			Pair(requestGroup, it.toSecureDelegationKeyString(cryptoService))
		}
		val existing = cache.getMany(accessKeyToDelegationKey.values).keys
		val toCreate = ExchangeDataMapCreationBatch(batch.batch.filter { accessKeyToDelegationKey[it.key] !in existing })
		if (toCreate.batch.isNotEmpty()) {
			// Note that by now another coroutine could have started the creation of the same exchange data map, but it
			// is only wasted job, not really a big deal.
			// In future still we may want to try to improve this.
			(
				if (requestGroup == null)
					rawApi.createOrUpdateExchangeDataMapBatch(toCreate)
				else
					rawApi.createOrUpdateExchangeDataMapBatch(toCreate, requestGroup)
			).successBody()
			cache.setMany(toCreate.batch.keys.map { accessKeyToDelegationKey.getValue(it) to Unit })
		}
	}

	override suspend fun getExchangeDataMapBatch(
		groupId: String?,
		accessControlKeyHashes: Set<SecureDelegationKeyString>
	): List<ExchangeDataMap> {
		val requestGroup = mapGroupIdWithBoundGroupId(groupId = groupId, boundGroupId = boundGroupId)
		val toGet = ListOfIds(accessControlKeyHashes.map { it.s })
		return (
			if (requestGroup == null)
				rawApi.getExchangeDataMapBatch(toGet)
			else
				rawApi.getExchangeDataMapBatch(toGet, requestGroup)
		).successBody()/*.also { retrieved ->
			cache.setMany(retrieved.map { Pair(requestGroup, SecureDelegationKeyString(it.id)) to Unit })
		}*/
		/*
		 * It is probably more interesting to keep update the cache only on creation, because the cache is used only
		 * when sharing data with an anonymous data owner.
		 * Since a user will generally share data to few users, but could get data shared from many different users, we
		 * risk evicting the keys actually interesting to the user if we keep filling also on retrieve.
		 */
	}
}