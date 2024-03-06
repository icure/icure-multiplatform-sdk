package com.icure.sdk.model

import kotlin.Number
import kotlin.String
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class IndexingInfo(
  public val statuses: Map<String, Number>? = null,
) : IoSerializable
