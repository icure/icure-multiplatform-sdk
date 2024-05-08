package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BaseExchangeDataManager
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.UserSignatureKeysManager
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.LruCacheWithAsyncRetrieve
import com.icure.sdk.utils.ResourceNotFoundException
import com.icure.sdk.utils.SynchronisedLruCache

@InternalIcureApi
class CachedLruExchangeDataManager(
	base: BaseExchangeDataManager,
	userEncryptionKeys: UserEncryptionKeysManager,
	signatureKeys: UserSignatureKeysManager,
	cryptoStrategies: CryptoStrategies,
	dataOwnerApi: DataOwnerApi,
	cryptoService: CryptoService,
	useParentKeys: Boolean,
	maxCacheSize: Int,
) : AbstractExchangeDataManager(
	base,
	userEncryptionKeys,
	signatureKeys,
	cryptoStrategies,
	dataOwnerApi,
	cryptoService,
	useParentKeys
) {
	private val exchangeDataByIdCache: LruCacheWithAsyncRetrieve<String, CachedExchangeDataDetails> =
		LruCacheWithAsyncRetrieve(maxCacheSize)
	private val delegateToVerifiedExchangeDataId: LruCacheWithAsyncRetrieve<String, String> =
		LruCacheWithAsyncRetrieve(maxCacheSize)
	private val secureDelegationKeysToExchangeDataId: SynchronisedLruCache<SecureDelegationKeyString, String> =
		SynchronisedLruCache(maxCacheSize)

	override suspend fun getOrCreateEncryptionDataTo(
		delegateId: String,
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		val verifiedExchangeDataId = delegateToVerifiedExchangeDataId.getCachedOrRetrieve(
			delegateId,
			validate = { getOrRetrieveExchangeDataWithId(it).decryptedContentAndVerificationStatus?.second == true },
		) {
			base.getExchangeDataByDelegatorDelegatePair(
				dataOwnerApi.getCurrentDataOwnerId(),
				delegateId
			).firstOrNull {
				getOrRetrieveExchangeDataWithId(it.id).decryptedContentAndVerificationStatus?.second == true
			}?.id ?: createAndCacheNewExchangeData(delegateId, allowCreationWithoutDelegateKey).exchangeData.id
		}
		val cachedDetails = getOrRetrieveExchangeDataWithId(verifiedExchangeDataId)
		return cachedDetails.decryptedContentAndVerificationStatus?.takeIf { it.second }?.let {
			ExchangeDataWithUnencryptedContent(
				cachedDetails.exchangeData,
				it.first
			)
		} ?: throw AssertionError("Exchange data with id $verifiedExchangeDataId should be decrypted and verified")
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Collection<SecureDelegationKeyString>,
		entityType: EntityWithEncryptionMetadataTypeName
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

	override suspend fun getDecryptionDataById(
		id: String,
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

	override suspend fun clearOrRepopulateCache() {
		exchangeDataByIdCache.clear()
		delegateToVerifiedExchangeDataId.clear()
		secureDelegationKeysToExchangeDataId.clear()
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

	private suspend fun createAndCacheNewExchangeData(delegateId: String, allowCreationWithoutDelegateKey: Boolean): CachedExchangeDataDetails =
		createNewExchangeData(delegateId, null, allowCreationWithoutDelegateKey).let {
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
