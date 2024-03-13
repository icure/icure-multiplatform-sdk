package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class JwtPayload(
  public val jwt: String,
)
