package com.icure.sdk.model.embed

import kotlin.Int
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Renewal(
  public val decimal: Int? = null,
  public val duration: Duration? = null,
) : IoSerializable
