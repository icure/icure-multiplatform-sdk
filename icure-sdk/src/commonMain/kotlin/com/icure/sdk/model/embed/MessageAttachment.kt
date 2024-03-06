package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class MessageAttachment(
  public val type: DocumentLocation? = null,
  public val ids: List<String> = emptyList(),
) : IoSerializable
