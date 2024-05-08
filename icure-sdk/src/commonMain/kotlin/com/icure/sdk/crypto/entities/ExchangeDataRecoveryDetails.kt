package com.icure.sdk.crypto.entities

import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Information on some exchange data and its decrypted content.
 */
@Serializable
@InternalIcureApi
// Keep name of parameters for compatibility with typescript SDK
data class ExchangeDataRecoveryDetails(
	val exchangeDataId: String,
	val rawAccessControlSecret: Base64String,
	val rawSharedSignatureKey: Base64String,
	val rawExchangeKey: Base64String
)