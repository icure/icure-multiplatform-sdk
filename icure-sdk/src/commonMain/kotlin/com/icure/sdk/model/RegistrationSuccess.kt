package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RegistrationSuccess(
  public val groupId: String,
  public val userId: String,
  public val token: String,
)
