package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

/**
 * The raw decrypted content of an exchange data.
 * @param exchangeKey the raw exchange key of the exchange data.
 * @param accessControlSecret the raw access control secret of the exchange data.
 * @param sharedSignatureKey the raw shared signature key of the exchange data.
 */
@InternalIcureApi
data class RawDecryptedExchangeData(
	val exchangeKey: ByteArray,
	val accessControlSecret: ByteArray,
	val sharedSignatureKey: ByteArray
) {
	override fun hashCode(): Int {
		throw UnsupportedOperationException("There should be no reason to use `hashCode` for this class")
	}

	override fun equals(other: Any?): Boolean {
		throw UnsupportedOperationException("There should be no reason to use `equals` for this class")
	}
}