package com.icure.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class TokenWithGroup(
    public val token: String,
    public val groupId: String,
    public val groupName: String? = null,
)
