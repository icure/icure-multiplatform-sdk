package com.icure.sdk.model.base

import kotlin.ByteArray
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class MimeAttachment(
  public val `data`: ByteArray? = null,
  public val fileName: String? = null,
  public val mimeType: String? = null,
) : IoSerializable
