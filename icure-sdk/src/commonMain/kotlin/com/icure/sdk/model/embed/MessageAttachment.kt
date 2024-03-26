package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class MessageAttachment(
  public val type: DocumentLocation? = null,
  public val ids: List<String> = emptyList(),
)
