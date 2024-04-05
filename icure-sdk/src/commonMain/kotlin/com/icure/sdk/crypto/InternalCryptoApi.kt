package com.icure.sdk.crypto

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface InternalCryptoApi : BasicCryptoApi{
	val entity: EntityEncryptionService
	val primitives: CryptoService
	val exchangeDataManager: ExchangeDataManager

	override val validationService: EntityValidationService
		get() = entity
}

@InternalIcureApi
interface BasicCryptoApi {
	val jsonEncryption: JsonEncryptionService
	val validationService: EntityValidationService
}