package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.utils.InternalIcureApi

/**
 * A container for exchange data and, if the SDK could decrypt the exchange data content, its unencrypted content.
 */
@InternalIcureApi
sealed interface ExchangeDataWithPotentiallyDecryptedContent {
	/**
	 * some exchange data
	 */
	val exchangeData: ExchangeData

	/**
	 * the unencrypted content of the exchange data if it could be decrypted, else null
	 */
	val unencryptedContent: UnencryptedExchangeDataContent?
}

/**
 * A container for the exchange data and its unencrypted content.
 * @param exchangeData the exchange data.
 * @param unencryptedContent the unencrypted content of the exchange data.
 */
@InternalIcureApi
data class ExchangeDataWithUnencryptedContent(
	override val exchangeData: ExchangeData,
	override val unencryptedContent: UnencryptedExchangeDataContent
) : ExchangeDataWithPotentiallyDecryptedContent

/**
 * A container for the exchange data that couldn't be decrypted
 */
@InternalIcureApi
data class UndecryptableExchangeData(
	override val exchangeData: ExchangeData
) : ExchangeDataWithPotentiallyDecryptedContent {
	override val unencryptedContent: Nothing? get() = null
}