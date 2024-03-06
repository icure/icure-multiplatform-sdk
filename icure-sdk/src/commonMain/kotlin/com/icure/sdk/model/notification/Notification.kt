package com.icure.sdk.model.notification

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Notification(
  public val eventType: Subscription.EventType,
  public val entityClass: String,
  public val entity: Identifiable<String>,
)
