package com.icure.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AuthenticationToken(
    public val token: String? = null,
    public val creationTime: Long,
    public val validity: Long,
    public val deletionDate: Long? = null,
) {
	// region AuthenticationToken-AuthenticationToken

	// endregion
}
