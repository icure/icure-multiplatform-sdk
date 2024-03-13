package com.icure.sdk.model.base

import kotlinx.serialization.Serializable

@Serializable
public data class Security(
  public val admins: Security.Right,
  public val members: Security.Right,
)
