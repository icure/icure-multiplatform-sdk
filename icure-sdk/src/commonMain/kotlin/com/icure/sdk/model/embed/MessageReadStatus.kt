package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public data class MessageReadStatus(
  public val time: Long? = null,
  public val read: Boolean = false,
)
