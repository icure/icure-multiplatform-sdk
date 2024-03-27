package com.icure.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicationInfo(
    public val active: Boolean,
    public val running: Boolean,
    public val pendingFrom: Int? = null,
    public val pendingTo: Int? = null,
)
