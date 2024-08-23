package com.icure.sdk.crypto

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.DataOwnerApi
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface InternalCryptoServices : BasicInternalCryptoApi{
	suspend fun forceReload()

	val entity: EntityEncryptionService
	val primitives: CryptoService
	val exchangeDataManager: ExchangeDataManager
	val exchangeKeysManager: ExchangeKeysManager
	val delegationsDeAnonymization: DelegationsDeAnonymization
	val dataOwnerApi: DataOwnerApi
	val userEncryptionKeysManager: UserEncryptionKeysManager
	val recoveryDataEncryption: RecoveryDataEncryption
	val headersProvider: AccessControlKeysHeadersProvider
	val strategies: CryptoStrategies

	override val validationService: EntityValidationService
		get() = entity

	override val entityAccessInformationProvider: EntityAccessInformationProvider
		get() = delegationsDeAnonymization
}

@InternalIcureApi
interface BasicInternalCryptoApi {
	val jsonEncryption: JsonEncryptionService
	val validationService: EntityValidationService
	val entityAccessInformationProvider: EntityAccessInformationProvider
}