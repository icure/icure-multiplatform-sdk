package com.icure.sdk.model.security.jwt

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class JwtResponse(
  public val token: String? = null,
  public val refreshToken: String? = null,
  public val successful: Boolean,
) {
	// region JwtResponse-JwtResponse
	// endregion
}