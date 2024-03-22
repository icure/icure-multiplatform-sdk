package com.icure.sdk.model.base

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class NotificationEvent(
  @Serializable(with = icure.sdk.serialization.InstantSerializer::class)
  public val date: Instant? = null,
  public val status: NotificationEvent.Status? = null,
)
