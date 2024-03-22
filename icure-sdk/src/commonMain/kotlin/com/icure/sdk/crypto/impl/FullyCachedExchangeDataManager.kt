package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BaseExchangeDataManager
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.UserSignatureKeysManager
import com.icure.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.sdk.model.specializations.AccessControlKeyHexString
import com.icure.sdk.model.specializations.AccessControlSecret
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.SingleValueAsyncCache
import com.icure.sdk.utils.base64Encode
import com.icure.sdk.utils.concat
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.ensureNonNull

@InternalIcureApi
class FullyCachedExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	signatureKeys: UserSignatureKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean
) : AbstractExchangeDataManager(
	base,
	userEncryptionKeys,
	signatureKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	useParentKeys
) {
	companion object {
		// Conservative value obtained by assuming a maximum allowed size for headers of 8kb (popular choice amongst
		// various clients and servers)
		// Multiple of 3 to avoid any padding in base64 encoding
		const val MAX_ACCESS_CONTROL_KEYS_PER_HEADER = 360
	}
	private data class CachedKeys(
		val dataById: Map<String, CachedExchangeDataDetails>,
		val dataByDelegationKey: Map<SecureDelegationKeyString, CachedExchangeDataDetails>,
		val verifiedDataByDelegateId: Map<String, CachedExchangeDataDetails>,
		val entityTypeToAccessControlKeysValue: Map<EntityWithDelegationTypeName, List<Base64String>>
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
						entityTypeToAccessControlKeysValue = EntityWithDelegationTypeName.entries.associateWith {
							encodeAccessControlKeys(allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) })
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
		entityType: EntityWithDelegationTypeName
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
			throw InternalIcureException("Fully cached exchange data manager has no value")
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
	suspend fun initialiseCache() {
		cache.update { getAllKeysInfo() to CacheUpdateResult.Success }
	}

	override suspend fun getAccessControlKeysValue(entityType: EntityWithDelegationTypeName): List<Base64String> =
		cached().entityTypeToAccessControlKeysValue.getValue(entityType)

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
		val encodedAccessControlKeysCache = EntityWithDelegationTypeName.entries.associateWith {
			encodeAccessControlKeys(allAccessControlSecrets.map { s -> s.toAccessControlKeyStringFor(it, cryptoService) })
		}
		return CachedKeys(
			dataById = cacheById,
			dataByDelegationKey = cacheByHash,
			verifiedDataByDelegateId = cacheByDelegateId,
			entityTypeToAccessControlKeysValue = encodedAccessControlKeysCache
		)
	}

	private suspend fun cached(): CachedKeys = cache.getCachedOrRetrieve {
		throw InternalIcureException("Fully cached exchange data manager has no value")
	}.first

	private fun encodeAccessControlKeys(accessControlKeys: List<AccessControlKeyHexString>): List<Base64String> =
		accessControlKeys.chunked(MAX_ACCESS_CONTROL_KEYS_PER_HEADER).map { chunk ->
			chunk.map { it.bytes() }.concat().base64Encode()
		}
}