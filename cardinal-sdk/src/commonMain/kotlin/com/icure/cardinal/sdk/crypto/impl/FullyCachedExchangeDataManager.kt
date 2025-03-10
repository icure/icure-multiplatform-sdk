package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.model.specializations.AccessControlSecret
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.encodeAsAccessControlHeaders
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.SingleValueAsyncCache
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class FullyCachedExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean
) : AbstractExchangeDataManager(
	base,
	userEncryptionKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	useParentKeys
) {
	private data class CachedKeys(
		val dataById: Map<String, CachedExchangeDataDetails>,
		val dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		val verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
		val entityTypeToAccessControlKeysValue: Map<EntityWithEncryptionMetadataTypeName, Pair<List<Base64String>, List<SecureDelegationKeyString>>>
	)
	private sealed interface CacheUpdateResult {
		data object Success : CacheUpdateResult
		data class Failure(val error: Throwable) : CacheUpdateResult
	}
	private val cache = SingleValueAsyncCache<CachedKeys, CacheUpdateResult>()

	override suspend fun getOrCreateEncryptionDataTo(
		delegateId: String,
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent =
		cache.update { existingCache ->
			ensureNonNull(existingCache) {
				"Cache for fully cached exchange data manager can't be null"
			}
			val updatedInfo = kotlin.runCatching {
				if (existingCache.verifiedDataByDelegateId[delegateId] != null) {
					existingCache
				} else {
					val createdData = super.createNewExchangeData(
						delegateId,
						null,
						allowCreationWithoutDelegateKey
					)
					val cachedDetails = CachedExchangeDataDetails(
						createdData.exchangeData,
						Pair(createdData.unencryptedContent, true)
					)
					val secureDelegationKeysToExchangeDataId =
						createdData.unencryptedContent.accessControlSecret.allAccessControlKeys(cryptoService)
							.map { it.toSecureDelegationKeyString(cryptoService) to cachedDetails }
					val allAccessControlSecrets = existingCache.dataById.values.mapNotNull { it.decryptedContentAndVerificationStatus?.first?.accessControlSecret } + createdData.unencryptedContent.accessControlSecret
					CachedKeys(
						dataById = existingCache.dataById + (createdData.exchangeData.id to cachedDetails),
						verifiedDataByDelegateId = existingCache.verifiedDataByDelegateId + (delegateId to cachedDetails),
						dataByDelegationKey = existingCache.dataByDelegationKey + secureDelegationKeysToExchangeDataId,
						entityTypeToAccessControlKeysValue = EntityWithEncryptionMetadataTypeName.entries.associateWith {
							allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) }.encodeAsAccessControlHeaders() to
								allAccessControlSecrets.map { s -> s.toSecureDelegationKeyFor(it, cryptoService) }
						}
					)
				}
			}
			if (updatedInfo.isSuccess) {
				updatedInfo.getOrThrow() to CacheUpdateResult.Success
			} else {
				existingCache to CacheUpdateResult.Failure(updatedInfo.exceptionOrNull()!!)
			}
		}.let { (cached, result) ->
			if (result is CacheUpdateResult.Failure) {
				throw result.error
			} else {
				val cachedData = ensureNonNull(cached.verifiedDataByDelegateId[delegateId]) {
					"Data for delegate $delegateId should have been created and added to the cache"
				}
				val decryptedContent = ensureNonNull(cachedData.decryptedContentAndVerificationStatus) {
					"New data for delegate $delegateId should have been decrypted"
				}.also {
					ensure(it.second) { "New data for delegate $delegateId should have been verified" }
				}
				ExchangeDataWithUnencryptedContent(cachedData.exchangeData, decryptedContent.first)
			}
		}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Collection<SecureDelegationKeyString>,
		entityType: EntityWithEncryptionMetadataTypeName
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> =
		cached().let { cachedKeys ->
			hashes.mapNotNull { secDelKey ->
				cachedKeys.dataByDelegationKey[secDelKey]?.let { cachedData ->
					val decryptedContent = ensureNonNull(cachedData.decryptedContentAndVerificationStatus) {
						"Data with id ${cachedData.exchangeData.id} was accessible through secure delegation key so it should have been decrypted"
					}.first
					secDelKey to ExchangeDataWithUnencryptedContent(cachedData.exchangeData, decryptedContent)
				}
			}.toMap()
		}

	override suspend fun getDecryptionDataById(
		id: String,
		retrieveIfNotCached: Boolean
	): ExchangeDataWithPotentiallyDecryptedContent? =
		cache.getCachedOrRetrieve {
			throw InternalCardinalException("Fully cached exchange data manager has no value")
		}.first.let { cachedKeys ->
			cachedKeys.dataById[id]?.let { cachedData ->
				val decryptedContent = cachedData.decryptedContentAndVerificationStatus?.first
				ExchangeDataWithPotentiallyDecryptedContent(cachedData.exchangeData, decryptedContent)
			}
		}

	/**
	 * Method fails if unsuccessful, but cache continues using the old data
	 */
	override suspend fun clearOrRepopulateCache() {
		// Keep using the old cache if it fails
		cache.update {
			ensureNonNull(it) { "Cache for fully cached exchange data manager can't be null" }
			val updatedCache = kotlin.runCatching { getAllKeysInfo() }
			if (updatedCache.isSuccess) {
				updatedCache.getOrThrow() to CacheUpdateResult.Success
			} else {
				it to CacheUpdateResult.Failure(updatedCache.exceptionOrNull()!!)
			}
		}
	}

	/**
	 * Fails if unsuccessful
	 */
	suspend fun initializeCache() {
		cache.update { getAllKeysInfo() to CacheUpdateResult.Success }
	}

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String> =
		cached().entityTypeToAccessControlKeysValue.getValue(entityType).first

	override suspend fun getAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<SecureDelegationKeyString> =
		cached().entityTypeToAccessControlKeysValue.getValue(entityType).second

	private suspend fun getAllKeysInfo(): CachedKeys {

		val cacheById = mutableMapOf<String, CachedExchangeDataDetails>()
		val cacheByHash = mutableMapOf<SecureDelegationKeyString, CachedExchangeDataDetails>()
		val cacheByDelegateId = mutableMapOf<String, CachedExchangeDataDetails>()
		val allAccessControlSecrets = mutableListOf<AccessControlSecret>()
		ensureNonNull(base.getAllExchangeDataForCurrentDataOwnerIfAllowed()) {
			"Could not get all exchange data of current data owner"
		}.forEach { exchangeData ->
			val decryptedInfo = decryptData(exchangeData)
			if (decryptedInfo != null) {
				val cachedDetails = CachedExchangeDataDetails(
					exchangeData,
					Pair(
						UnencryptedExchangeDataContent(
							exchangeKey = decryptedInfo.exchangeKey,
							accessControlSecret = decryptedInfo.accessControlSecret,
							sharedSignatureKey = decryptedInfo.sharedSignatureKey
						),
						decryptedInfo.verified
					)
				)
				cacheById[exchangeData.id] = cachedDetails
				decryptedInfo.accessControlSecret.allAccessControlKeys(cryptoService).forEach {
					cacheByHash[it.toSecureDelegationKeyString(cryptoService)] = cachedDetails
				}
				if (decryptedInfo.verified) {
					cacheByDelegateId[exchangeData.delegate] = cachedDetails
				}
				allAccessControlSecrets.add(decryptedInfo.accessControlSecret)
			} else {
				cacheById[exchangeData.id] = CachedExchangeDataDetails(exchangeData, null)
			}
		}
		val encodedAccessControlKeysCache = EntityWithEncryptionMetadataTypeName.entries.associateWith {
			allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) }.encodeAsAccessControlHeaders() to
				allAccessControlSecrets.map { s -> s.toSecureDelegationKeyFor(it, cryptoService) }
		}
		return CachedKeys(
			dataById = cacheById,
			dataByDelegationKey = cacheByHash,
			verifiedDataByDelegateId = cacheByDelegateId,
			entityTypeToAccessControlKeysValue = encodedAccessControlKeysCache
		)
	}

	private suspend fun cached(): CachedKeys = cache.getCachedOrRetrieve {
		throw InternalCardinalException("Fully cached exchange data manager has no value")
	}.first
}
