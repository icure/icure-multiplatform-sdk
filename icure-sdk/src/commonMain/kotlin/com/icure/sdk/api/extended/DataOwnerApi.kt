package com.icure.sdk.api.extended

import com.icure.sdk.api.raw.RawDataOwnerApi
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.extensions.publicKeysSpki
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.model.extensions.type
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.SingleValueAsyncCache

@OptIn(InternalIcureApi::class)
class DataOwnerApi(
	private val rawApi: RawDataOwnerApi,
) {
	private data class DataOwnerInfo(
		val hierarchy: List<String>,
		val type: DataOwnerType,
	)
	private val dataOwnerInfoCache: SingleValueAsyncCache<DataOwnerInfo, List<DataOwnerWithType>> = SingleValueAsyncCache()

	suspend fun getCurrentDataOwner(): DataOwnerWithType =
		rawApi.getCurrentDataOwner().successBody()

	suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType =
		getCurrentDataOwner().toStub()

	/**
	 * If the logged user is a data owner get the current data owner id. This information is cached without expiration,
	 * and will only be updated in case of forced refresh.
	 */
	suspend fun getCurrentDataOwnerId(): String =
		getOrCacheInfo().first.hierarchy.last()

	/**
	 * If the logged user is a data owner get its parent hierarchy. This information is cached without expiration, and will only be updated in case
	 * of forced refresh.
	 * The resulting array starts with the topmost parent (the only ancestor without a parent) and ends with the data owner itself.
	 */
	suspend fun getCurrentDataOwnerHierarchyIds(): List<String> =
		getOrCacheInfo().first.hierarchy

	suspend fun getDataOwner(ownerId: String): DataOwnerWithType =
		rawApi.getDataOwner(ownerId).successBody()

	suspend fun getDataOwnerStub(ownerId: String): CryptoActorStubWithType =
		rawApi.getDataOwnerStub(ownerId).successBody()

	/**
	 * Get the hierarchy for the current data owner starting from the specified parent.
	 * @return an array starting at the topmost parent and ending at the provided parent id.
	 * @throws IllegalArgumentException If the provided id is not part of the hierarchy
	 */
	suspend fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): List<String> {
		getCurrentDataOwnerHierarchyIds()
			.indexOfFirst { it == parentId }
			.takeIf { it >= 0 }
			?.let { return getCurrentDataOwnerHierarchyIds().subList(0, it + 1) }
			?: throw IllegalArgumentException("$parentId is not part of the current data owner hierarchy")
	}

	/**
	 * If the logged user is a data owner get the current data owner and all of his parents.
	 * @return the current data owner hierarchy, starting from the topmost parent to the current data owner.
	 */
	suspend fun getCurrentDataOwnerHierarchy(): List<DataOwnerWithType> =
		getOrCacheInfo().let { (cachedInfo, retrievedHierarchy) ->
			// TODO bulk get hierarchy
			retrievedHierarchy ?: cachedInfo.hierarchy.map { getDataOwner(it) }
		}

	suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType =
		rawApi.modifyDataOwnerStub(cryptoActorStubWithTypeDto).successBody()

	/**
	 * If the logged user is a data owner get the type of the current data owner. This information is cached.
	 */
	suspend fun getCurrentDataOwnerType(): DataOwnerType =
		getOrCacheInfo().first.type

	/**
	 * Get a crypto actor stub for a data owner.
	 * @param ownerId id of the data owner for which you want to retrieve the stub (patient, medical device, hcp, ...)
	 * @return the crypto actor stub of the data owner with the provided id
	 */
	suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType =
		rawApi.getDataOwnerStub(ownerId).successBody()

	/**
	 * Clears the cache of current data owner id and parent hierarchy ids. The hierarchy of a data owner should not
	 * normally change over time, so this method should be rarely needed.
	 */
	fun clearCurrentDataOwnerIdsCache() {
		dataOwnerInfoCache.deleteCache()
	}

	private val DataOwnerWithType.parentId: String? get() = (dataOwner as? HealthcareParty)?.parentId

	// Left will always be available, taken from the cache or cached; second will be available only if the caller is
	// the user actually filling the cache.
	private suspend fun getOrCacheInfo(): Pair<DataOwnerInfo, List<DataOwnerWithType>?> =
		dataOwnerInfoCache.getCachedOrRetrieve {
			// TODO method to get full hierarchy in one call to server.
			var curr = getCurrentDataOwner()
			val type = curr.type
			checkDataOwnerIntegrity(curr.dataOwner)
			val res = mutableListOf(curr)
			while (!curr.parentId.isNullOrEmpty()) {
				curr = getDataOwner(curr.parentId!!)
				res.add(curr)
			}
			res.reversed().let { hierarchy ->
				DataOwnerInfo(hierarchy.map { it.dataOwner.id }, type) to hierarchy
			}
		}

	private fun checkDataOwnerIntegrity(dataOwner: CryptoActor) {
		val keys = dataOwner.publicKeysSpki
		if (keys.distinct().size != keys.size) throw IllegalEntityException(
			"Different public keys for ${dataOwner.id} have the same fingerprint; this should not happen in normal circumstances. Please report this error to iCure."
		)
	}
}