package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class LoginCredentials(
  public val username: String? = null,
  public val password: String? = null,
)
