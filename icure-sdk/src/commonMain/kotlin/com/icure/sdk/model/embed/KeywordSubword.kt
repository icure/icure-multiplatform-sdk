package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class KeywordSubword(
  public val `value`: String? = null,
  public val subWords: List<KeywordSubword>? = null,
) : IoSerializable
