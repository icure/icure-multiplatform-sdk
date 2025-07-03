package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable

/**
 * The raw decrypted content of an exchange data.
 * @param exchangeDataId the id of the exchange data.
 * @param exchangeKey the raw exchange key of the exchange data.
 * @param accessControlSecret the raw access control secret of the exchange data.
 * @param sharedSignatureKey the raw shared signature key of the exchange data.
 */

@Serializable
class RawDecryptedExchangeData(
	val exchangeDataId: String,
	@Serializable(with = ByteArraySerializer::class)
	val exchangeKey: ByteArray,
	@Serializable(with = ByteArraySerializer::class)
	val accessControlSecret: ByteArray,
	@Serializable(with = ByteArraySerializer::class)
	val sharedSignatureKey: ByteArray
)
