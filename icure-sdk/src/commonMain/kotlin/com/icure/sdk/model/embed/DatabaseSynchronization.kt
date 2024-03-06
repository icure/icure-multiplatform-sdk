package com.icure.sdk.model.embed

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class DatabaseSynchronization(
  public val source: String? = null,
  public val target: String? = null,
  public val filter: String? = null,
  public val localTarget: DatabaseSynchronization.Target? = null,
) : IoSerializable
