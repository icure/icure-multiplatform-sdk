package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Suspension(
  public val beginMoment: Long? = null,
  public val endMoment: Long? = null,
  public val suspensionReason: String? = null,
  public val lifecycle: String? = null,
) : IoSerializable
