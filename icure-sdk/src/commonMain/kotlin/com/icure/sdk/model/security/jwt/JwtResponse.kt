package com.icure.sdk.model.security.jwt

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class JwtResponse(
  public val token: String? = null,
  public val refreshToken: String? = null,
  public val successful: Boolean,
)
