package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Suspension(
  public val beginMoment: Long? = null,
  public val endMoment: Long? = null,
  public val suspensionReason: String? = null,
  public val lifecycle: String? = null,
)
