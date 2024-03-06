package com.icure.sdk.model.security

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class TokenWithGroup(
  public val token: String,
  public val groupId: String,
  public val groupName: String? = null,
)
