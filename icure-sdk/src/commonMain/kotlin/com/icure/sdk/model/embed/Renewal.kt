package com.icure.sdk.model.embed

import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public data class Renewal(
  public val decimal: Int? = null,
  public val duration: Duration? = null,
)
