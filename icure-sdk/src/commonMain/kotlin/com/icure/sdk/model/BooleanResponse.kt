package com.icure.sdk.model

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public data class BooleanResponse(
  public val response: Boolean,
)
