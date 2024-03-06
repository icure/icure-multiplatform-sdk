package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Country(
  public val code: String? = null,
  public val name: Map<String, String>? = null,
) : IoSerializable
