package com.icure.cardinal.sdk.crypto.fake

import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
object NoExchangeDataManager : ExchangeDataManager {
	override val base: BaseExchangeDataManager
		get() = TODO("Not yet implemented")

	override suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString) {
		TODO("Not yet implemented")
	}

	override suspend fun getOrCreateEncryptionDataTo(
		delegateId: String,
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		TODO("Not yet implemented")
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Collection<SecureDelegationKeyString>,
		entityType: EntityWithEncryptionMetadataTypeName
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> {
		TODO("Not yet implemented")
	}

	override suspend fun getDecryptionDataById(
		id: String,
		retrieveIfNotCached: Boolean
	): ExchangeDataWithPotentiallyDecryptedContent? {
		TODO("Not yet implemented")
	}

	override suspend fun clearOrRepopulateCache() {
		TODO("Not yet implemented")
	}

	override suspend fun getEncodedAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<Base64String>? {
		TODO("Not yet implemented")
	}

	override suspend fun getAccessControlKeysValue(entityType: EntityWithEncryptionMetadataTypeName): List<SecureDelegationKeyString>? {
		TODO("Not yet implemented")
	}
}