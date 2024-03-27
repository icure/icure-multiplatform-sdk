package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Payment(
    public val paymentDate: Long = 0,
    public val paymentType: PaymentType? = null,
    public val paid: Double? = null,
) {
    // region Payment-Payment

    // endregion
}
