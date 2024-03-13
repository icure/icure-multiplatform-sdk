package com.icure.sdk.model.base

import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public annotation class EnumVersion(
  public val `value`: Long,
)
