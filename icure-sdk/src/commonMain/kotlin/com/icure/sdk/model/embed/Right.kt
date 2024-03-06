package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Right(
  public val userId: String? = null,
  public val read: Boolean = false,
  public val write: Boolean = false,
  public val administration: Boolean = false,
) : IoSerializable
