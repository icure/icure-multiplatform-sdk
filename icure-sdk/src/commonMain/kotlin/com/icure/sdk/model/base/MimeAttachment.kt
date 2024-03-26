package com.icure.sdk.model.base

import kotlin.ByteArray
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class MimeAttachment(
  public val `data`: ByteArray? = null,
  public val fileName: String? = null,
  public val mimeType: String? = null,
)
