package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Delegation(
  public val owner: String? = null,
  public val delegatedTo: String? = null,
  public val key: String? = null,
  public val tags: List<String> = emptyList(),
) : IoSerializable
