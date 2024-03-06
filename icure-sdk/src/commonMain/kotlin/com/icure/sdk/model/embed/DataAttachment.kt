package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class DataAttachment(
  public val couchDbAttachmentId: String? = null,
  public val objectStoreAttachmentId: String? = null,
  public val utis: List<String> = emptyList(),
) : IoSerializable
