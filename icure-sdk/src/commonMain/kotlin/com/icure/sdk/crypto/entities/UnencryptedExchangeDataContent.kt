package com.icure.sdk.crypto.entities

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.sdk.model.AccessControlSecret
import com.icure.sdk.utils.InternalIcureApi

/**
 * A container for the unencrypted content of some exchange data (it could have been decrypted from some retrieved
 * exchange data, or it is the content before encryption).
 * @param accessControlSecret the access control secret of the exchange data.
 * @param exchangeKey the exchange key of the exchange data.
 * @param sharedSignatureKey the shared signature key of the exchange data.
 */
@InternalIcureApi
data class UnencryptedExchangeDataContent(
	val exchangeKey: AesKey,
	val accessControlSecret: AccessControlSecret,
	val sharedSignatureKey: HmacKey<HmacAlgorithm.HmacSha512>
)