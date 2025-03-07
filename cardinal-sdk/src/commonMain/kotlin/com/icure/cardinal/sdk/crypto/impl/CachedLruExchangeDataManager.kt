package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.Either
import com.icure.cardinal.sdk.utils.LruCache
import com.icure.cardinal.sdk.utils.ResourceNotFoundException
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@InternalIcureApi
class CachedLruExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean,
	maxCacheSize: Int,
	sdkGroup: String?,
	requestGroup: String?,
	// TODO scope should be a subscope of main SDK scope, so it can be cancelled on reload of caches
	private val coroutineScope: CoroutineScope
) : AbstractExchangeDataManagerInGroup(
	base,
	userEncryptionKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	useParentKeys,
	requestGroup,
	sdkGroup
) {
	private val exchangeDataByIdCache: LruCache<String, Deferred<CachedExchangeDataDetails>> =
		LruCache(maxCacheSize)
	private val delegateToVerifiedExchangeDataId =
		mutableMapOf<String, Deferred<String>>()
	private val secureDelegationKeysToExchangeDataId =
		mutableMapOf<SecureDelegationKeyString, String>()
	private val cacheMutex = Mutex()
	/*
	 * If the cache mutex becomes a bottleneck we can try to instead have the cache read be free of lock, and the
	 * updates to used time be added to a queue that will be processed by a separate thread. This thread is also the
	 * only one that performs insertions.
	 */

	private fun doCacheDataMustHaveLock(
		toCache: CachedExchangeDataDetails
	) {

	}

	override suspend fun getOrCreateEncryptionDataTo(
		delegateReference: DataOwnerReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		// Using reference string as normalization
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(requestGroup, sdkGroup)
		val retrieved = cacheMutex.withLock {
			val verifiedExchangeDataId = delegateToVerifiedExchangeDataId[delegateReferenceString]
			if (verifiedExchangeDataId != null) {
				Pair(verifiedExchangeDataId, null)
			} else {
				val job = coroutineScope.async<Pair<String, ExchangeDataWithUnencryptedContent>> {
					val verifiedData = base.getExchangeDataByDelegatorDelegatePair(
						requestGroup,
						dataOwnerApi.getCurrentDataOwnerReference(),
						delegateReference
					).firstNotNullOfOrNull { exchangeData ->
						this@async.ensureActive()
						decryptData(exchangeData)?.takeIf {
							it.second
						}?.let {
							Pair(exchangeData, it)
						}
					} ?: createNewExchangeData(
						requestGroup,
						delegateReference,
						null,
						allowCreationWithoutDelegateKey
					).let {
						Pair(it.exchangeData, Pair(it.unencryptedContent, true))
					}
					cacheMutex.withLock {
						doCacheDataMustHaveLock(CachedExchangeDataDetails(verifiedData.first, verifiedData.second))
					}
					Pair(
						verifiedData.first.id ,
						ExchangeDataWithUnencryptedContent(
							verifiedData.first,
							verifiedData.second.first
						)
					)
				}
				delegateToVerifiedExchangeDataId[delegateReferenceString] = coroutineScope.async {
					job.await().first
				}
				Pair(null, job)
			}
		}
		return if (retrieved.first != null) {
			val id = retrieved.first!!.await()
			val cachedDetails = getOrRetrieveExchangeDataWithIds(listOf(id)).getValue(id)
			cachedDetails.decryptedContentAndVerificationStatus?.takeIf { it.second }?.let {
				ExchangeDataWithUnencryptedContent(
					cachedDetails.exchangeData,
					it.first
				)
			} ?: throw AssertionError("Exchange data with id $id should be decrypted and verified")
		} else {
			retrieved.second!!.await().second
		}
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> {
		val hashesToExchangeDataId = secureDelegationKeysToExchangeDataId.getMany(hashes)
		val exchangeData = getOrRetrieveExchangeDataWithIds(hashesToExchangeDataId.values.toList())
		return hashesToExchangeDataId.mapNotNull { (key, exchangeDataId) ->
			val correspondingData = exchangeData.getValue(exchangeDataId)
			correspondingData.decryptedContentAndVerificationStatus?.let {
				key to ExchangeDataWithUnencryptedContent(
					correspondingData.exchangeData,
					it.first
				)
			}
		}.toMap()
	}

	override suspend fun getDecryptionDataByIds(
		ids: Set<String>,
		retrieveIfNotCached: Boolean
	): ExchangeDataWithPotentiallyDecryptedContent? = (
		if (retrieveIfNotCached) {
			getOrRetrieveExchangeDataWithId(id)
		} else {
			exchangeDataByIdCache.getIfCached(id)
		}
	)?.let {
		ExchangeDataWithPotentiallyDecryptedContent(
			it.exchangeData,
			it.decryptedContentAndVerificationStatus?.first
		)
	}

	private suspend fun getOrRetrieveExchangeDataWithId(exchangeDataId: String): CachedExchangeDataDetails =
		exchangeDataByIdCache.getCachedOrRetrieve(exchangeDataId) {
			retrieveExchangeData(exchangeDataId)
		}.also {
			// Always cache secure delegation keys, regardless of whether it was retrieved by this or not to refresh usage.
			cacheSecureDelegationKeysFor(it)
		}

	private suspend fun getOrRetrieveExchangeDataWithIds(exchangeDataIds: List<String>): Map<String, CachedExchangeDataDetails> =
	// This takes and release lock of the cache many times... may want to try to make a "batch" version of getCachedOrRetrieve
		exchangeDataIds.associateWith { exchangeDataId -> getOrRetrieveExchangeDataWithId(exchangeDataId) }

	private suspend fun retrieveExchangeData(exchangeDataId: String): CachedExchangeDataDetails {
		val exchangeData = base.getExchangeDataById(exchangeDataId)
			?: throw ResourceNotFoundException(exchangeDataId, ExchangeData::class)
		return CachedExchangeDataDetails(
			exchangeData,
			decryptData(exchangeData)?.let {
				UnencryptedExchangeDataContent(
					exchangeKey = it.exchangeKey,
					accessControlSecret = it.accessControlSecret,
					sharedSignatureKey = it.sharedSignatureKey,
				) to it.verified
			}
		)
	}

	private suspend fun createAndCacheNewExchangeData(
		delegateReference: DataOwnerReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean
	): CachedExchangeDataDetails =
		createNewExchangeData(
			requestGroup,
			delegateReference,
			null,
			allowCreationWithoutDelegateKey
		).let {
			CachedExchangeDataDetails(
				it.exchangeData,
				it.unencryptedContent to true,
			)
		}.also {
			exchangeDataByIdCache.set(it.exchangeData.id, it)
			cacheSecureDelegationKeysFor(it)
		}

	private suspend fun cacheSecureDelegationKeysFor(cachedExchangeDataDetails: CachedExchangeDataDetails) {
		cachedExchangeDataDetails.decryptedContentAndVerificationStatus?.first?.accessControlSecret?.let { accessControlSecret ->
			val keys = accessControlSecret.allAccessControlKeys(cryptoService).map { it.toSecureDelegationKeyString(cryptoService) }
			secureDelegationKeysToExchangeDataId.setMany(keys.map { it to cachedExchangeDataDetails.exchangeData.id })
		}
	}

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String>? =
		null

	override suspend fun getAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<SecureDelegationKeyString>? =
		null
}
