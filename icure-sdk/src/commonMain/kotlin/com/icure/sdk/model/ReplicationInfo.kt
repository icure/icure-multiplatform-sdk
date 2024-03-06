package com.icure.sdk.model

import kotlin.Boolean
import kotlin.Int
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class ReplicationInfo(
  public val active: Boolean,
  public val running: Boolean,
  public val pendingFrom: Int? = null,
  public val pendingTo: Int? = null,
) : IoSerializable
