package com.icure.sdk.model.security

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Enable2faRequest(
  public val secret: String,
)
