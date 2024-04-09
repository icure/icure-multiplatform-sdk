package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BasicCryptoApi
import com.icure.sdk.crypto.DelegationsDeAnonymization
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.InternalCryptoApi
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.utils.InternalIcureApi


@InternalIcureApi
class InternalCryptoApiImpl(
	override val entity: EntityEncryptionService,
	override val primitives: CryptoService,
	override val exchangeDataManager: ExchangeDataManager,
	override val jsonEncryption: JsonEncryptionService,
	override val delegationsDeAnonymization: DelegationsDeAnonymization,
	private val userEncryptionKeysManager: UserEncryptionKeysManager,
	private val dataOwnerApi: DataOwnerApi
) : InternalCryptoApi {
	override suspend fun forceReload() {
		dataOwnerApi.clearCurrentDataOwnerIdsCache()
		userEncryptionKeysManager.reloadKeys()
		exchangeDataManager.clearOrRepopulateCache()
	}
}

@InternalIcureApi
class BasicCryptoApiImpl(
	override val jsonEncryption: JsonEncryptionService,
	override val validationService: EntityEncryptionService
) : BasicCryptoApi