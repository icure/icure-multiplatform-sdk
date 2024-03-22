package com.icure.sdk.model.requests.document

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class AttachmentMetadata(
  public val utis: List<String> = emptyList(),
  public val dataIsEncrypted: Boolean? = null,
)
