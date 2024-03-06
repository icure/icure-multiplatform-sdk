package com.icure.sdk.model.base

import java.time.Instant
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class NotificationEvent(
  public val date: Instant? = null,
  public val status: NotificationEvent.Status? = null,
) : IoSerializable
