package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.UndecryptableExchangeData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.encodeAsAccessControlHeaders
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.job
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.Volatile

@InternalIcureApi
class FullyCachedExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean,
	sdkScope: CoroutineScope,
	sdkGroup: String?
) : AbstractExchangeDataManager(
	base,
	userEncryptionKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	useParentKeys,
	sdkScope,
	sdkGroup
) {
	override fun createManagerForGroup(groupId: String?): AbstractExchangeDataManagerInGroup =
		FullyCachedExchangeDataManagerInGroup(
			base = base,
			userEncryptionKeys = userEncryptionKeys,
			cryptoStrategies = cryptoStrategies,
			dataOwnerApi = dataOwnerApi,
			cryptoService = cryptoService,
			useParentKeys = useParentKeys,
			sdkGroup = sdkGroup,
			sdkScope = sdkScope,
			requestGroup = groupId
		)
}

@InternalIcureApi
private class FullyCachedExchangeDataManagerInGroup(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean,
	sdkGroup: String?,
	sdkScope: CoroutineScope,
	requestGroup: String?
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
	private class Caches(
		val dataById: Map<String, CachedExchangeDataDetails>,
		val dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		val verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
		val entityTypeToAccessControlKeysValue: Map<EntityWithEncryptionMetadataTypeName, Pair<List<Base64String>, List<SecureDelegationKeyString>>>
	) {
		fun getEncryptionDataTo(delegateReferenceString: String): ExchangeDataWithUnencryptedContent? =
			verifiedDataByDelegateId[delegateReferenceString]?.let { data ->
				ExchangeDataWithUnencryptedContent(
					data.exchangeData,
					ensureNonNull(data.decryptedDetails) {
						"Decrypted details of cached verified data can't be null"
					}.decryptedContent
				)
			}
	}
	private val cacheUpdateAndNewDataCreationScope = CoroutineScope(Dispatchers.Default + SupervisorJob(sdkScope.coroutineContext.job))
	@Volatile
	private var caches: Deferred<Caches> = cacheUpdateAndNewDataCreationScope.async { getAllKeysInfo() }
	private val creationJobs = mutableMapOf<String, Deferred<ExchangeDataWithUnencryptedContent>>()
	private val creationMutex = Mutex()

	override suspend fun getOrCreateEncryptionDataTo(
		delegateReference: DataOwnerReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(requestGroup, sdkGroup)
		val triedCaches = caches
		return triedCaches.await().getEncryptionDataTo(delegateReferenceString) ?: creationMutex.withLock {
			creationJobs.getOrPut(delegateReferenceString) {
				cacheUpdateAndNewDataCreationScope.async {
					// If unlucky, it could be possible that the caches have been updated between the time we tried and
					// the time we got the lock. In case they changed we need to try again.
					caches.takeIf { it !== triedCaches }?.await()?.getEncryptionDataTo(delegateReferenceString)
						?: doCreateAndCacheEncryptionDataTo(delegateReference, delegateReferenceString)
				}
			}
		}.await()
	}

	private suspend fun doCreateAndCacheEncryptionDataTo(
		delegateReference: DataOwnerReferenceInGroup,
		delegateReferenceString: String
	): ExchangeDataWithUnencryptedContent = createNewExchangeData(
		delegateReference,
		null,
		false
	).also { created ->
		creationMutex.withLock {
			val prevCaches = caches
			caches = cacheUpdateAndNewDataCreationScope.async {
				val awaitedPrevCaches = prevCaches.await()
				val secureDelegationKeys = created.unencryptedContent.accessControlSecret
					.allAccessControlKeys(cryptoService)
					.mapTo(mutableSetOf()) { it.toSecureDelegationKeyString(cryptoService) }
				val cachedDetails = CachedExchangeDataDetails(
					created.exchangeData,
					CachedDecryptedDetails(
						created.unencryptedContent,
						true,
						secureDelegationKeys
					)
				)
				cachesFrom(
					dataById = awaitedPrevCaches.dataById + (created.exchangeData.id to cachedDetails),
					verifiedDataByDelegateId = awaitedPrevCaches.verifiedDataByDelegateId + (delegateReferenceString to cachedDetails),
					dataByDelegationKey = awaitedPrevCaches.dataByDelegationKey + secureDelegationKeys.associateWith { cachedDetails }
				)
			}
			@Suppress("DeferredResultUnused")
			creationJobs.remove(delegateReferenceString)
		}
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> =
		caches.await().let {
			hashes.mapNotNull { hash ->
				it.dataByDelegationKey[hash]?.let { data ->
					hash to ExchangeDataWithUnencryptedContent(
						data.exchangeData,
						ensureNonNull(data.decryptedDetails) {
							"Decrypted details of data cached by hash can't be null"
						}.decryptedContent
					)
				}
			}.toMap()
		}

	override suspend fun getDecryptionDataByIds(
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> =
		caches.await().let {
			ids.mapNotNull { id ->
				it.dataById[id]?.let { data ->
					if (data.decryptedDetails != null) {
						id to ExchangeDataWithUnencryptedContent(
							data.exchangeData,
							data.decryptedDetails.decryptedContent
						)
					} else {
						id to UndecryptableExchangeData(data.exchangeData)
					}
				}
			}.toMap()
		}

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String> =
		caches.await().entityTypeToAccessControlKeysValue.getValue(entityType).first

	override suspend fun getAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<SecureDelegationKeyString> =
		caches.await().entityTypeToAccessControlKeysValue.getValue(entityType).second

	override fun dispose() {
		cacheUpdateAndNewDataCreationScope.cancel()
	}

//	override suspend fun getOrCreateEncryptionDataTo(
//		delegateId: String,
//		allowCreationWithoutDelegateKey: Boolean
//	): ExchangeDataWithUnencryptedContent =
//		cache.update { existingCache ->
//			ensureNonNull(existingCache) {
//				"Cache for fully cached exchange data manager can't be null"
//			}
//			val updatedInfo = kotlin.runCatching {
//				if (existingCache.verifiedDataByDelegateId[delegateId] != null) {
//					existingCache
//				} else {
//					val createdData = super.createNewExchangeData(
//						delegateId,
//						null,
//						allowCreationWithoutDelegateKey
//					)
//					val cachedDetails = CachedExchangeDataDetails(
//						createdData.exchangeData,
//						Pair(createdData.unencryptedContent, true)
//					)
//					val secureDelegationKeysToExchangeDataId =
//						createdData.unencryptedContent.accessControlSecret.allAccessControlKeys(cryptoService)
//							.map { it.toSecureDelegationKeyString(cryptoService) to cachedDetails }
//					val allAccessControlSecrets = existingCache.dataById.values.mapNotNull { it.decryptedContentAndVerificationStatus?.first?.accessControlSecret } + createdData.unencryptedContent.accessControlSecret
//					CachedKeys(
//						dataById = existingCache.dataById + (createdData.exchangeData.id to cachedDetails),
//						verifiedDataByDelegateId = existingCache.verifiedDataByDelegateId + (delegateId to cachedDetails),
//						dataByDelegationKey = existingCache.dataByDelegationKey + secureDelegationKeysToExchangeDataId,
//						entityTypeToAccessControlKeysValue = EntityWithEncryptionMetadataTypeName.entries.associateWith {
//							allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) }.encodeAsAccessControlHeaders() to
//								allAccessControlSecrets.map { s -> s.toSecureDelegationKeyFor(it, cryptoService) }
//						}
//					)
//				}
//			}
//			if (updatedInfo.isSuccess) {
//				updatedInfo.getOrThrow() to CacheUpdateResult.Success
//			} else {
//				existingCache to CacheUpdateResult.Failure(updatedInfo.exceptionOrNull()!!)
//			}
//		}.let { (cached, result) ->
//			if (result is CacheUpdateResult.Failure) {
//				throw result.error
//			} else {
//				val cachedData = ensureNonNull(cached.verifiedDataByDelegateId[delegateId]) {
//					"Data for delegate $delegateId should have been created and added to the cache"
//				}
//				val decryptedContent = ensureNonNull(cachedData.decryptedContentAndVerificationStatus) {
//					"New data for delegate $delegateId should have been decrypted"
//				}.also {
//					ensure(it.second) { "New data for delegate $delegateId should have been verified" }
//				}
//				ExchangeDataWithUnencryptedContent(cachedData.exchangeData, decryptedContent.first)
//			}
//		}


	private suspend fun getAllKeysInfo(): Caches {
		val cacheById = mutableMapOf<String, CachedExchangeDataDetails>()
		val cacheByHash = mutableMapOf<SecureDelegationKeyString, CachedExchangeDataDetails>()
		val cacheByDelegateId = mutableMapOf<String, CachedExchangeDataDetails>()
		ensureNonNull(base.getAllExchangeDataForCurrentDataOwnerIfAllowed()) {
			"Could not get all exchange data of current data owner"
		}.forEach { exchangeData ->
			val decryptedInfo = decryptData(exchangeData)
			if (decryptedInfo != null) {
				val secureDelegationKeys = decryptedInfo.first.accessControlSecret
					.allAccessControlKeys(cryptoService)
					.mapTo(mutableSetOf()) { it.toSecureDelegationKeyString(cryptoService) }
				val cachedDetails = CachedExchangeDataDetails(
					exchangeData,
					CachedDecryptedDetails(
						decryptedInfo.first,
						decryptedInfo.second,
						secureDelegationKeys
					)
				)
				cacheById[exchangeData.id] = cachedDetails
				secureDelegationKeys.forEach {
					cacheByHash[it] = cachedDetails
				}
				if (decryptedInfo.second) {
					cacheByDelegateId[exchangeData.delegate] = cachedDetails
				}
			} else {
				cacheById[exchangeData.id] = CachedExchangeDataDetails(exchangeData, null)
			}
		}
		return cachesFrom(cacheById, cacheByHash, cacheByDelegateId)
	}

	private suspend fun cachesFrom(
		dataById: Map<String, CachedExchangeDataDetails>,
		dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
	) = Caches(
		dataById,
		dataByDelegationKey,
		verifiedDataByDelegateId,
		dataById.values.mapNotNull { it.decryptedDetails?.decryptedContent?.accessControlSecret }.let { allAccessControlSecrets ->
			EntityWithEncryptionMetadataTypeName.entries.associateWith {
				allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) }.encodeAsAccessControlHeaders() to
					allAccessControlSecrets.map { s -> s.toSecureDelegationKeyFor(it, cryptoService) }
			}
		}
	)
}
