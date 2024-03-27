package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RecoveryData(
    override val id: String,
    override val rev: String? = null,
    public val recipient: String,
    public val encryptedSelf: String,
    public val type: Type,
    public val expirationInstant: Long? = null,
    override val deletionDate: Long? = null,
) : StoredDocument {
    @Serializable
    public enum class Type() {
        @SerialName("KEYPAIR_RECOVERY")
        KeypairRecovery,

        @SerialName("EXCHANGE_KEY_RECOVERY")
        ExchangeKeyRecovery,
    }
}
