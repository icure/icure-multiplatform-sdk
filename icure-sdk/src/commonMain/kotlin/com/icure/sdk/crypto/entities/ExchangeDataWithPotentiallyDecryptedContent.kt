package com.icure.sdk.crypto.entities

import com.icure.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.utils.InternalIcureApi

/**
 * A container for exchange data and, if the SDK could decrypt the exchange data content, its unencrypted content.
 * @param exchangeData some exchange data
 * @param decryptedContent the unencrypted content of the exchange data if it could be decrypted, else null
 */
@InternalIcureApi
data class ExchangeDataWithPotentiallyDecryptedContent(
	val exchangeData: ExchangeData,
	val decryptedContent: UnencryptedExchangeDataContent?,
)