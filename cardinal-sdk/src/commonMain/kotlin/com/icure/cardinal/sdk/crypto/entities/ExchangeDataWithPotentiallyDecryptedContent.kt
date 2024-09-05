package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.utils.InternalIcureApi

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