package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.crypto.BasicCryptoApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.InternalCryptoApi
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.utils.InternalIcureApi


@InternalIcureApi
class InternalCryptoApiImpl(
	override val entity: EntityEncryptionService,
	override val primitives: CryptoService,
	override val exchangeDataManager: ExchangeDataManager,
	override val jsonEncryption: JsonEncryptionService
) : InternalCryptoApi

@InternalIcureApi
class BasicCryptoApiImpl(
	override val jsonEncryption: JsonEncryptionService,
	override val validationService: EntityEncryptionService
) : BasicCryptoApi