package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DataOwnerRegistrationSuccess(
  public val userLogin: String,
  public val userId: String,
  public val token: String,
)
