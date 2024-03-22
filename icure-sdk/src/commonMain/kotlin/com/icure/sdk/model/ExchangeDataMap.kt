package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeDataMap(
    val id: SecureDelegationKeyString,
    val rev: String? = null,
    val encryptedExchangeDataIds: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
    val deletionDate: Long? = null,
)