package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.utils.InternalIcureApi

/**
 * A container for the exchange data and its unencrypted content.
 * @param exchangeData the exchange data.
 * @param unencryptedContent the unencrypted content of the exchange data.
 */
@InternalIcureApi
data class ExchangeDataWithUnencryptedContent(
	val exchangeData: ExchangeData,
	val unencryptedContent: UnencryptedExchangeDataContent
)