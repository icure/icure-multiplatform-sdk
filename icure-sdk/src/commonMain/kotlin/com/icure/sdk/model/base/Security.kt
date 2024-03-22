package com.icure.sdk.model.base

import kotlinx.serialization.Serializable

@Serializable
public data class Security(
  public val admins: Right = Right(),
  public val members: Right = Right(),
)
