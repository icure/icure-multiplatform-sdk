package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.DelegationsDeAnonymization
import com.icure.sdk.crypto.EntityAccessInformationProvider
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ExchangeKeysManager
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.RecoveryDataEncryption
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.utils.InternalIcureApi


/**
 * Groups all the internal crypto services.
 */
@InternalIcureApi
class InternalCryptoApiImpl(
	override val entity: EntityEncryptionService,
	override val primitives: CryptoService,
	override val exchangeDataManager: ExchangeDataManager,
	override val exchangeKeysManager: ExchangeKeysManager,
	override val jsonEncryption: JsonEncryptionService,
	override val delegationsDeAnonymization: DelegationsDeAnonymization,
	override val dataOwnerApi: DataOwnerApi,
	override val userEncryptionKeysManager: UserEncryptionKeysManager,
	override val recoveryDataEncryption: RecoveryDataEncryption
) : InternalCryptoServices {
	/**
	 * Deletes all cached data in crypto services and reloads as needed.
	 */
	override suspend fun forceReload() {
		dataOwnerApi.clearCurrentDataOwnerIdsCache()
		userEncryptionKeysManager.reloadKeys()
		exchangeDataManager.clearOrRepopulateCache()
	}
}

@InternalIcureApi
class BasicInternalCryptoApiImpl(
	override val jsonEncryption: JsonEncryptionService,
	override val validationService: EntityValidationService,
) : BasicInternalCryptoApi {
	override val entityAccessInformationProvider: EntityAccessInformationProvider get() =
		BasicEntityAccessInformationProvider
}
