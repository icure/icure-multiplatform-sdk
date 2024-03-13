package com.icure.sdk.model.base

import java.time.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class NotificationEvent(
  public val date: Instant? = null,
  public val status: NotificationEvent.Status? = null,
)
