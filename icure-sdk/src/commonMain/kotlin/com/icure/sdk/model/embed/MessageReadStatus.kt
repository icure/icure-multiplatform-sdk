package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class MessageReadStatus(
  public val time: Long? = null,
  public val read: Boolean = false,
) : IoSerializable
