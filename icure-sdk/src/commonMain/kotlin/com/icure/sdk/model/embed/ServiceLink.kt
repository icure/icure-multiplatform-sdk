package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ServiceLink(
  public val serviceId: String? = null,
  public val service: Service? = null,
)
