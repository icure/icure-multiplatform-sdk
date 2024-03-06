package com.icure.sdk.model.base

import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Security(
  public val admins: Security.Right,
  public val members: Security.Right,
) : IoSerializable
